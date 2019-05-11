<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Person</title>
</head>
<body>
	<h1>Add Person</h1>
	<form action="person" method="post">
		<div>
			<div align="center">
				First Name: <input id="firstName" name="firstname" type="text" />
			</div>
			<div align="center">
				Last Name: <input id="lastName" name="lastname" type="text" />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save Person"/>
			</div>
		</div>
	</form>
</body>
</html>