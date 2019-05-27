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

      <c:forEach items = "${personList}" var = "personObj">
     
           <tr>
		    <td>${personObj.id}</td>
		    <td>${personObj.name}</td> 
		    <td>${personObj.age}</td>
		    <td><a href="/ui/person/delete/${personObj.id}">Delete</a></td>
		    <td><a href="/ui/person/update/${personObj.id}">Update</a></td>
		  </tr>
      </c:forEach>  
       <td><a href="/ui/person/add">ADD NEW PERSON</a></td>
        <td><a href="/ui/person/single">SINGLE PERSON DETAILS</a></td>
  
</table>
</body>
</html>