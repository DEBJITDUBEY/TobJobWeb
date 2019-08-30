<%@page import="job.model.Applicatns"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>
<%

List<Applicatns> alist=(List<Applicatns>)request.getAttribute("alist");
for(Applicatns a:alist){
	%>
	<lable>Name:</lable>
	<div>
	<%= a.getJobSeakerId()%>
	</div>
	<lable>JobId:</lable>
	<div>
	<%= a.getJobId()%>
	</div>
	<lable>ShortListed Status:</lable>
	<div>
	<%= a.getStatus()%>
	</div>
<% 	


}

%>


</body>
</html>