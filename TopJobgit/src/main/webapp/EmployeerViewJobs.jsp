<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="EmployeerMenubar.jsp" %>
<%
String employeeid=null;
employeeid=(String)session.getAttribute("empid");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from jobs where Employee_id=?");
smt.setString(1,employeeid);
ResultSet rs=smt.executeQuery();
%>
<div class="wrapper-container">
<div class="well">
<div class="row">
<%
if(rs.next()) {

%>
   <div class="col-sm-2">
    <label><%=rs.getString(4) %></label>
    <label><%=rs.getString(3) %></label>
   <label><%=rs.getString(10) %></label>
   <br>
   
   
  </div>
   <div class="col-sm-1">
    <label><label><%=rs.getString(8) %></label></label>
    <br>
    <label><label><%=rs.getString(9) %></label></label>
  </div>
  <%
  }
if(rs.next()) {
	
%>
   <div class="col-sm-2">
    <label><%=rs.getString(4) %></label>
    <label><%=rs.getString(3) %></label>
   <label><%=rs.getString(10) %></label>
   <br>
 
   
  </div>
   <div class="col-sm-1">
    <label><label><%=rs.getString(8) %></label></label>
    <br>
    <label><label><%=rs.getString(9) %></label></label>
  </div>
  <%
  }
if(rs.next()) {
	
%>
   <div class="col-sm-2">
    <label><%=rs.getString(4) %></label>
    <label><%=rs.getString(3) %></label>
   <label><%=rs.getString(10) %></label>
   <br>
   
   
  </div>
   <div class="col-sm-1">
    <label><label><%=rs.getString(8) %></label></label>
    <br>
    <label><label><%=rs.getString(9) %></label></label>
  </div>
  <%
  }
   if(rs.next()) {
	  
  %>
  <div class="col-sm-2">
    <label><%=rs.getString(4) %></label>
    <label><%=rs.getString(3) %></label>
   <label><%=rs.getString(10) %></label>
   <br>
   
  </div>
   <div class="col-sm-1">
    <label><label><%=rs.getString(8) %></label></label>
    <br>
    <label><label><%=rs.getString(9) %></label></label>
    </div>
    <%
    }
    %>
  </div>
</div>
</div><%
rs.close();
con.close();
%>


</body>
</html>