<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #4286f4;
}

#regForm {
  background-color: #4286f4;
  margin: 100px auto;
 padding: 40px;
  width: 70%;
  min-width: 300px;
/*   background-image: url(Image/job1.jpg); */
  background-size: cover;
   border-radius: 100px;
}

h1 {
  text-align: center;  
}
/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
  display: none;
}

button {
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
  border-radius: 30px;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: #4CAF50;
}
</style>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
  <body>
  
  <div>
    <a href="index.jsp"> <img src="Image/jobslogo.jpg" style="width: 100px; height: 100px;"></a>
  </div>
  <div style="background-color:lightblue">
<%@include file="menubar.html"

%>
</div>
<form id="regForm" method="post" action="EmployeerRegistration" enctype="multipart/form-data" >
  <h1>Register:</h1>
  <div class="tab" id="tab1">
   <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
 <h2>Registration Form</h2>

  <div class="form-group">
   <label >Email:</label>
   <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
   <div id="emailerr"></div>
   </div>

   <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
    <div id="pwderr"></div>
   </div>
   
<div class="form-group">
   <label >MOBILE-NO:</label>
   <input type="text" class="form-control" id="mob" name="mob" placeholder="Enter email">
   <div id="moberr"></div>
   </div>
</div>
<div class="col-sm-4"></div>
</div>
</div>
                      
          
  <div class="tab" id="tab2">Personal info:
    <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
    <label >Registers Name:</label>
   <input type="text" class="form-control" id="Rname" name="Rname" placeholder="Enter Your name">
   <div id="Rnameerr"></div>
 <label >Company name:</label>
   <input type="text" class="form-control" id="Cname" name="Cname" placeholder="Enter Your company name">
 <div id="Cnameerr"></div>
<label for="Industry">Industry type:</label>
    <select class="form-control" id="i1" name="industryname">
        <option value='IT'>IT</option>
        <option value='GOV'>GOV</option>
        <option value='INTERNATIONAL'>INTERNATIONAL</option>
        <option value='NON-IT'>NON-IT</option>
         <option value='OTHERS'>OTHERS</option>
    </select>
    <label for="designation">DESIGNATION:</label>
    <select class="form-control" id="designation" name="designation"">
        <option value='MANAGER'>MANAGER</option>
        <option value='EMPLOYER'>EMPLOYER</option>
        <option value='OTHERS'>OTHERS</option>
      </select>
       <label for="type">TYPE:</label>
    <select class="form-control" id="c3" name="type">
        <option value='MANAGER'>COMPANY</option>
        <option value='EMPLOYER'>CONSULTANT</option>
      </select>
    <br>
     <label >GST NO:</label>
   <input type="text" class="form-control" id="GSTNO" name="GSTNO" placeholder="Enter GST no">
  <div id="GSTNOerr"></div>
  </div>
  <div class="col-sm-4"></div>
  </div>


  
</div>
  <div class="tab" id="tab3">
    <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
     <label for="Office Address">Office Address:</label>
      <input type="text" class="form-control" id="o1" name="o1" placeholder="Enter Address">
     <div id="o1err"></div>

       <label for="City">City</label>
      <input type="text" class="form-control" id="c1" name="c1" placeholder="Enter City">
        <div id="c1err"></div>
      <label for="pin">Pin</label>
      <input type="text" class="form-control" id="p1" name="p1" placeholder="Enter Pin">
     <div id="p1err"></div>

      <label for="Country">Country</label>
        <select multiple class="form-control" id="co1" name="co1">
          <option>India</option>
          <option>Australia</option>
          <option>America</option>
          <option>Iran</option>
          <option>Russia</option>
          <option>China</option>
          <option>France</option>
</select>

 <label for="office number">Office Number</label>
      <input type="text" class="form-control" id="on1" name="on1" placeholder="Enter Number">
      <div id="on1err"></div>
      </div>
      <div class="col-sm-4"></div>
  
</div>
</div>
        <div class="tab" id="tab4">
    <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-4">
<label for="profile photo">Profile Photo(Jpg File):</label>
      <input type="file" class="form-control" id="p2" name="p2" placeholder="upload photo">
      <div id="p2err"></div>
      <label for="id">Government Id</label>
      <input type="text" class="form-control" id="c2" name="c2" placeholder="Enter id number">
      <div id="c2err"></div>
       </div>
       <div class="col-sm-4"></div>
  
