<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="width:50%">
  <tr>
    <th>Id</th>
    <th>Wheel</th> 
    <th>Name </th> 
     <th>Model </th>
    <th>Delete</th>
    <th>Update</th>
 
  </tr>
           <tr>
		    <td>${carObj.id}</td> 
		    <td>${carObj.wheel}</td> 
		    <td>${carObj.name}</td>
		    <td>${carObj.model}</td>
		    <td><a href="/ui/car/delete/${carObj.id}">Delete</a></td>
		    <td><a href="/ui/car/update/${carObj.id}">Update</a></td>
		  </tr>
		   <td><a href="/ui/car/add">ADD NEW CAR</a></td>
</table>
</body>
</html>