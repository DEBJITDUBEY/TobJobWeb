<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><%
String mailId=(String)session.getAttribute("mailId");
System.out.println(mailId);

%>
<%@include file="Schemeheader.jsp" %>
<form action="EmployeerPasswordRecovery2" method="post">
<lable>Enter the Security Key</lable>
<input type="hidden" name="email" value="<%=mailId%>">
<input type="text" name="pwd" id="pwd"> 
<input type="submit">
</form>
</div>

</body>
</html>