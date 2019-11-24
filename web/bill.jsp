<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理员登陆界面</title>

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
            width:12.5%;
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
        function checkBills(){
            var dates = document.getElementById("dates").value;
            var bill = document.getElementById("bill").value;
            var dorm = document.getElementById("dorm").value;
            var dormBuild = document.getElementById("dormBuild").value;

            if(dates == null || dates === ""){
                alert("日期不能为空");
                return false;
            }
            if(dormBuild == null || dormBuild === ""){
                alert("宿舍楼不能为空");
                return false;
            }
            if(dorm == null || dorm === ""){
                alert("宿舍不能为空");
                return false;
            }
            if(bill == null || bill === ""){
                alert("费用不能为空");
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
    <h4 style="text-align: right">欢迎您，${currentUser.name}管理员</h4>
</div>
<ul class="topnav" style="margin-bottom: 0px">
    <li><a href="manager.jsp">登&emsp;记&emsp;晚&emsp;归</a></li>
    <li><a href="bill.jsp">登&emsp;记&emsp;费&emsp;用</a></li>
    <li><a href="studentMsg.jsp">登&emsp;记&emsp;学&emsp;生</a></li>
    <li><a href="studentQuery">学&emsp;生&emsp;信&emsp;息</a></li>
    <li><a href="billQuery">费&emsp;用&emsp;信&emsp;息</a></li>
    <li><a href="record">晚&emsp;归&emsp;信&emsp;息</a></li>
    <li><a href="changepasswords.jsp">修&emsp;改&emsp;密&emsp;码</a></li>
    <li><a href="index.jsp" onclick="exit()">退&emsp;出&emsp;登&emsp;陆</a></li>
</ul>
<div style="background-color: rgba(255,255,255,0.4);width: 100%;height: 900px;">
    <form name="recordForm" action="regBill" method="post" onsubmit="return checkBills()">
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-top: 50px">
            <span style="font-size: 25px">日期：</span>
            <input id="dates" name="date" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;margin-right: 23px">
            <span style="font-size: 25px">宿舍楼：</span>
            <input id="dormBuild" name="dormBuild" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-left: 2px">
            <span style="font-size: 25px">宿舍：</span>
            <input id="dorm" name="dorm" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-left: 2px">
            <span style="font-size: 25px">费用：</span>
            <input id="bill" name="cost" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align: center;padding-bottom: 20px">
            <button type="submit" class="btn btn-primary btn-lg active" style="width: 100px;font-size: 20px">提交</button>
        </div>
    </form>
    <div style="text-align: center;padding-bottom: 20px;">
        <h5 id="error"  style="color: red">${billMsg}</h5>
    </div>
</div>
</body>
</html>

