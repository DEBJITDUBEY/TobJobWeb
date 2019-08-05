<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="AdminHeader.jsp" %>
<%
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from employeer");
ResultSet rs=smt.executeQuery();
%>
	<div class="wrapper-container">
  <div class="well">
    <div class="row">
    <%
    while(rs.next()) {
    	
    	%>
    	<div class="row">
    	<div class="col-sm-2"></div>
    	<div class="col-sm-4">
    	Name: <label><%=rs.getString(1) %></label>
    	</div>
    	</div>
<%
    }
%>
</body>
</html>