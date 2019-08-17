<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<html>
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

  <style type="text/css">
    .error
    {
      color: red;
      margin-left: 5px;
    }
  </style>
  <script type="text/javascript">


$(document).ready(function(){ 

	 
$('#form').submit(function(){

//e.preventDefault();
$(".error").remove();
var emailstr = $('#email').val();
var passwrdstr = $('#pwd').val();
var count=0;

if(emailstr.length<1){
    $('#email').after('<span class="error">Email is required</span>');  count++;
   }
else {
	   email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	   if(!email_regex.test(emailstr)){ 
		   $('#email').after('<span class="error">Email is invalid format</span>');  count++; 
		   }
	 }
   
if(passwrdstr.length<1){
    $('#pwd').after('<span class="error">Password is required</span>'); count++;
   }
  if(count==0)
	  return true;
  else
	  return false;
  
});

 }); 

</script>

<style type="text/css">
  .mega-menu{
    width: 400px;
    overflow: hidden;
    padding: 10px;
  }
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: blue;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: blue;}




</style>
</head>
<body>
  <div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
  <div style="background-color:lightblue">
<%@include file="menubar.html"%>
</div>
<div>
  <div class="wrapper-container">
     <div class="well">
    <div class="row">
      <div class="col-sm-1"></div>

      <div class="col-sm-1">
      <input type="text" name="skills" style="width: 200px;"  placeholder="Search for jobs" data-toggle="modal" data-target="#search"  >
      </div>
      <div class="col-sm-1"></div>
      <div class="col-sm-1">
        <button type="button"  class="btn btn-danger" data-toggle="modal" data-target="#search" >search</button>
      </div>
</div>
    </div>

  </div>
</div>
  <div class="wrapper container" style="border:1px solid #42f442">
  <div class="row" style="padding-top: 20px">

    <div class="col-sm-1"></div>
    
    <div class="col-sm-4" >
     
      <div class="well">
<div >
<form action="JobSeekerLogin" method="post" id="form">
  <center><h3>JobSeeker login</h3>
  <%
      String status=(String)request.getAttribute("status");
      if(status!=null){
        out.println("<hr><b>"+status+"</b>");
      }
  %>
  </center>
  <div class="form-group">
    <label >EMAIL:</label>
    <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label >PASSWORD:</label>
    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
  </div>
    <center><button type="submit" id="button" class="btn btn-success">Login</button>

     <button type="button"  class="btn btn-danger" >RESET</button>
     </center>
      </form>
     <center> <a href="JobSeeker.html">          Not registered yet???...                        register now</a></center>
   
   </div>
  </div>

  </div>
  <div class="col-sm-1"></div>
  <div class="col-sm-6">
    <div class="container-fluid">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="Image/job1.jpg" alt="Los Angeles">
    </div>

    <div class="item">
      <img src="Image/job1.jpg" alt="Chicago">
    </div>

    <div class="item">
      <img src="Image/job1.jpg" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>

</div>
</div>
</div>
<div>
 

</div>
 <div class="modal fade" id="search" tabindex="-1" role="dialog" aria-hidden="true">  
        <div class="modal-dialog">
            <div class="modal-content"> 
                  <div class="modal-body" style="width: 600px">
  <form action="SearchHome.jsp" id="form2">
   
   <div class="row">
     <div class="col-sm-3">
      <div class="form-group">
    <input type="skills" class="form-control" id="skills" name="skills" placeholder=" skills">
  </div>
     </div>
     <div class="col-sm-3">
      <div class="form-group">
    <input type="location" class="form-control" id="location" name="location" placeholder="location">
  </div>
</div>
  
  <div class="col-sm-2">
      <div class="form-group">
    <input type="salary" class="form-control" id="salary" name="salary" placeholder="salary">
  </div>
     </div>
      <div class="col-sm-2">
      <div class="form-group">
    <input type="exeperience" class="form-control" id="exp" name="exp" placeholder=" experience">
  </div>
     </div>
     <div class="col-sm-2">
     <button type="submit"  class="btn btn-danger" >search</button>
   </div>
   </div>
</form>
</div>
</div>
</div>


  </div>
  <div class="wrapper-container">
    <div class="well">
  <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-2">
    <img src="Image/Synechron_120X45_14112017.gif">
</div>
</div>
</div>
</div>
<%
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
PreparedStatement smt=con.prepareStatement("select * from jobs where status1='T'");
ResultSet rs=smt.executeQuery();
%>
  <div class="wrapper-container">
  <div class="well">
    <div class="row">
    <%
    while(rs.next()) {
      String url="ApplyJob?jobid="+rs.getString(1);
    %>
       <div class="col-sm-2">
        <label><%=rs.getString(4) %></label>
        <label><%=rs.getString(3) %></label>
       <label><%=rs.getString(10) %></label>
       <br>
       <a href="<%=url%>" class="btn btn-info" role="button">Apply</a>
       
      </div>
       <div class="col-sm-1">
        <label><label><%=rs.getString(8) %></label></label>
        <br>
        <label><label><%=rs.getString(9) %></label></label>
      </div>
      <%
      }
        %>
      </div>
    </div>
  </div><%
rs.close();
con.close();
%>


</body>
</html>