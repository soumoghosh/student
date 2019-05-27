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
    <th>Name</th> 
    <th>Age </th> 
    <th>Delete</th>
    <th>Update</th>
 
  </tr>
           <tr>
		    <td>${personsingle.id}</td> 
		    <td>${personsingle.name}</td> 
		    <td>${personsingle.age}</td>
		    <td><a href="/ui/person/delete/${personsingle.id}">Delete</a></td>
		    <td><a href="/ui/person/update/${personsingle.name}">Update</a></td>
		  </tr>
		   <td><a href="/ui/person/add">ADD NEW PERSON</a></td>
</table>
</body>
</html>