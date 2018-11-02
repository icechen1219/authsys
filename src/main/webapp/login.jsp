<%--
  Created by IntelliJ IDEA.
  User: icechen1219
  Date: 2018/10/28
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/plugins/jquery/jquery-1.12.4.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        ul, li {
            list-style: none;
        }

        .login {
            position: relative;
            top: 150px;
            left: 300px;
            width: 300px;
            border: #003277 solid 1px;
        }

        .login ul {
            width: 300px;
        }

        .login li {
            width: 150px;
            margin-top: 20px;
            /*border: red solid 1px;*/
            float: left;
        }

        .login input, .login label, .login button {
            width: 150px;
            height: 25px;
            line-height: 25px;
        }

        .reg{
            position: relative;
            top: 150px;
            left: 300px;
            width: 300px;
            border: #003277 solid 1px;
            display: none;
        }

    </style>
    <script>
        $(function () {
            $("button[type='submit']").on("click", function () {
                var pwd1 = $(".reg input[name='password']").val();
                var pwd2 = $(".reg #confirmpwd").val();
                console.log(pwd1);
                console.log(pwd2)
                if (pwd1 !== pwd2) {
                    alert("两次密码不一致，请重新输入！")
                    $("#confirmpwd").val("");
                    $("#confirmpwd").focus();
                    return false;
                }
            })

            $("#gotoreg,#gotologin").on("click",function () {
                $(".login").toggle();
                $(".reg").toggle();
            })
        })
    </script>
</head>
<body>
<div class="login">
    <form action="/login" method="post">
        <ul>
            <li><label for="username">用户名</label></li>
            <li><input type="text" id="username" name="username" value="admin"></li>
            <li><label for="password">密码</label></li>
            <li><input type="password" id="password" name="password" value="111111"></li>
            <li>
                <button type="submit">login</button>
            </li>
            <li>
                <button type="reset">cancel</button>
            </li>
        </ul>
    </form>
    <a href="#" id="gotoreg">还没帐号？去注册</a>
</div>
<div class="reg">
    <form action="/register" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" id="confirmpwd"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" name="realName"></td>
            </tr>
            <tr>
                <td>身份证</td>
                <td><input type="text" name="idcardNo"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <select name="sex" id="sex">
                        <option value="-1" selected>--请选择--</option>
                        <option value="0">保密</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>手机</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><button type="submit">立即注册</button></td>
                <td><button type="reset">重置</button></td>
            </tr>
        </table>
    </form>
    <a href="#" id="gotologin">已有帐号？去登录</a>
</div>
</body>
</html>
