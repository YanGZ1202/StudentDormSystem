<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        .topNav{
            list-style: none;
            background-color: rgb(20,68,106);
            width: 100%;
            height: 45px;
            /*margin: 20px auto;*/
            overflow: hidden;
            zoom: 1;
        }
        .topNav li{
            float: left;
            width: 25%;
        }
        .topNav a{
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
        .topNav a:hover{
            background-color: red;
        }
    </style>
    <script>
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
<ul class="topNav" style="margin-bottom: 0px">
    <li><a href="query">查&emsp;询&emsp;信&emsp;息</a></li>
    <li><a href="repair.jsp">申&emsp;请&emsp;报&emsp;修</a></li>
    <li><a href="changepassword.jsp">修&emsp;改&emsp;密&emsp;码</a></li>
    <li><a href="index.jsp" onclick="exit()">退&emsp;出&emsp;登&emsp;陆</a></li>
</ul>
<div style="background-color: rgba(255,255,255,0.4);width: 100%;height: 900px;">
    <div style="font-size: 100px;text-align: center;opacity: 0.6;padding-top: 150px">
        您好！
    </div>
    <div style="font-size: 100px;text-align: center;opacity: 0.6">
        ${currentUser.name}同学
    </div>
</div>
</body>
</html>

