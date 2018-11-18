///:ReflectionUtil.java
package com.cqgcxy.authsys.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 反射工具类
 *
 * @author sagachen created at 2017年10月7日
 * @version 1.0
 */
public class ReflectionUtil {
    private static Map<String, Method> methodMap = new HashMap<>();

    /**
     * 克隆pojo，要求两个对象具备同一类型
     *
     * @param from 源对象
     * @param to   目标对象
     * @throws Exception
     */
    public static void deepClonePojo(Object from, Object to) throws Exception {
        if (from == null || to == null) {
            throw new RuntimeException("要求两个参数必须都不为null！");
        }
        if (!from.getClass().equals(to.getClass())) {
            throw new RuntimeException("要求两个参数必须是同一个类的对象！");
        }
        Class<?> fromClass = from.getClass();
        Field[] fields = fromClass.getDeclaredFields();
        for (Field prop : fields) {
            Method getMethod = guessGetMethod(fromClass, prop);
            getMethod.setAccessible(true);
            Object value = getMethod.invoke(from);
            if (value != null) {
                Method setMethod = guessSetMethod(fromClass, prop);
                setMethod.setAccessible(true);
                setMethod.invoke(to, value);
            }

        }
    }

    /**
     * 简单拷贝对象属性，不要求对象类型一致，但具备相同的getter/setter
     *
     * @param from
     * @param to
     * @throws Exception
     */
    public static void simpleClonePojo(Object from, Object to) throws Exception {
        if (from == null || to == null) {
            throw new RuntimeException("要求两个参数必须都不为null！");
        }
        Class<?> toClass = to.getClass();
        Field[] fields = toClass.getDeclaredFields();
        for (Field prop : fields) {
            Method getMethod = guessGetMethod(from.getClass(), prop);
            if (getMethod == null) {
                continue;
            }
            getMethod.setAccessible(true);
            Object value = getMethod.invoke(from);
            if (value != null) {
                Method setMethod = guessSetMethod(toClass, prop);
                if (setMethod == null) {
                    continue;
                }
                setMethod.setAccessible(true);
                setMethod.invoke(to, value);
            }

        }
    }

    /**
     * 根据属性名猜get方法
     *
     * @param entityClass
     * @param field
     * @return
     */
    public static Method guessGetMethod(Class<?> entityClass, Field field) {
        String cacheKey = entityClass.getSimpleName() + "get" + field.getName();
        Method cacheMethod = methodMap.get(cacheKey);
        if (cacheMethod != null) {
            return cacheMethod;
        }
        String prefix = "get";
        if (boolean.class.equals(field.getType()) || Boolean.class.equals(field.getType())) {
            prefix = "is";
        }
        String methodName = prefix + StringUtil.upperFirstChar(field.getName());

        try {
            Method firstMethod = entityClass.getDeclaredMethod(methodName);
            methodMap.put(cacheKey, firstMethod);
            return firstMethod;
        } catch (NoSuchMethodException e) {
            methodName = prefix + field.getName();
            try {
                Method secondMethod = entityClass.getDeclaredMethod(methodName);
                methodMap.put(cacheKey, secondMethod);
                return secondMethod;
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据属性名猜set方法
     *
     * @param entityClass
     * @param field
     * @return
     */
    public static Method guessSetMethod(Class<?> entityClass, Field field) {
        String cacheKey = entityClass.getSimpleName() + "set" + field.getName();
        Method cacheMethod = methodMap.get(cacheKey);
        if (cacheMethod != null) {
            return cacheMethod;
        }
        String methodName = "set" + StringUtil.upperFirstChar(field.getName());

        try {
            return entityClass.getDeclaredMethod(methodName, field.getType());
        } catch (NoSuchMethodException e) {
            methodName = "set" + field.getName();
            try {
                Method firstMethod = entityClass.getDeclaredMethod(methodName, field.getType());
                methodMap.put(cacheKey, firstMethod);
                return firstMethod;
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (SecurityException e1) {
                e1.printStackTrace();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/// :ReflectionUtil.java