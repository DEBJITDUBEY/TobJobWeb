<%@page import="job.dao.PostedJobDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="job.model.PostedJob"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="EmployeerMenubar.jsp" %>
<%
String empid=(String)session.getAttribute("empid");
PostedJob job=new PostedJob();
List<PostedJob> jlist=new ArrayList<PostedJob>();
/* EmployeerDaoImpl daoImpl=new EmployeerDaoImpl(); */
jlist=(List<PostedJob>)request.getAttribute("jlist");



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="wrapper-container">
<div class="well">
<div class="row">

<%
for(PostedJob j:jlist){
   String jobid = j.getJobId();
   String joburl="Applicant.jsp?jobid="+jobid;
   String jobur2="RemoveJobs?jobid="+jobid;
   String jobur3="EditJobs.jsp?jobid="+jobid;
   String jobur4="ShortListed.jsp?jobid="+jobid;
%>
   <div class="col-sm-4">
    <label><%=jobid%></label>
    <label><%=j.getJlocation()%></label>
   <label><%=j.getJobTitle() %></label>
   <br>
   
   <%


%>
  </div>
   <div class="col-sm-2">
  <label><a href="<%=jobur2%>">Remove Jobs</a></label>
    <br>
    </div>
    <div class="col-sm-2">
   <label><a href="<%=jobur3%>">Edit Jobs</a></label>
    </div>
    <div class="col-sm-2">
    <label><a href="<%=joburl%>">View Applicants</a></label>
  </div>
  <div class="col-sm-2">
    <label><a href="<%=jobur4%>">View ShortListed</a></label>
  </div>
  <%
  
  %>
  </div>
</div>
</div>
<%
}
%>


</body>
</html>