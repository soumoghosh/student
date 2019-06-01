<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Teacher</title>
</head>
<body>

<h1>All Teacher</h1>
</body>
<table style="width:50%">
 <tr>
    <th>Id</th>
    <th>Name</th> 
    <th>Dept </th> 
    <th>Course </th>
    <th>Delete</th>
    <th>Update</th>
 
  </tr>
 
 <tr>
            <td>${teacher.id}</td>
		    <td>${teacher.name}</td> 
		    <td>${teacher.dept}</td>
		    <td>${teacher.course}</td>
            <td><a href="/ui/teacher/delete/${teacher.id}">Delete</a></td>
		    <td><a href="/ui/teacher/update/${teacher.id}">Update</a></td>
		  </tr>
       <td><a href="/ui/teacher/add">ADD NEW TEACHER</a></td>
        <td><a href="/ui/teacher/single">SINGLE TEACHER DETAILS</a></td>


</table>
</html>