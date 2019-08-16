<%@page import="job.dao.EmployeerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
	<div>
	<div class="row">
	<div class="col-sm-4">
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
    </div>
     <%
    String email=(String)session.getAttribute("emailid");
    EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
    String s=employeerDaoImpl.getDaysRemain(email);
    System.out.println(s);
    
    %>
    <div class="col-sm-6">
      <label><%=s %>days Remaing</label>
    
    </div>
    <div class="col-sm-2">
    <%
  String url="FileDownload"; 
  %>
<img src="<%=url%>" style=" border-radius:80%;width: 100px; height: 100px">
  </div>
  </div>
  </div>
  <div>
  
   <div class="well" style="background-color: #ef8f09">
   <div class="row" style="background-color:white">
   	<div class="col-sm-2"></div>
 <div class="col-sm-1">
 	<a href="JobPost.jsp" >
 Post Jobs </a>
 </div>
 <div class="col-sm-1">
 	<a href="EmployeerViewJobs.jsp" >
 View Jobs </a></div>
 <div class="col-sm-1">
 	 <a href="scheme.jsp" >Schemes</a>
 </div>
 <div class="col-sm-1">
 	 <a href="EmployeerViewProfile.jsp" >View Proofile</a>
 </div>
 <div class="col-sm-1">
  <a href="Logout.jsp" >Edit Proofile</a>
</div>
<div class="col-sm-1">
  <a href="EmployerLogout">Logout</a>
</div>
   </div>
  </div>
</div>

</body>
</html>