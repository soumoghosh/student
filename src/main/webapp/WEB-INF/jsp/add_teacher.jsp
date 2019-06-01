<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>

<h1>Add Teacher</h1>
<form action="/ui/teacher/save" method="post">
      <div>
			<div align="center">
				 Name: <input id="name" name="name" type="text" value="${teacherObj.name}" />
			</div>
			<div align="center">
				 Dept: <input id="dept" name="dept" type="text" value="${teacherObj.dept}"/>
			</div>
			<div align="center">
				 Course: <input id="course" name="course" type="text" value="${teacherObj.course}"/>
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save Teacher"/>
			</div>
		</div>
		</form>
</body>
</html>