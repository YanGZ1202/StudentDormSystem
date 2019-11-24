<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生登陆界面</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <style>
        *{
            padding: 0px;
            margin: 0px;
        }
        .topnav{
            list-style: none;
            background-color: rgb(20,68,106);
            width: 100%;
            height: 45px;
            /*margin: 20px auto;*/
            overflow: hidden;
            zoom: 1;
        }
        .topnav li{
            float: left;
            width: 25%;
        }
        .topnav a{
            width: 100%;
            height: 100%;
            line-height: 45px;
            display: inline-block;
            text-align: center;
            font-size: 20px;
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
        .topnav a:hover{
            background-color: red;
        }
    </style>

    <script type="text/javascript">
        function checkWord(){
            var oldPassword = document.getElementById("oldPassword").value;
            var newPassword = document.getElementById("newPassword").value;
            var passwordAgain = document.getElementById("passwordAgain").value;
            if(oldPassword !== "${currentUser.password}"){
                alert("密码错误");
                return false;
            }
            if(oldPassword === newPassword){
                alert("新密码与旧密码不能相同");
                return false;
            }
            if(newPassword !== passwordAgain){
                alert("两次输入密码不一致");
                return false;
            }
            return true;
        }

        function exit() {
            sessionStorage.clear();
        }
    </script>
</head>
<body background="images/login.jpg">
<div>
    <h1 style="text-align: center;"><strong>学生宿舍管理系统</strong></h1>
</div>
<div>
    <h4 style="text-align: right">欢迎您，${currentUser.name}同学</h4>
</div>
<ul class="topnav" style="margin-bottom: 0px">
    <li><a href="login">首&emsp;&emsp;&emsp;&emsp;页</a></li>
    <li><a href="repair.jsp">申&emsp;请&emsp;报&emsp;修</a></li>
    <li><a href="changepassword.jsp">修&emsp;改&emsp;密&emsp;码</a></li>
    <li><a href="index.jsp" onclick="exit()">退&emsp;出&emsp;登&emsp;陆</a></li>
</ul>
<div style="background-color: rgba(255,255,255,0.4);width: 100%;height: 900px;">
    <form name="changePassword" action="changepsd?action=stuChange" method="post" onsubmit="return checkWord()">
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-top: 50px">
            <span style="font-size: 25px">旧密码：</span>
            <input id="oldPassword" name="oldPsd" value="" type="password" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;padding-bottom: 30px;margin-right: 28px">
            <span style="font-size: 25px">&nbsp;&nbsp;&nbsp;&nbsp;新密码：</span>
            <input id="newPassword" name="newPsd" value="" type="password" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;padding-bottom: 30px;margin-right: 82px">
            <span style="font-size: 25px">&nbsp;再次输入密码：</span>
            <input id="passwordAgain" name="rPsd" value="" type="password" style="font-size: 25px">
        </div>
        <div style="text-align: center;padding-bottom: 20px">
            <button type="submit" class="btn btn-primary btn-lg active" style="width: 100px;font-size: 20px">确定</button>
        </div>
    </form>
    <div style="text-align: center;padding-bottom: 20px;">
        <h5 id="error"  style="color: red">${changeMsg}</h5>
    </div>
</div>
</body>
</html>


