<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Single Person</title>
</head>
<body>
	<h1>Single Person</h1>
	<form action="/ui/person/" method="GET">
		<div>
			<div align="center">
				 Id: <input id="id" name="id" type="number" value="${person.id}" />
			</div>

			<div align="center">
				<input id="submit" type="submit" value="GetDetails"/>
			</div>
		</div>
	</form>
</body>

</html>