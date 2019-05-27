<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update Employee</title>
</head>
<body>
	<h1>Update Employee</h1>
	<form action="/ui/employee/save" method="post">
		<div>
			<div align="center">
				 Name: <input id="name" name="name" type="text" value="${employee.name}" />
			</div>
			<div align="center">
				 Age: <input id="age" name="age" type="text" value="${employee.age}"/>
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Update Employee"/>
			</div>
		</div>
	</form>
</body>
</html>