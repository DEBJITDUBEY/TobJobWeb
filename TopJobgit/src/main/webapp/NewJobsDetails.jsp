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
<%@include file="AdminHeader.jsp" %>
<% 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
String jobid=request.getParameter("jobid");
String sql="select * from jobs where job_id=?";
PreparedStatement smt=con.prepareStatement(sql);
smt.setString(1,jobid);

ResultSet rs=smt.executeQuery();
if(rs.next()) {
	
	%>

<div class="wrapper-container">
  <div class="well">
    <div class="row">
       <div class="col-sm-6">
       <label><%=jobid%></label>&nbsp;
       <label><%=rs.getString(2) %></label>&nbsp;
        <label><%=rs.getString(3) %></label>&nbsp;
        <label><%=rs.getString(4) %></label>&nbsp;
       
       <br>
        </div>
      <form action="AllowJobs" method="post">  
       <input type="hidden" name="jobid" value="<%=jobid%>">
      <button type="submit">Allow</button>
     <!--  <button type="submit">Decline</button> -->
      </form>
      </div>
    </div>
  </div><%
}
rs.close();
con.close();
%>
</body>
</html>