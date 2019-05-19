<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="/ui/student/save" method="post">
		<div>
			<div align="center">
				 Name: <input id="name" name="name" type="text" value="${studentObject.name}" />
			</div>
			<div align="center">
				 Age: <input id="age" name="age" type="text" value="${studentObject.age}"/>
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save student"/>
			</div>
		</div>
	</form>
</body>
</html>