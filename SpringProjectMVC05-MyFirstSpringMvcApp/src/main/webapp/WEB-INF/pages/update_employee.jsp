<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center; color:pink">Update Emp Details</h1>
	
	<c:form modelAttribute="emp">
	<table align="center" >
	<tr>
	<td>Emp No: </td>
	<td><c:input path="emp_id" readonly="true"/></td>
	</tr>
	<tr>
	<td>Emp Name: </td>
	<td><c:input path="emp_name"/></td>
	</tr>
	<tr>
	<td>Emp address: </td>
	<td><c:input path="emp_add"/></td>
	</tr>
	<tr>
	<td>Emp sal: </td>
	<td><c:input path="emp_sal"/></td>
	</tr>
	<tr>
	<td><input type="submit" value="Update Employee"> </td>
	<td><input type="reset" value="cancel"></td>
	</tr>
	</table>
	
	</c:form>

</body>
</html>