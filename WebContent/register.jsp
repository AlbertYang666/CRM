<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">

    <link rel="stylesheet" href="css/register.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<title>用户注册</title>
	<script type="text/javascript">
	window.onload=function(){
	     var verifyObj = document.getElementById("Verify");
	     verifyObj.onclick=function(){
	         this.src="SecurityCodeImageAction.action?timestamp="+new Date().getTime();
	     };
    }
	</script>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用CRM客户关系管理系统
		</div>
		<div id="back">
			<a href="${pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="${pageContext.request.contextPath}/user_register.action" method="post">
					<div id="login_tip">
						用户注册&nbsp;&nbsp;User registration
					</div>
					<div>用户名:<input type="text" name="user_code" class="code"></div>
					<div>姓&nbsp;&nbsp;&nbsp;名:<input type="text" name="user_name" class="name"></div>
					<div>密&nbsp;&nbsp;&nbsp;码:<input type="password" name="user_password" class="password"></div>
					
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="注&nbsp;&nbsp;册">&nbsp;&nbsp;
						<input type="text" name="verify" class="verify">
						<a href=""><img src="${pageContext.request.contextPath}/SecurityCodeImageAction.action" id="Verify" alt="看不清换一张" width="80" height="40"></a>
					</div>
					<font align="center" color="red"><s:actionerror/></font>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有 AlbertYang
	</div>
</body>
</html>