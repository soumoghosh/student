<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="student" method="post">
		<div>
			<div align="center">
				 Name: <input id="name" name="name" type="text" />
			</div>
			<div align="center">
				 Age: <input id="age" name="age" type="text" />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save student"/>
			</div>
		</div>
	</form>
</body>
<h1>DELETE Student</h1>
	<form:form  method="post" commandName="student">
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
				<input id="submit" type="submit" value="Delete student"/>
			</div>
		</div>
	</form:form>
	
</body>
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
</html>