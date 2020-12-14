<%@ page language="java"  session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<head>
  <title>login_pdf</title>
  <style>
body {
  font-family: Arial;
  color: white;
}

.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  left: 0;
  background-color: #e6e6e6;
  font-family: Arial, Helvetica, sans-serif;

}

.right {
  right: 0;
  background-color: #111;
   font-family: Arial, Helvetica, sans-serif;

}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  color: #a6a6a6;
}

.centered img {
  width: 150px;
  border-radius: 50%;
   font-family: Arial, Helvetica, sans-serif;

}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

.loginbtn {
  background-color: #800000;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 120%;
  opacity: 0.9;
}

.loginbtn:hover {
  opacity: 1;
}

a {
  color: dodgerblue;
}

.login {
  background-color: #f1f1f1;
  text-align: center;
  padding-left: 20px;
}

.container {
  padding: 16px;
  background-color: white;
  width: 120%;
}

input[type=text], input[type=password], input[type=email] {
  width: 80%;
  padding: 10px;
  margin: 5px 0 12px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

 input[type=password]:focus,input[type=email]:focus {
  background-color: #ddd;
  outline: none;
}

* {
  box-sizing: border-box;
}


</style>

</head>
<body>
<div class="split left">
  <div class="centered">
    <h2 >Please Enter Your Email:!</h2>
    <form action="adminForgotPassword">
      <div class="container">
    <input type="email" placeholder="Email" name="email"><br>
  <br>
  <hr>
    </div>
    <br>
    <button type="submit" class="loginbtn">Submit</button>
    </div></form>
  </div>
</div>

<div class="split right">
  <div class="centered">
    <h1>Welcome back!</h1>
    <p>Please enter your Email! Your link is valid only for few seconds.</p>
    <h4 style="color: #cc0000">iLovePDF Desktop Reader</h4>
  </div>
</div>

</body>
</html>