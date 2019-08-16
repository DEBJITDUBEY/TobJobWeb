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
String mailId=(String)session.getAttribute("mailId");
System.out.println(mailId);

%>
<%@include file="Schemeheader.jsp" %>
<form action="setPassword" method="post">
<input type="hidden" id="email" name="email" value="<%=mailId%>">
<input type="text" name="pwd" id="pwd">
<input type="submit">
</form>
</body>
</html>