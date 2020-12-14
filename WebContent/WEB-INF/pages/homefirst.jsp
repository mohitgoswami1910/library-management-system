<%@ page language="java"  session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>HOME</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.div{display:flex;width:90%;margin-left:10%;height:55%;margin-top:10%;}
.div-div{width:30%;}
.heading{margin-left:32%;}
</style>
</head>
<body>
<div class="div">
<div class="div-div">
	<h1>STUDENT</h1>
	
	<form  action="studentLogin">
	<span>Email</span>
	<input name="email" type="text" placeholder="enter your email" id="emailId" ><br>
	<span>password</span>
	<input name="password" type="password" placeholder="enter your password"><br>
	<button type="submit">login</button><br>
	<a href="studentSignup">singup now</a>
	
	
	</form>
	
	<form  action="forgotPassword">
	<span>Email</span>
	<input name="email" type="text" placeholder="enter your email" id="emailId" ><br>
    <button type="submit">forgotPassword</button><br>
		</form>
   
</div>

<div class="div-div">
	<h1>ADMIN</h1>
	
	<form action="adminLogin">
	<span>Email</span>
	<input name="email" type="text" placeholder="enter your email" ><br>
	<span>password</span>
	<input name="password" type="password" placeholder="enter your password"><br>
	<button type="submit">login</button><br>

	</form>  
	
	
	<form  action="adminForgotPassword">
	<span>Email</span>
	<input name="email" type="text" placeholder="enter your email" id="emailId" ><br>
    <button type="submit">forgotPassword</button><br>
		</form>
   
</div>
</div>
<h1 class="heading">${msg}</h1> 
</body>
</html>