<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="job.model.PostedJob"%>
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
PostedJob job=new  PostedJob();
job=(PostedJob)request.getAttribute("job");
   
    	%>
    <div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
<form action="EditJobs" method="post">
<lable>JobId:
</lable>
	<%=job.getJobId() %>
	<br>
	<lable>JobTitle:
	
</lable>
<input type="hidden" name="jobid" id="jobid" Value="<%=job.getJobId() %>">
	<input type="text" name="Jobtitle" id="jobtitle" Value="<%=job.getJobTitle() %>">
	<br>
	<lable>Company Name:
</lable>
	<input type="text" name="cname" id="cname" Value="<%=job.getCname()%>">
	<br>
	<lable>Company Website:
</lable>
	<input type="text" name="cwebsite" id="cwebsite" Value="<%=job.getCwebsite()%>">
	<br>
	<lable>Job Description:
</lable>
	<input type="text" name="jdescription" id="jdescription" Value="<%=job.getJdescription() %>">
	<br>
	<lable>Job Skills:
</lable>
	<input type="text" name="jskilss" id="jskilss" Value="<%=job.getSkills()%>">
	<br>
	<lable>Job Experience:
</lable>
	<input type="text" name="jexperience" id="jexperience" Value="<%=job.getExperience() %>">
	<br>
	<lable>Job Salary:
</lable>
	<input type="text" name="jsalary" id="jsalary" Value="<%=job.getSalary() %>">
	<br>
	<lable>Job Location:
</lable>
	<input type="text" name="jlocation" id="jlocation" Value="<%=job.getJlocation() %>">
	


<input type="submit">

</form>
</div>
<div class="col-sm-4"></div>
</div>
</body>
</html>

