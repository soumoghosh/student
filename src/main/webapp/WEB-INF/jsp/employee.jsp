<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Employee</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form:form  method="POST" commandName="employee">
		<div>
		<div align="center">
				Id: <form:input  path="id" />
			</div>
			<div align="center">
				First Name: <form:input path="firstname"   />
			</div>
			<div align="center">
				Last Name: <form:input path="lastname"   />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Save Person"/>
			</div>
		</div>
	</form:form>
	
</body>
<%-- <body>
<h3>List of Employees</h3>
       <table class="table table-bordered" style="width: 300px">
       <form:form  method="GET" commandName="employee/all">
         <tr>
           <th>Id</th>
           <th>FirstName</th>
           <th>LastName</th>
         </tr>
         <c:forEach items="${employeeList}" var="employee">
         <tr>
           <td width="60" align="center">${employee.id}</td>
           <td width="60" align="center">${employee.firstname}</td>
           <td width="60" align="center">${employee.lastname}</td>
           <td width="60" align="center"><a href="edit/${employee.id}">Edit</a>/<a href="delete/${employee.id}">Delete</a></td>
         </tr>
      </c:forEach>
      </form:form>
    </table>
    </body> --%>
    <body>
	<h1>DELETE Employee</h1>
	<form:form  method="DELETE" commandName="employee">
		<div>
		<div align="center">
				Id: <form:input  path="id" />
			</div>
			<div align="center">
				First Name: <form:input path="firstname"   />
			</div>
			<div align="center">
				Last Name: <form:input path="lastname"   />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Delete Person"/>
			</div>
		</div>
	</form:form>
	
</body>
 <body>
	<h1>Edit Employee</h1>
	<form:form  method="POST" commandName="employee">
		<div>
		<div align="center">
				Id: <form:input  path="id" />
			</div>
			<div align="center">
				First Name: <form:input path="firstname"   />
			</div>
			<div align="center">
				Last Name: <form:input path="lastname"   />
			</div>
			<div align="center">
				<input id="submit" type="submit" value="Edit Person"/>
			</div>
		</div>
	</form:form>
	
</body>
<body>
</html>