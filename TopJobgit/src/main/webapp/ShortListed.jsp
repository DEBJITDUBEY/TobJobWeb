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
<%@include file="EmployeerMenubar.jsp" %>
<%
String employeeid=null;
employeeid=(String)session.getAttribute("empid");
System.out.println(employeeid);
String jobid= request.getParameter("jobid");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
//PreparedStatement smt=con.prepareStatement("select * from jobseaker where email in(select Job_seaker_id from applyJob where job_id in(select job_id from jobs where Employee_id=?))");
PreparedStatement smt=con.prepareStatement("select * from applyJob where job_id=? and status='Yes'");
smt.setString(1,jobid);
ResultSet rs=smt.executeQuery();
while(rs.next()) {
    
%>  	<div>Job id:
    <lable> <%=rs.getString(2) %></lable>
   </div>
   <div>Short Listed:
    <lable> <%=rs.getString(3) %></lable>
   </div>
      
  <% 
  }
rs.close();
con.close();
%>
</body>
</html>