</div>
</div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
</form>

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");

  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  
  if(valid)  {
  if(currentTab==0){
	  var email = document.getElementById("email").value;
	  var emailrr = document.getElementById("emailerr");
	  var pwd = document.getElementById("pwd").value;
	  var pwderr = document.getElementById("pwderr");
	  var mob = document.getElementById("mob").value;
	  var moberr = document.getElementById("moberr");
	  
	  var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	  var mob_regex = /^[1-9]{1}[0-9]{9}$/i;
	  if(!email_regex.test(email)){ 
		  emailerr.innerHTML='Email is invalid'; 
		  valid=false;
		 }
	  else{
		  emailerr.innerHTML=''; 
	  }
	  if(!mob_regex.test(mob)){
		  moberr.innerHTML='Mobile Number is invalid'; 
		  valid=false;
	  }
	  else{
		  moberr.innerHTML=''; 
	  }
	  
	  
	  
  }
  
  if(currentTab==1){
	  var rname = document.getElementById("Rname").value;
	  var rnameerr = document.getElementById("Rnameerr");
	  var Cname = document.getElementById("Cname").value;
	  var Cnameerr = document.getElementById("Cnameerr");
	  var GSTNO = document.getElementById("GSTNO").value;
	  alert("gst_no:"+GSTNO);
	  var GSTNOerr = document.getElementById("GSTNOerr");
	  
	  var Cname_regex = /^[a-zA-Z ]{6,}$/i;
	  var rname_regex = /^[a-zA-Z ]{6,}$/i;
	  var Gst_regex = /^[0-3]{1}[0-5]{1}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9]{1}[A-Z]{1}[0-9]{1}$/i;
	  if(!rname_regex.test(rname)){ 
		  rnameerr.innerHTML='Name is invalid'; 
		  valid=false;
		 }
	  else{
		  rnameerr.innerHTML=''; 
	  }
	  
	  
	  if(!Cname_regex.test(Cname)){ 
		  Cnameerr.innerHTML='Company Name is invalid'; 
		  valid=false;
		 }
	  else{
		  Cnameerr.innerHTML=''; 
	  }
	  
	  
	  if(!Gst_regex.test(GSTNO)){ 
		  GSTNOerr.innerHTML='PROPER FORMAT  22ABCDE1234F2Z5'; 
		  valid=false;
		 }
	  else{
		  GSTNOerr.innerHTML=''; 
	  }
	  
  }
  if(currentTab==2){
	  var o1 = document.getElementById("o1").value;
	  var o1err = document.getElementById("o1err");
	  var c1 = document.getElementById("c1").value;
	  var c1err = document.getElementById("c1err");
	  var p1 = document.getElementById("p1").value;
	  var p1err = document.getElementById("p1err");
	  
	  var on1 = document.getElementById("on1").value;
	  var on1err = document.getElementById("on1err");
	  var C1_regex = /^[a-zA-Z]{6,}$/i;
	  var o1_regex = /^[a-zA-Z0-9 ,# ]{10,}$/i;
	  var P1_regex = /^[0-9]{7,}$/i;
	  var on1_regex = /^[1-9]{1}[0-9]{9}$/i;
	  if(!o1_regex.test(o1)){ 
		  o1err.innerHTML='Address is invalid'; 
		  valid=false;
		 }
	  else{
		  o1err.innerHTML=''; 
	  }
	  
	  
	  if(!C1_regex.test(c1)){ 
		  c1err.innerHTML='City Name is invalid'; 
		  valid=false;
		 }
	  else{
		  c1err.innerHTML=''; 
	  }
	  
	  
	  if(!P1_regex.test(p1)){ 
		  p1err.innerHTML='pin is invalid'; 
		  valid=false;
		 }
	  else{
		  p1err.innerHTML=''; 
	  }
	  
	  if(!on1_regex.test(on1)){ 
		  on1err.innerHTML='Number is invalid'; 
		  valid=false;
		 }
	  else{
		  on1err.innerHTML=''; 
	  }
	  
	  
	  
  }
  
  if(currentTab==3){
	  var c2 = document.getElementById("c2").value;
	  var p2= document.getElementById("p2").value;
	  
	  var c2err= document.getElementById("c2err");
	  var p2err= document.getElementById("p2err");
	  
	  var pos=p2.lastIndexOf(".");
	  var str=p2.substr(pos+1);
	 
	  if(!(str=='jpg' || str=='jpeg')){
		  p2err.innerHTML='Image format invalid'; 
		  valid=false;
		 }
	  else{
		  p2err.innerHTML=''; 
	  }
	  
	  
	  
   alert(c1+" "+p1);
  }
  
  }
  
  
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>

</body>
</html>
