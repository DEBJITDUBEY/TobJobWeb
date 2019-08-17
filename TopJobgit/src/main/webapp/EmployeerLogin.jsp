<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css">
  
  
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
	 
$("form").submit(function() { 
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
  
  
  
</head>

<body background="employees.png" style="background-size: cover;">
<div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
  <div style="background-color:lightblue">
<%@include file="menubar.html"

%>
</div>
<center>
<h1>EMPLOYEE LOGIN</h1>
</center>
<br>
<br>
<br>
</div>
<div class="container">
	<div class="row">
  <div class="col-sm-4">
  </div>

  <div class="col-sm-4">
  
<form action="EmployeerLogin" method="post" id="form">
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
			<div id="emailerr"></div>
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="Password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password">
			<div id="pwderr"></div>
		</div>
		<center>
		<button type="submit" class="btn btn-success" id="submitbtn">Login</button> 
		<!-- <input type="submit" id="button" > -->
		</center>
	</form>
		<center>
	<button class="btn btn-info navbar-btn">New?Register</button>

	<a href="EmployeerPasswordRecovery.jsp" class="btn btn-danger" class="">forget password</a>
	</center>
</div>
<div class="col-sm-4">
  </div>

</div>
</div>
</body>
</html>