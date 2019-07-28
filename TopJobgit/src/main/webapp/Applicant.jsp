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
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from jobseaker where email in(select Job_seaker_id from applyJob where job_id in(select job_id from jobs where Employee_id=?))");
smt.setString(1,employeeid);
ResultSet rs=smt.executeQuery();
%>
<%
    if(rs.next()) {
    
    	String url1="DownloadResume?id_details="+rs.getString(8);
    %>
       <div>
       <label><%=rs.getString(1) %></label>
       <label><%=rs.getString(2) %></label>
       <label><%=rs.getString(3) %></label>
       <label><%=rs.getString(4) %></label>
       <label><%=rs.getString(5) %></label>
       
       <label><%=rs.getString(6) %></label>
       <label><%=rs.getString(7) %></label>
       
       <label><%=rs.getString(8) %></label>
       </div>
       <div>
        <a href="<%=url1%>" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-download-alt"></span> Download Resume
        </a>
     <a href="ShortlistedResume" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-ok"></span> Shortlisted
        </a>
           
     </div>
  <% 
  }
rs.close();
con.close();
%>



</body>
</html>