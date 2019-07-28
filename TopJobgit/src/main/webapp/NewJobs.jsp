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
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
String sql="select * from jobs where Status1='F'";
PreparedStatement smt=con.prepareStatement(sql);

ResultSet rs=smt.executeQuery();
while(rs.next()) {
	String a=rs.getString(1);
	String url="NewJobsDetails.jsp?jobid="+a;
	%>

<div class="wrapper-container">
  <div class="well">
    <div class="row">
       <div class="col-sm-6">
       <label><%=a%></label>&nbsp;
       <label><%=rs.getString(2) %></label>&nbsp;
        <label><%=rs.getString(3) %></label>&nbsp;
        <label><%=rs.getString(4) %></label>&nbsp;
       
       <br>
       <a href="<%=url%>">More>>>></a>
      </div>
      <button type="accept">Accept</button>
      <button type="decline">Decline</button>
      </div>
    </div>
  </div><%
}
rs.close();
con.close();
%>
</body>

</html>