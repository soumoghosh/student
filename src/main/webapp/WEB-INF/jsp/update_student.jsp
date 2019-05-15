<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Student</title>
</head>
<body>
	<h1>Edit Student</h1>
	<form:form  method="POST" commandName="student">
		<div>
		<div align="center">
				Id: <form:input  path="id" />
			</div>
			<div align="center">
				 Name: <form:input path="name"   />
			</div>
			<div align="center">
				Age: <form:input path="age"   />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Edit Person"/>
			</div>
		</div>
	</form:form>
	
</body>
</html>