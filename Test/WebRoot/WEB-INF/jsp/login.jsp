<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script type="text/javascript"> 
	//检查用户名和密码是否为空
	function loginCheck(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username == "" || password == ""){
			alert("用户名或密码不能为空！");
		}else{
			ajaxLogin(username,password);
		}
	}
	
	//ajax验证用户名和密码，正确时返回用户信息
	function ajaxLogin(username,password) {
		var xmlhttp;
		
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE5, IE6
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result = xmlhttp.responseText;
				if(result == "noUser"){
					alert("用户不存在！");
				}else if(result == "errPsw"){
					alert("密码不正确!");
				}else if(result == "success"){
					window.location.href= "showUserInfo.do";
				}else{
					alert("登陆失败!");
				}
			}
		}
		xmlhttp.open("POST", "loginCheck.do", true);
		//Post方式提交需要设置Content-Type头信息，模拟HTTP POST方法发送一个表单
		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		xmlhttp.send("username="+username+"&password="+password);
	}
</script>
</head>
<body>
	<div style="text-align: center;margin-top:15%;">
		<h1>登陆</h1>
		<form>
			<table align="center">
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" id="username" ></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password" id="password" ></td>
				</tr>
			</table>
			<input type="button" value="登陆" onclick="loginCheck()">
			<input type="reset" value="重置">
		</form>
	</div>
</body>
</html>