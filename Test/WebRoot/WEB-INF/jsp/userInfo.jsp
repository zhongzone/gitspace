<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>用户信息</title>
</head>
<body>
	<c:if test="${user == null }">
		<script type="text/javascript">
			window.location.href = "login.do";
		</script>
	</c:if>
	<table align="center" style=" border-style: dashed;border-width:thick;margin-top:15%;">
		<tr><td colspan="2" style="text-align: center;"><h2>用户信息</h2></td></tr>
		<tr> 	
			<td>姓名:</td>
			<td>${user.name }</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td>${user.gender }</td>
		</tr>
		<tr>
			<td>手机:</td>
			<td>${user.phone }</td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td>${user.email }</td>
		</tr>
		<tr>
			<td>生日:</td>
			<td>${user.birthday }</td>
		</tr>
		<tr>
			<td>上次登陆时间:</td>
			<td>${user.lastSinginTime }</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<a href="logout.do"><input type="button" value="注销"></a>
			</td>
		</tr>
	</table>
</body>
</html>