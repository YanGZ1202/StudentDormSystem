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
            width: 12.5%;
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
        #tableRecord th{
            border: 2px solid black;
            font-size: 20px;
        }
        #tableRecord td{
            border: 2px solid black;
            font-weight: normal;
            font-size: 20px;
            background-color: rgba(255,255,255,0.4);
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
    <h4 style="text-align: right">欢迎您，${currentUser.name}管理员</h4>
</div>
<ul class="topNav" style="margin-bottom: 0px">
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
    <div style="text-align: right;padding:10px">
        <button type="button" class="btn btn-default btn-sm active" style="width: 80px;font-size: 15px" onclick="location.href='outputBill'">导出数据</button>
    </div>
    <div style="text-align: right;padding-bottom: 10px;">
        <h5 id="error"  style="color: red">${outputMsg}</h5>
    </div>
    <table id = 'tableRecord' class="table table-striped table-bordered table-hover datatable">
        <thead>
        <tr>
            <th>日期</th>
            <th>宿舍楼</th>
            <th>宿舍</th>
            <th>费用</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  varStatus="i" var="bill" items="${billList}">
            <tr>
                <td>${bill.date}</td>
                <td>${bill.dormBuild}</td>
                <td>${bill.dorm}</td>
                <td>${bill.cost}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>



