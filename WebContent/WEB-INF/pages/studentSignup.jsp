
<!DOCTYPE html>
<html>
<head>
	<title>Sign Up Portal...</title>
	
	
</head>
<h1>${msg}</h1>
<style type="text/css">
	*{box-sizing: border-box;}
	@media screen and (max-width: 600px) 
	{
  	.col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
     }
     
	}
	.col-70{
		width: 70;
		margin-top:6px;
		padding-left: 20px;
		}
	.col-30{
		width: 30;
		margin-top:6px;
	}
	.container{
		padding: 16 px;
		color: white;
		
	}
	label{
			display: inline-block;
			padding-left: 20px;
			padding-top: 10px;
			padding-bottom: 10px; 
			font-size: 20px;
			text-align: left;
			color: white;
		}
	input[type=email],input[type=password],input[type=text]
	{
		width: 50%;
		padding: 10px;
		display: inline-block;
		background-color: #f1f1f1;
		border: none;

		}
	.signUp{
		background-color: #000066;
		width: 50%;
		color: dodger-blue;
		margin-top: 10px;
		margin-bottom: 10px;
		padding: 16px 20px;
		
	}
	.wrapper{
		text-align: center;
		color: black;
	}
	.img{
		width: 399px;
		height: 200px;
		text-align: right;
			}
	
	.signbutton{
		color: white;
		background-color: #000066;
		padding: 10px 20px 20px 10px;
		opacity: 0.9;
		cursor: pointer;
		margin: 18px 0px;
		border: none;
		width: 50%;
		}
	
	a{
		color: dodgerblue;
	}
	form{
		
		margin-bottom: 50px;
		background-image: url(https://free4kwallpapers.com/uploads/originals/2019/03/14/the-library-wallpaper.jpg);
	}
	
	.image:before {
        content: "";
        display: inline-block;
        vertical-align: middle;
    	min-height: 150px;
    }
    
    .image {
        -moz-box-sizing: border-box;
        border: 1px solid #DDDDDD;
        float: right;
        margin-bottom: 10px;
        padding: 10px;
        margin-right: 10px;
    }

</style>
<body>
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

<div class="bg-image"></div> 
<form action="addStudent" onSubmit=" return checking()"  method="post" enctype="multipart/form-data">
	<div class="container">
	<h2><center>Welcome to MBM Library portal</center></h2>	
	<p style="padding-left: 20px;">Please fill your details: </p>
	</div>

	<div class ="image" data-validate="image is required">
		<input type="file" name="image" placeholder="pease attach your image">

	</div>

	<div class="col-30">
		<label for="email">FullName</label>
	</div>
	<div class="col-70" data-validate="fullName is required">
		<input type="text" name="fullName" placeholder="Enter your Name">
	</div>
	
	<div class="col-30">
		<label for="FacultyNo">Faculty number</label>
	</div>
	<div class="col-70" data-validate="FacultyNo is required">
		<input type="text" name="FacultyNo" placeholder="your faculty number please!">
	</div>
	<div class="col-30">
		<label for="email">Email</label>
	</div>
	<div class="col-70" data-validate="email is required">
		<input type="email" name="email" placeholder="your email please!">
	</div>
	<div class="col-30">	
		<label for="year">Year</label>
		</div>
	<div class="col-70" data-validate="year is required">
	 <input type="text" name="year" placeholder="Enter your year">
	</div>
	
	<div class="col-30">	
		<label for="Branch">Branch</label>
		</div>
	<div class="col-70" data-validate="branch is required">
	
		<input type="text" name="branch" placeholder="Enter your Branch">
	</div>
	
	<div class="col-30">	
		<label for="Registration_No">Registration number</label>
		</div>
	<div class="col-70" data-validate="Registration_No is required">
	
		<input type="text" name="Registration_No" placeholder="Enter your Registration number">
	</div>
	<div class="col-30">
		<label for="password">Password</label>
	</div>
	<div class="col-70" data-validate="password is required">
		<input type="password" name="password" placeholder="your password please!" id="pwd">
	</div>
	<div class="col-30">
		<label for="password">Confirm Password</label>
	</div>
	<div class="col-70" data-validate="ConfirmPassword is required">
		<input type="password" name="ConfirmPassword" placeholder="confirm your password please!" id="cpwd">
	</div>

	<div class="col-30">	
		<label for="dob">Date of Birth</label>
		</div>
	<div class="col-70" >
		<input type="date" name="DOB" placeholder="DD/MM/YYYY">
	</div>


	<div class="wrapper">
	
	
	<button type="submit" class="signbutton"><center>signUp</center></button>
	</form>
</body>
</html>

