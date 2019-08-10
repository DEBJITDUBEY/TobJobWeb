<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="EmployeerMenubar.jsp" %>


<div class="wrapper-container">
	<div class="well"> 
		<form action="JobPost" method="post">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				
<div class="form-group">
    <label >Job Title:</label>
    <input type="text" class="form-control" id="jtitle" name="jtitle" placeholder="jobid">
  </div>
</div>
  <div class="col-sm-3">
  <div class="form-group">
    <label >Company Name</label>
    <input type="text" class="form-control" id="cname" name="cname" placeholder="Enter password">
  </div>
</div>
</div>
<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-3">
      <div class="form-group">
   <center> <label >Company Website</label></center>
    <input type="text" class="form-control" id="jweb" name="jweb" placeholder="Enter password">
  </div>
</div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-6">
  <div class="form-group">

 
    <label >Job Description:</label>
    <textarea class="form-control" id="jdescription" name="jdescription" placeholder="jobid"></textarea>
</div>


			</div>
		</div>

<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				
<div class="form-group">
    <label >Skill:</label>
    <input type="text" class="form-control" id="jskill" name="jskill" placeholder="jobid">
  </div>
</div>
  <div class="col-sm-3">
  <div class="form-group">
    <label >Experience</label>
    <input type="text" class="form-control" id="jexperience" name="jexperience" placeholder="Enter password">
  </div>
</div>
</div>
<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-3">
				
<div class="form-group">
    <label >Salary:</label>
    <input type="text" class="form-control" id="jsalary" name="jsalary" placeholder="jobid">
  </div>
</div>
  <div class="col-sm-3">
  <div class="form-group">
    <label >Location</label>
    <input type="text" class="form-control" id="jlocation" name="jlocation" placeholder="Enter password">
  </div>
</div>
</div>
<div class="row">
	<div class="col-sm-4"></div>
<div class="col-sm-3">
	<button type="submit" class="btn btn-success">SUBMIT</button>
	<button type="reset" class="btn btn-danger">RESET</button>
</div>

</div>
</form>
	</div>


</div>


</body>
</html>