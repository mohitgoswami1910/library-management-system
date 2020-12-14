<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V13</title>
</head>
<body style="background-color: #999999;">
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
	<div>
		<div class="container-login100">
			<div class="login100-more" style="background-image: url('images/bg-01.jpg');"></div>

			<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
				<form action="addStudent" onSubmit=" return checking()"  method="post" enctype="multipart/form-data">
					<span class="login100-form-title p-b-59">
						Sign Up
					</span>

					<div class="wrap-input100 validate-input" data-validate="Name is required">
						<span class="label-input100">Full Name</span>
						<input class="input100" type="text" name="fullName" placeholder="Name...">
						<span class="focus-input100"></span>
					</div>
							<div class="wrap-input100 validate-input" data-validate = "Valid registration no is required">
						<span class="label-input100">FacultyNo</span>
						<input class="input100" type="text" name="facultyNo" placeholder="FacultyNo">
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="year is required">
						<span class="label-input100">Year</span>
						<input class="input100" type="text" name="year" placeholder="year...">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<span class="label-input100">Email</span>
						<input class="input100" type="text" name="email" placeholder="Email addess...">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Username is required">
						<span class="label-input100">Registration_No</span>
						.<input class="input100" type="text" name="Registration_No" placeholder="Username...">
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Username is required">
						<span class="label-input100">Branch</span>
						.<input class="input100" type="text" name="branch" placeholder="Branch...">
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input  type="password" name="password" placeholder="enter password" id="pwd">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Repeat Password is required">
						<span class="label-input100">Repeat Password</span>
						<input type="password" placeholder="confirm password" id="cpwd">
						<span class="focus-input100"></span>
					</div>
							<div class="wrap-input100 validate-input" data-validate = "Valid registration no is required">
						<span class="label-input100">image</span>
						<input class="input100" type="file" name="image" placeholder="image">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-m w-full p-b-33">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								<span class="txt1">
									I agree to the
									<a href="#" class="txt2 hov1">
										Terms of User
									</a>
								</span>
							</label>
						</div>

						
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="submit" >
								submit
							</button>
						</div>

						<a href="#" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							Sign in
							<i class="fa fa-long-arrow-right m-l-5"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="js/main.js"></script>

</body>
</html>