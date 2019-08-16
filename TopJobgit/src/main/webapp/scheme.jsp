<%@page import="job.dbcon.DbConnection"%>
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

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="Schemeheader.jsp" %>
<div class="row">
		<div class="col-sm-2">Package Name</div>
		<div class="col-sm-4">Package Facility</div>
		<div class="col-sm-2">Package Duration</div>
		<div class="col-sm-2">Package Price</div>
</div>
<br>
<%
String email=request.getParameter("email");
Connection con=new DbConnection().getConnection();
PreparedStatement smt=con.prepareStatement("select * from Scheme");
ResultSet rs=smt.executeQuery();
while(rs.next()) {
    String scid=rs.getString(1)	;
    String scurl= "SchemeBuy.jsp?scid="+scid+"&email="+email;
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