<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${!empty empList}">
	<table align="center" border="1">
	<tr><th>Emp No</th> <th>Emp Name</th> <th>Emp Add</th> <th>Emp Salary</th> <th>Operations</th>
	</tr>
	<c:forEach var="emp" items="${empList}" >
	<tr>
	<td>${emp.emp_id}</td>
	<td>${emp.emp_name}</td>
	<td>${emp.emp_add}</td>
	<td>${emp.emp_sal}</td>
	<td><a href="edit?no=${emp.emp_id}">Edit/</a>	
	<a href="delete?no=${emp.emp_id}" onclick="return confirm('Are you sure want to delete')">Delete</a></td>		
	</tr>
	</c:forEach>
	</table>
	<h2 style="text-align:center;color:green">${resultMsg}</h2>
	</c:when>
	<c:otherwise>
	<h1 style="text-align:center;color:red">NO EMP RECORDS FOUND</h1>
	</c:otherwise>
	</c:choose>
	<center><a href="add_emp" style="color:green">Add Employee</a> &nbsp; &nbsp;  <a href="./" style="color:orange">Home</a>
	</center>

</body>
</html>