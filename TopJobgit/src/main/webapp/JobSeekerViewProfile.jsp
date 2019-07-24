<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="JobSeekerHeader.jsp" %>
<%
String emailid=null;
emailid=(String)session.getAttribute("emailid");
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from jobseaker where email=?");
smt.setString(1,emailid);
ResultSet rs=smt.executeQuery();
%>
	
    <%
    if(rs.next()) {
    	
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
              <label><%=rs.getString(9) %></label>
               <label><%=rs.getString(10) %></label>
           
     </div>
  <% 
  }
rs.close();
con.close();
%>




</body>
</html>