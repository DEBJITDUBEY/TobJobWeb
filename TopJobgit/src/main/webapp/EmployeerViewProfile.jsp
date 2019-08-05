<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<title>Insert title here</title>
</head>
<body>

<%@include file="EmployeerMenubar.jsp" %>

	<div class="container">
	<img src="Image\e1.jpg" style="height: 200px;width: 1200px;">
	</div>
<div class="well">
<%
String emailid=null;
emailid=(String)session.getAttribute("emailid");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from employeer where email=?");
smt.setString(1,emailid);
ResultSet rs=smt.executeQuery();
%>
	 <div class="row">
	 <div class="col-sm-2"></div>
	 <div class="col-sm-2"></div>
    <%
  String url1="FileDownload"; 
  %>
<img src="<%=url1%>" style=" border-radius:80%;width: 100px; height: 100px">
  </div>
  
    <%
    if(rs.next()) {
    	
    %>
       <div>
       <label><%=rs.getString(1) %></label>
      
           
     </div>
  <% 
  }
rs.close();
con.close();
%>

</div>




</body>
</html>