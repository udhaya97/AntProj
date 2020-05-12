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
<div align ="center">
<h1>Add New Employee</h1> 
       <form:form method="post" action="saveEmployee" modelAttribute="emplo">   
       
       <form:hidden path="empId"/> 
        <table >  
        <tr>  
         <tr> 
         <tr>    
          <td>EmployeeName : </td>   
          <td><form:input path="empName" required="required"/></td>  
         </tr>    
         <tr>    
         
          <td>Salary :</td>    
          <td><form:input path="sal" required="required" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="designation" required="required" /></td>  
         </tr>   
         <tr>    
          <td>DOB :</td>    
          <td><form:input path="dob" type="date" required="required" /></td>  
         </tr>   
         <tr>    
          <td>CompanyName :</td>    
          <td><form:input path="companyName" required="required" /></td>  
         </tr>   
          
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save"/>    
         </tr>    
        </table>    
       </form:form>   </div>
</body>
</html>