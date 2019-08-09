<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="EmployeerMenubar.jsp" %>
<html>
<head>
	<title></title>
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%
String jobid= request.getParameter("jobid");
System.out.println(jobid);
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from jobs where Job_id=?");
smt.setString(1,jobid);
ResultSet rs=smt.executeQuery();
    if(rs.next()) {
    	%>
    <div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
<form action="EditJobs" method="post">
<lable>JobId:
</lable>
	<%=rs.getString(1) %>
	<br>
	<lable>JobTitle:
	
</lable>
<input type="hidden" name="jobid" id="jobid" Value="<%=rs.getString(1) %>">
	<input type="text" name="Jobtitle" id="jobtitle" Value="<%=rs.getString(3) %>">
	<br>
	<lable>Company Name:
</lable>
	<input type="text" name="cname" id="cname" Value="<%=rs.getString(4) %>">
	<br>
	<lable>Company Website:
</lable>
	<input type="text" name="cwebsite" id="cwebsite" Value="<%=rs.getString(5) %>">
	<br>
	<lable>Job Description:
</lable>
	<input type="text" name="jdescription" id="jdescription" Value="<%=rs.getString(6) %>">
	<br>
	<lable>Job Skills:
</lable>
	<input type="text" name="jskilss" id="jskilss" Value="<%=rs.getString(7) %>">
	<br>
	<lable>Job Experience:
</lable>
	<input type="text" name="jexperience" id="jexperience" Value="<%=rs.getString(8) %>">
	<br>
	<lable>Job Salary:
</lable>
	<input type="text" name="jsalary" id="jsalary" Value="<%=rs.getString(9) %>">
	<br>
	<lable>Job Location:
</lable>
	<input type="text" name="jlocation" id="jlocation" Value="<%=rs.getString(10) %>">
	


<input type="submit">

</form>
</div>
<div class="col-sm-4"></div>
</div>
</body>
</html>
<%
}
rs.close();
con.close();
%>