<!DOCTYPE html>
<%@ page language="java"  session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

  body{
    
    margin-bottom: 50px;
    background-image: url(https://images.unsplash.com/photo-1544830281-1d5169d6b2af?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80
    );
     background-repeat: no-repeat;
     background-size: cover;
 font-family: Arial, Helvetica, sans-serif;
 
  }
  
.registerbtn {
  background-color: red;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 50%;
  padding-left: 100px;
  padding-right: 100px;
  padding-top: 100px;
  
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}
  label{
      display: inline-block;
      padding-left: 20px;
      padding-top: 10px;
      padding-bottom: 10px; 
      font-size: 20px;
      text-align: left;
      color: black;
      float: left;
    }

/* Style the counter cards */
.card {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;

}

</style>
</head>
<header style="background-color: red;text-align: center; font-family: Arial, Helvetica, sans-serif;
">
  <h1 style="color: white;padding-top: 20px;padding-bottom: 20px">MBM Library Management!</h1>
  
</header>

 <h1  style="color: white;padding-top: 20px; text-align: center; padding-bottom: 20px">${msg}</h1>
<body>
<div class="row">
  <div class="column">
    <div class="card">
      <form  action="studentLogin" method="post">
            <h1>Student Portal</h1>
      <h3>Please enter your details to login</h3>
      <hr>
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" id="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="psw" required>
      <hr>
    
      <a href="enterStudentEmail">Forgot Password</a>
 
      <button type="submit" class="registerbtn">Login</button>
      </form>
      <p style="color: black"><center>don't have an account ? create one here<a href="studentSignup";>SignUp</a></center></p>
    
      </div>
      </div>

  <div class="column">
    <div class="card">
      <form  action="adminLogin" method="post">
            <h1>Admin Portal</h1>
      <h3>Please enter your details to login</h3>
      <hr>
      <label for="email"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="email" id="email" required>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="psw" required>
      <hr>
      <a href="enterAdminEmail">Forgot Password</a>
 
      <button type="submit" class="registerbtn">Login</button>
     
      </form>
      </div>
  </div>
  </div>
</body>
</html>
