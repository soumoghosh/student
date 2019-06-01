<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Car</title>
</head>
<body>
	<h1>Add Car</h1>
	<form action="/ui/car/save" method="post">
		<div>
			<div align="center">
				 Wheel: <input id="wheel" name="wheel" type="text" value="${carObj.wheel}" />
			</div>
			<div align="center">
				 Name: <input id="name" name="name" type="text" value="${carObj.name}"/>
			</div>
			<div align="center">
				 Model: <input id="model" name="model" type="text" value="${carObj.model}"/>
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save car"/>
			</div>
		</div>
	</form>
</body>

</html>