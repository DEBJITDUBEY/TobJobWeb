<!DOCTYPE html>
<html>
<head>
	<title></title>

	<meta charset="utf-8">
  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <script>

function check(){
   var x1 = document.getElementById("id1");
   var x2 = document.getElementById("id2");
   var x3 =document.getElementById("id3");
   var x4 =document.getElementById("id4");
   var y = document.forms["form"]["opt1"].checked;  
   var z = document.forms["form"]["opt2"].checked; 
   var a= document.forms["form"]["opt3"].checked; 
    var b= document.forms["form"]["opt4"].checked; 

  
   if (y === true) { 
    x1.style.display = "block" ;
  } else if (y === false) {  
    x1.style.display = "none";
  }
  if (z=== true) { 
    x2.style.display = "block" ;
  } else if (z === false) {  
    x2.style.display = "none";
  }
  if (a === true) { 
    x3.style.display = "block" ;
  } else if (a === false) {  
    x3.style.display = "none";
  }
  if (b=== true) { 
    x4.style.display = "block" ;
  } else if (b === false) {  
    x4.style.display = "none";
  }
 }



</script>
</head>
<body>
<div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
  <div style="background-color:lightblue">
  <%@include file="menubar.html"

    %>
</div>
<div class="well">
	<form name="form" action="JobSeakers" method="post" enctype="multipart/form-data"  >
<div class="row">
	<div class="col-sm-4">
	<div class="form-group">
			<label for="name">Full Name:</label>
			<input type="text" class="form-control" id="n1" name="name" placeholder="Enter Name">
		</div>

		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="Password" class="form-control" id="pwd" name="pwd" placeholder="Enter Password">
		</div>

		<div class="form-group">
			<label for="pwd1">Re-Password:</label>
			<input type="rePassword" class="form-control" id="pwd" name="rpwd" placeholder="Re-enter Password">
		</div>
		
		<div class="form-group">
			<label for="date_of_birth">Date of Birth:</label>
			<input type="date" name="dob">
</div>
			<div class="form-group">
				<label for="gender">Gender:</label>
				<input type="radio" name="gender" id="gender1" value="Male" checked> Male
				<input type="radio" name="gender" id="gender2" value="Female"> Female
</div>

<div class="form-group">
			<label for="phone number">Mobile Number:</label>
			<input type="text" class="form-control" id="p1" name="mobno" placeholder="Enter Number">
		</div>

<div class="form-group">
				<label for="gender">GOV ID PROOF</label>
				<input type="radio" name="GOVID" id="GOVID1" value="Male" checked> PAN
				<input type="radio" name="GOVID" id="GOVID2" value="Female"> ADHAR CARD
				<input type="radio" name="GOVID" id="GOVID3" value="Female"> VOTER CARD
</div>


<div class="form-group">
			<label for="id number">Id Proof Details:</label>
			<input type="text" class="form-control" id="p1" name="goviddetails" placeholder="Enter Number">
		</div>
			
		
			<div class="form-group">
    <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity" name="city">
    
    
</div>
      <div class="form-group">
    <label for="inputState">State</label>
      <input type="text" class="form-control" id="inputState" name="state">
   
     </div>
     <div>
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="inputZip" name="zip">
    </div>

    <div class="form-group">
      <label for="inputcountry">Country</label>
      <input type="text" class="form-control" id="inputcountry" name="country">
    </div>
</div>
<div class="col-sm-4">
<table>
<tr><th>Educational Details:</th>
<td><input  type='checkbox' name='opt1' value="1" onclick="check()">Class 10
<input  type='checkbox' name='opt2' value="2" onclick="check()">Class 12
<input  type='checkbox' name='opt3' value="3" onclick="check()">Graduation
<input  type='checkbox' name='opt4' value="4" onclick="check()">Others
</td></tr>
</table>

<div id="id1" style="display:none">
<!-- <form name="form2"> -->

<div class="form-group"><h2>Class 10</h2>
      <label for="board">Passing Board</label>
      <input type="text" class="form-control" id="board" name="10board">
    </div>
     <label for="Year">Passing Year</label>
        <select  class="form-control" id="year1" name="10year">
          <option>2012</option>
          <option>2013</option>
          <option>2014</option>
          <option>2015</option>
          <option>2016</option>
          <option>2017</option>
          <option>2018</option>
</select>

    <div class="form-group">
      <label for="score">Marks</label>
      <input type="text" class="form-control" id="marks" name="10marks">
    </div>
<!-- </form> -->
</div>
<div id="id2" style="display:none">
<!-- <form name="form2"> -->
<div class="form-group"><h2>Class 12</h2>
      <label for="board">Passing Board</label>
      <input type="text" class="form-control" id="12board" name="12board">
    </div>
     <label for="Year">Passing Year</label>
        <select  class="form-control" id="year2" name="12year">
          <option>2012</option>
          <option>2013</option>
          <option>2014</option>
          <option>2015</option>
          <option>2016</option>
          <option>2017</option>
          <option>2018</option>
</select>

    <div class="form-group">
      <label for="score">Marks</label>
      <input type="text" class="form-control" id="12marks" name="12marks">
    </div>

<!-- </form> -->
</div>

<div id="id3" style="display:none">
<!-- <form name="form2"> -->

<div class="form-group"><h2>Graduation</h2>
      <label for="board">Passing University</label>
      <input type="text" class="form-control" id="uni" name="uni">
    </div>

    <div class="form-group">
      <label for="board">College Name</label>
      <input type="text" class="form-control" id="gradcolname" name="gradcolname">
    </div>
    <div class="form-group">
      <label for="subject">Branch</label>
      <input type="text" class="form-control" id="subject" name="branch">
    </div>

     <label for="Year">Passing Year</label>
        <select  class="form-control" id="year1" name="gradyear">
          <option>2012</option>
          <option>2013</option>
          <option>2014</option>
          <option>2015</option>
          <option>2016</option>
          <option>2017</option>
          <option>2018</option>
</select>

    <div class="form-group">
      <label for="score">Marks</label>
      <input type="text" class="form-control" id="marks" name="gradmark">
    </div>
    
<!-- </form> -->
</div>
</div>
<div class="col-sm-4">
	<div id="id4" style="display:none">
<!-- <form name="form2"> -->

<div class="form-group"><h2>Others</h2>
      <label for="board">Passing University</label>
      <input type="text" class="form-control" id="board" name="otherboard">
    </div>

    <div class="form-group">
      <label for="board">College Name</label>
      <input type="text" class="form-control" id="board" name="othercolname">
    </div>

     <label for="Year">Passing Year</label>
        <select  class="form-control" id="year1" name="otheryear">
          <option>2012</option>
          <option>2013</option>
          <option>2014</option>
          <option>2015</option>
          <option>2016</option>
          <option>2017</option>
          <option>2018</option>
</select>

    <div class="form-group">
      <label for="score">Marks</label>
      <input type="text" class="form-control" id="othermark" name="othermark">
    </div>
<!-- </form> -->
</div>
<div class="custom-file">
				<label for="customfile">Upload resume:</label>
				<input type="file"  id="customfile1" name="customfile1">
			</div>

			<div class="custom-file">
				<label for="photo">Upload photo:</label>
				<input type="file"  id="customfile" name="customfile">
			</div>

	<div class="form-group">
			<label for="salary">Expected Salary:</label>
			<input type="number" class="form-control" id="s1" name="salary">
		</div>
		<button class="btn btn-info navbar-btn">Register</button>
</div>
</div>
</form>
</div>
</body>
</html>