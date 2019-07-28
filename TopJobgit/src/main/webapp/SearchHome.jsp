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
<div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
<%@include file="menubar.html" %>
<%
String skills = request.getParameter("skills");
String location= request.getParameter("location");
String salary= request.getParameter("salary");
String exp= request.getParameter("exp");

Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
String sql="select * from jobs where skills like '%"+skills+"%' and Job_location=? and salary=? and experience=?";
PreparedStatement smt=con.prepareStatement(sql);
smt.setString(2,salary);
smt.setString(1,location);
smt.setString(3,exp);
ResultSet rs=smt.executeQuery();
while(rs.next()) {
	
	%>
<div class="wrapper-container">
  <div class="well">
    <div class="row">
       <div class="col-sm-2">
        <label><%=rs.getString(4) %></label>
        <label><%=rs.getString(3) %></label>
       <label><%=rs.getString(10) %></label>
       <br>
       <button type="submit">Apply</button>
      </div>
       <div class="col-sm-1">
        <label><label><%=rs.getString(8) %></label></label>
        <label><label><%=rs.getString(9) %></label></label>
        
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