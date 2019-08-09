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
<%

String jobid= request.getParameter("jobid");
try {
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
	String sql="Delete from jobs where job_id=?";
	PreparedStatement smt=con.prepareStatement(sql);
	smt.setString(1,jobid);
	int row= smt.executeUpdate();
	con.close();
	RequestDispatcher rd = request.getRequestDispatcher("EmployeerViewJobs.jsp");
	rd.forward(request, response);
	}
	catch(Exception e) {
		System.out.println(e);
	}

%>
</body>
</html>