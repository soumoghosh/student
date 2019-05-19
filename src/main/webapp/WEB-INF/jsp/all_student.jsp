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

      <c:forEach items = "${studentList}" var = "studentObj">
     
           <tr>
		    <td>${studentObj.id}</td>
		    <td>${studentObj.name}</td> 
		    <td>${studentObj.age}</td>
		    <td><a href="/ui/student/delete/${studentObj.id}">Delete</a></td>
		    <td><a href="/ui/student/update/${studentObj.name}">Update</a></td>
		  </tr>
      </c:forEach>  
  
</table>
</body>
</html>