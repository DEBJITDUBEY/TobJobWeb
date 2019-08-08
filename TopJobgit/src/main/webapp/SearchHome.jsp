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
try{
String skills = request.getParameter("skills");
System.out.println(skills);
String askil[]=skills.split(",");
String location= request.getParameter("location");
System.out.println(location);
String salary= request.getParameter("salary");
System.out.println(salary);
String exp= request.getParameter("exp");
System.out.println(exp+":"+exp.length());
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
String sql="select * from jobs WHERE STATUS1='T' ";
System.out.println(666);
if(location.length()!=0) 
	 sql = sql + " and Job_location='"+ location+"'" ;
System.out.println(1+":"+sql);
if(salary.length()!=0) 
		 sql = sql + " and salary="+ salary ;
System.out.println(2+":"+sql);
if(exp.length()!=0) 
			 sql = sql + " and experience like'%"+ exp+"%' ";
System.out.println(3+":"+sql);
System.out.println(sql);

/* if(sql1.length()>0){
sql1=sql1.substring(0,sql1.lastIndexOf("AND"));
sql=sql+" where "+sql1; 
}*/
System.out.println("sql="+sql);
PreparedStatement smt=con.prepareStatement(sql);
/* smt.setString(1,location);
smt.setString(2,salary);
smt.setString(3,exp); */
ResultSet rs=smt.executeQuery();
while(rs.next()) {
	boolean flag=false;
	if(skills.length()!=0)  {
	String rskills= rs.getString(7);
	
	for(int i=0; i<askil.length; i++){
		if(rskills.indexOf(askil[i])!=-1) {
			flag=true;
			break;
		}
	}
	}
	System.out.println("Flag:"+flag);
	if(flag || skills.length()==0 ) {
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
  </div>
<%
	}
}
rs.close();
con.close();
}
catch(Exception e){
	System.out.println(e);
}
%>

</body>
</html>