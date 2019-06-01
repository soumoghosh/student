<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update Teacher</title>
</head>
<body>
	<h1>Update Teacher</h1>
	<form action="/ui/teacher/save" method="post">
		<div>
		<div align="center">
				 Wheel: <input id="name" name="name" type="text" value="${teacher.name}" />
			</div>
			<div align="center">
				 Dept: <input id="dept" name="dept" type="text" value="${teacher.dept}" />
			</div>
			<div align="center">
				 Course: <input id="course" name="course" type="text" value="${teacher.course}"/>
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Update Teacher"/>
			</div>
		</div>
	</form>
</body>
</html>