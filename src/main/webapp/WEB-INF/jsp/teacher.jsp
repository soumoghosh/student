<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Teacher</title>
</head>
<body>
	<h1>Add Teacher</h1>
	<form:form  method="POST" commandName="teacher">
		<div>
		<div align="center">
				Id: <form:input  path="id" />
			</div>
			<div align="center">
				 Name: <form:input path="name"   />
			</div>
			<div align="center">
				Department: <form:input path="dept"   />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save Person"/>
			</div>
		</div>
	</form:form>
</body>
</html>