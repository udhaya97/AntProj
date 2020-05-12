<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align ="center">
<h1>Edit Employee</h1> 
       <form:form method="post" action="../saveEmployeetwo/${employee.empId}" modelAttribute="emplo">   
       
       <form:hidden path="empId"/> 
        <table >  
         <tr> 
         <tr>    
          <td>Employee Name : </td>   
          <td><form:input path="empName" value="${employee.empName}"/></td>  
         </tr>    
         <tr>    
         
          <td>Salary :</td>    
          <td><form:input path="sal" value="${employee.sal}"/></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="designation" value="${employee.designation}"/></td>  
         </tr>   
         <tr>    
          <td>DOB :</td>    
          <td><form:input path="dob" value="${employee.dob}" type="date"/></td>  
         </tr>   
         <tr>    
          <td>CompanyName :</td>    
          <td><form:input path="companyName" value="${employee.companyName}"/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save"/>    
         </tr>    
        </table>    
       </form:form>   </div>
</body>
</html>