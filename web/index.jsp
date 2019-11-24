<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>学生宿舍管理系统</title>

  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>

<%--  页面判断输入是否为空--%>
  <script type="text/javascript">
    function checkForm() {
      var username = document.getElementById("userName").value;
      var password = document.getElementById("password").value;
      var usertypes = document.getElementsByName("userType");
      var usertype = null;
      for(var i=0;i<usertypes.length;i++) {
        if(usertypes[i].checked) {
          usertype=usertypes[i].value;
          break;
        }
      }
      if (username == null || username === "") {
        alert("用户名不能为空");
        return false;
      }
      if (password == null || password === "") {
        alert("密码不能为空");
        return false;
      }
      if (usertype == null || usertype === "") {
        alert("请选择用户类型");
        return false;
      }
      return true;
    }
  </script>
  <style>
    input{
      width:30%;
      height: 50px;
      border-radius: 8px;
      opacity: 0.9;
      -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.02);
      box-shadow: inset 0 1px 1px rgba(0,0,0,.02);
      -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
      -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
      transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
    }
    input:focus{
      border-color: #66afe9;
      outline: 0;
      -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.02),0 0 8px rgba(102,175,233,.6);
      box-shadow: inset 0 1px 1px rgba(0,0,0,.02),0 0 8px rgba(102,175,233,.6)
    }
  </style>

</head>
<body background="images/login.jpg">
<p class="text-center" style = 'font-size: 60px;padding: 50px;margin: 0px' >
  <strong>学生宿舍管理系统</strong>
</p>
<div style="background-color: rgba(255,255,255,0.4);width: 60%;margin: 0 auto">
  <div style="color: red;font-size: 50px;text-align: center;padding-top: 20px">
    <strong>欢迎登陆</strong>
  </div>
  <form name="loginform" action="login" method="post" onsubmit="return checkForm()">
    <div style="text-align:center; vertical-align:middle;margin-bottom: 30px;padding-top: 30px">
      <span style="font-size: 30px">用户名：</span>
      <input id="userName" name="userId" value="" type="text" placeholder="请输入账号" style="font-size: 30px">
    </div>
    <div style="text-align:center; vertical-align:middle;padding-top: 30px;padding-bottom: 30px">
      <span style="font-size: 30px">&nbsp;&nbsp;&nbsp;&nbsp;密码：</span>
      <input id="password" name="password" value="" type="password" placeholder="请输入密码" style="font-size: 30px">
    </div>
    <div style="text-align: center;padding-bottom: 20px">
      <input type="radio" name="userType" value="student" style="width:15px;height:15px" checked/>
      <span style="font-size: 20px">学生&nbsp;&nbsp;&nbsp;&nbsp;</span>
      <input type="radio" name="userType" value="dorManager" style="width:15px;height:15px"/>
      <span style="font-size: 20px">宿舍管理员</span>
    </div>
    <div style="text-align: center;padding-bottom: 20px">
      <button type="submit" class="btn btn-primary btn-lg active" style="width: 300px;font-size: 25px">登陆</button>
    </div>
  </form>
  <div style="text-align: center;padding-bottom: 20px;">
    <h5 id="error"  style="color: red">${error}</h5>
  </div>
</div>
</body>
</html>
