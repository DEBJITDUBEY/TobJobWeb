<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css">
  <script src="jquery.min.js"></script>
  <script src="bootstrap.min.js"></script>
  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
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
  
<form action="EmployeerLogin" method="post">
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="Password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password">
		</div>
		<center>
		<button class="btn btn-success" >Login</button>
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
</body>
</html>