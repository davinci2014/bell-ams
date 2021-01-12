<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>统一认证页面</title>

    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <script type="text/javascript" src="/static/layui/layui.all.js"></script>

    <link rel="stylesheet" href="/static/css/authentication/login/login.css">
</head>
<body>
<div class="layui-tab layui-tab-card login-box">
    <ul class="layui-tab-title">
        <li class="layui-this">账号登录</li>
        <li>钉钉扫码</li>
        <li>微信扫码</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">
            <form class="layui-form">
                <div class="layui-form-item">
                    <input type="text" class="layui-input" name="username" placeholder="请输入用户名" autocomplete="off">
                </div>
                <div class="layui-form-item">
                    <input type="password" class="layui-input" name="password" placeholder="请输入密码" autocomplete="off">
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" type="submit" lay-submit lay-filter="username-password-login">登录</button>
                </div>
                <div class="layui-form-item">
                    <a href="javascript:" id="oauth2-login-qq">
                        <img class="oauth2-login-icon" src="/static/images/authentication/login/QQ.png">
                    </a>
                </div>
            </form>
        </div>
        <div class="layui-tab-item">
            开发中...
        </div>
        <div class="layui-tab-item">
            开发中...
        </div>
    </div>
</div>
<script type="text/javascript">
    "use strict";

    layui.use(["jquery", "element", "layer", "form"], function () {
        let $ = layui.jquery, element = layui.element, layer = layui.layer, form = layui.form;

        bindEvents();

        function bindEvents() {
            $("#oauth2-login-qq").on("click", function () {
                $.ajax("/test?abc", {
                    type: "get",
                    success: function (response) {
                        console.info(response)
                    },
                    error: function (response) {
                        console.info(response);
                    }
                });
                layer.confirm("Oauth2 QQ", {
                    btn: ["关闭"]
                });
            });

            form.on("submit(username-password-login)", function(data){
                console.log(data.elem);
                console.log(data.form);
                console.log(data.field);

                return false;
            });
        }
        

        function login() {
            // "/authentication/login"

        }
    });
</script>
</body>
</html>