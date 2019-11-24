<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>申请报修界面</title>

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
        function checkRepair(){
            var dormBuild = document.getElementById("dormBuild").value;
            var dorm = document.getElementById("dorm").value;
            var tel = document.getElementById("tel").value;
            var description = document.getElementById("description").value;

            if(dormBuild == null || dormBuild === ""){
                alert("宿舍楼不能为空");
                return false;
            }
            if(dorm == null || dorm === ""){
                alert("宿舍不能为空");
                return false;
            }
            if(tel == null || tel === ""){
                alert("电话不能为空");
                return false;
            }
            if(description == null || description === ""){
                alert("描述不能为空");
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
    <li><a href="query">首&emsp;&emsp;&emsp;&emsp;页</a></li>
    <li><a href="repair.jsp">申&emsp;请&emsp;报&emsp;修</a></li>
    <li><a href="changepassword.jsp">修&emsp;改&emsp;密&emsp;码</a></li>
    <li><a href="index.jsp" onclick="exit()">退&emsp;出&emsp;登&emsp;陆</a></li>
</ul>
<div style="background-color: rgba(255,255,255,0.4);width: 100%;height: 900px;">
    <form name="repairForm" action="repair" method="post" onsubmit="return checkRepair()">
        <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-top: 50px">
            <span style="font-size: 25px">宿舍楼：</span>
            <input id="dormBuild" name="dormBuild" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;padding-bottom: 30px">
            <span style="font-size: 25px">&nbsp;&nbsp;&nbsp;&nbsp;宿舍：</span>
            <input id="dorm" name="dorm" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;padding-bottom: 30px">
            <span style="font-size: 25px">&nbsp;&nbsp;&nbsp;&nbsp;电话：</span>
            <input id="tel" name="tel" value="" type="text" style="font-size: 25px">
        </div>
        <div style="text-align:center; vertical-align:middle;padding-bottom: 30px;width: 440px;margin: 0 auto">
            <span style="font-size: 25px;float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述：</span>
            <label>
                <textarea id="description" name="descri"  rows="5" style="width: 318px;font-weight: normal;font-size: 20px"></textarea>
            </label>
        </div>
        <div style="text-align: center;padding-bottom: 20px">
            <button type="submit" class="btn btn-primary btn-lg active" style="width: 100px;font-size: 20px">提交</button>
        </div>
    </form>
    <div style="text-align: center;padding-bottom: 20px;">
        <h5 id="error"  style="color: red">${repairMsg}</h5>
    </div>
</div>
</body>
</html>

