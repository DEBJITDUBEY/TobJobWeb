<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="EmployeerMenubar.jsp" %>
<div class="row">
		<div class="col-sm-2">Package Name</div>
		<div class="col-sm-4">Package Facility</div>
		<div class="col-sm-2">Package Duration</div>
		<div class="col-sm-2">Package Price</div>
</div>
<br>
<%
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from Scheme");
ResultSet rs=smt.executeQuery();
while(rs.next()) {
    String scid=rs.getString(1)	;
    String scurl= "SchemeBuy.jsp?scid="+scid;
 %>
    	<div class="row">
		<div class="col-sm-2"><%=rs.getString(2) %></div>
		<div class="col-sm-4"><%=rs.getString(4) %></div>
		<div class="col-sm-2"><%=rs.getString(3) %></div>
		<div class="col-sm-2"><%=rs.getString(5) %></div>
		<div class="col-sm-2"><button type="button" class="btn btn-success"onclick="window.location.href ='<%=scurl%>'">Buy</button></div>
	</div>
<%
    }
%>
</body>
</html>