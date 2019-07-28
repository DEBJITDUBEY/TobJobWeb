<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
<%@include file="menubar.html" %>
<%
String JobId=request.getParameter("jobid");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
String sql="select * from jobs where Job_Id=?";
PreparedStatement smt=con.prepareStatement(sql);
smt.setString(1,JobId);

ResultSet rs=smt.executeQuery();
if(rs.next()) {
	
	%>

<div class="wrapper-container">
  <div class="well">
    <div class="row">
       <div class="col-sm-6">
        <label><%=rs.getString(3) %></label>
        <label><%=rs.getString(5) %></label>
       <label><%=rs.getString(7) %></label>
        <label><%=rs.getString(9) %></label>
       <br>
      <%
      String url="ApplyJobFinal?jobid="+rs.getString(1); %> 
      <a href="<%=url%>" class="btn btn-info" role="button">Apply</a>
      </div>
       <div class="col-sm-6">
        <label><label><%=rs.getString(4) %></label></label>
        <label><label><%=rs.getString(6) %></label></label>
        <label><label><%=rs.getString(8) %></label></label>
        
      </div>
      </div>
    </div>
  </div><%
}
rs.close();
con.close();
%>

</body>
</html>