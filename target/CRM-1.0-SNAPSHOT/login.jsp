<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/2
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme() + "://" + request.getScheme() + ":"+
        request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>

<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function(){
            //清空内容
            $("#loginAct").val("");
            //页面加载完毕后，让用户的文本框自动获得焦点
            $("#loginAct").focus();

            //为登录按钮绑定事件，执行登录操作
            $("#submitBtn").click(function(event){
                login();
            })

            //为当前登录页窗口绑定键盘敲击事件
            //event这个参数可以取得我们敲的时那个键
            $(window).keydown(function(event){
                if(  event.keyCode==13){
                    login();
                }
            })
        })

        //验证账号密码不能为空
        //取得账号密码
        //将文本中的空格去掉，使用$.trim(文本)
        function login(){
            var loginAct = $.trim($("#loginAct").val());
            var loginPwd = $.trim($("#loginPwd").val());

            if(loginAct=="" || loginPwd==""){
                $("#msg").html("账号密码不能为空");
                return false;
            }
            //去后台验证登录相关操作
            $.ajax({
                url:"setting/user/login.do",
                data:{
                    "loginAct":loginAct,
                    "loginPwd":loginPwd
                },
                type:"post",
                dataType:"json",
                success:function(data){
                    if(data.success){
                        //跳转到工作台的初始页
                        window.location.href = "workbench/index.html";
                    }else{
                        $("msg").html(data.msg);
                    }
                }

            })
        }
    </script>
</head>

<body>
<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
    <img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
</div>
<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
    <div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
</div>

<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
    <div style="position: absolute; top: 0px; right: 60px;">
        <div class="page-header">
            <h1>登录</h1>
        </div>
        <form action="workbench/index.html" class="form-horizontal" role="form">
            <div class="form-group form-group-lg">
                <div style="width: 350px;">
                    <input class="form-control" type="text" placeholder="用户名">
                </div>
                <div style="width: 350px; position: relative;top: 20px;">
                    <input class="form-control" type="password" placeholder="密码">
                </div>
                <div class="checkbox"  style="position: relative;top: 30px; left: 10px;">

                    <span id="msg"></span>

                </div>
                <button type="submit" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">登录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
