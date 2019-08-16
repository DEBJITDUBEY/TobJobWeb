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
PreparedStatement smt=con.prepareStatement("select jobseaker.*, applyjob.status, applyjob.apply_date, applyjob.app_id from jobseaker,applyjob "+
" where jobseaker.email=applyjob.job_seaker_id and applyjob.job_id=?");
smt.setString(1,jobid);
ResultSet rs=smt.executeQuery();
String email=null;
while(rs.next()) {
      	String url1="DownloadResume?id_details="+rs.getString(8);
    	String status = rs.getString(29);  
    	int appid=rs.getInt(31);
    	email=rs.getString(2);
%>  	
       <div>Name:
       <label><%=rs.getString(1) %></label>
       <br>
       Email:
       <label><%=email%></label>
       <br>
       Gender:
       <label><%=rs.getString(5) %></label>
       </div>
       <div>
        <a href="<%=url1%>" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-download-alt"></span> Download Resume
        </a>
        <%
           if(status.equalsIgnoreCase("NO")) {
        	   
       %>
           <form action="ShortListed" method="post">  
             <input type="hidden" name="appid" value="<%=appid%>">
             <input type="hidden" name="email" value="<%=email%>">
            <!--  <a href="shortListed" class="btn btn-info btn-lg"> <span class="glyphicon glyphicon-ok"></span> Shortlisted  </a> -->
            <input type="submit" value="ShortList">
           </form>  
         <%
         }
         else {
         %>
         <font color="red">Already Shortlisted</font>
         <% }  %>
     </div>
  <% 
  }
rs.close();
con.close();
%>
</body>
</html>