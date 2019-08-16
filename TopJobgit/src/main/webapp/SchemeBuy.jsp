<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Schemeheader.jsp" %>
    <%
        String scid=request.getParameter("scid");
    String email=request.getParameter("email");
    %>
    
<div class="row">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">Payment gateWay
    <form action="SchemeBuy" method="post">
     <div class="form-group">
    
    <input type="text" class="form-control" id="cno" name="cno" placeholder="Enter Card No">
  </div>
  <div class="row">
  	<div class="col-sm-6">
  <div class="form-group">
  
    <input type="text" class="form-control" id="edate" name="edate" placeholder="Enter Expiry Date">
  </div>
</div>
<div class="col-sm-6">
  <div class="form-group">
   
    <input type="text" class="form-control" id="ccode" name="ccode" placeholder="cvv">
  </div>
</div>
</div>
<div class="form-group">

    <input type="text" class="form-control" id="Ncard" name="Ncard" placeholder="Name On Card" style="width: 400px">
  </div>
  <input type="hidden" name="scid" value="<%=scid%>">
  <input type="hidden" name="email" value="<%=email%>">
  
  <input type="submit">
    </form>
</div>
<div class="col-sm-4"></div>

</div>
</body>
</html>