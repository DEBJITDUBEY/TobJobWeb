<%@page import="job.model.Employeer"%>
<%@page import="job.controller.EmployeerViewProfile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<title>Insert title here</title>
</head>
<body>

<%@include file="EmployeerMenubar.jsp" %>

	<div class="container">
	<img src="Image\e1.jpg" style="height: 200px;width: 1200px;">
	</div>
<div class="well">
<%

%>
	 <div class="row">
	 <div class="col-sm-2"></div>
	 <div class="col-sm-2"></div>
    <%
  String url1="FileDownload"; 
  %>
  <%
  Employeer employeer=new Employeer();
  employeer=(Employeer)request.getAttribute("employeer");
 
  %>
<img src="<%=url1%>" style=" border-radius:80%;width: 100px; height: 100px">
  </div>
  
       <div>
       <label><%=employeer.getEmail() %></label>
      
           
     </div>





</body>
</html>