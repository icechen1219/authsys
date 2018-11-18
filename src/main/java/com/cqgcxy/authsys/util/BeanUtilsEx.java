package com.cqgcxy.authsys.util;


import net.sf.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用cglib的BeanCopier替代apache的BeanUtils，提升效率
 *
 * @author icechen1219
 * @date 2018/11/17
 */
public class BeanUtilsEx {

    /**
     * 静态缓存，提升BeanCopier对象的创建效率
     */
    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new HashMap<>();


    /**
     * 对象属性复制
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object source, Object target) {
        if (source == null || target == null) {
            throw new RuntimeException("参数不能为null！");
        }
        String beanKey = generateKey(source.getClass(), target.getClass());

        BeanCopier copier = null;

        if (!BEAN_COPIER_MAP.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIER_MAP.put(beanKey, copier);
        } else {
            copier = BEAN_COPIER_MAP.get(beanKey);
        }

        copier.copy(source, target, null);

    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }
}
