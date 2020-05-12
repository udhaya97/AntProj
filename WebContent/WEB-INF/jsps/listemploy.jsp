<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My App</title>
</head>

<body>
<div align="center">
<h1>Employees List</h1>  
<form:form action="" method="GET" modelAttribute="lis">
<table border="2" width="50%" cellpadding="2">  
<tr><th>Id</th><th>EmployeeName</th><th>Salary</th><th>Designation</th><th>DOB</th><th>CompanyName</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="employee" items="${lis}">   
   <tr>  
   <td>${employee.empId}</td>  
   <td>${employee.empName}</td> 
    <td>${employee.sal}</td> 
   <td>${employee.designation}</td> 
   <td>${employee.dob}</td> 
   <td>${employee.companyName}</td>  
   <td><a href="updateEmployee/${employee.empId}">Edit</a></td>  
   <td><a href="deleteEmployee/${employee.empId}"
    onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false"
     >Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="addEmployee">Add New Employee</a>  
</form:form></div>
</body>
</html>