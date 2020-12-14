<%@ page language="java"   session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="getDetail">
	<span>Registration_No</span>
	<input name="Registration_No" type="text" placeholder="enter your Registration-no" ><br>
	<button type="submit">issueBook</button><br>
	</form>
	
<form action="bookList">
	<button type="submit">Check available Books</button><br>
	</form>
	<h1 class="heading">${msg}</h1> 

	
<script>	

	function checking()
	{
		var pwd=document.getElementById("pwd").value;
		var cpwd=document.getElementById("cpwd").value;
		alert("in checking");
		if(pwd==cpwd)
			return true;
		else
			{
			alert("invalid details");
			return false;
			}
	}
</script>

<form action="adminChangePassword" onSubmit=" return checking()" >
<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<span class="label-input100">old Password</span>
						<input  type="password" name="password" placeholder="enter new password" >
						<span class="focus-input100"></span>
					</div>

<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<span class="label-input100">new Password</span>
						<input  type="password" name="newPassword" placeholder="enter new password" id="pwd">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Repeat new Password is required">
						<span class="label-input100">confirm new Password</span>
						<input type="password" placeholder="confirm password" id="cpwd">
						<span class="focus-input100"></span>
					</div>
<button  type="submit">change password</button>
</form>
	
	
	

</body>
</html>