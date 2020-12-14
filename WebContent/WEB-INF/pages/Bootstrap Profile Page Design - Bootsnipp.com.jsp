<%@ page language="java"   contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.libra.model.User" %>
<!DOCTYPE html>
<!-- saved from url=(0138)file:///C:/Users/Mohit/Desktop/Bootstrap%20Snippet%20Bootstrap%20Profile%20Page%20Design%20using%20HTML%20CSS%20Bootstrap_files/K0ZmK.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="robots" content="noindex, nofollow">

    <title>Bootstrap Profile Page Design - Bootsnipp.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="./Bootstrap Profile Page Design - Bootsnipp.com_files/bootstrap.min(1).css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
    body{
    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
}
.emp-profile{
    padding: 3%;
    margin-top: 3%;
    margin-bottom: 3%;
    border-radius: 0.5rem;
    background: #fff;
}
.profile-img{
    text-align: center;
}
.profile-img img{
    width: 70%;
    height: 100%;
}
.profile-img .file {
    position: relative;
    overflow: hidden;
    margin-top: -20%;
    width: 70%;
    border: none;
    border-radius: 0;
    font-size: 15px;
    background: #212529b8;
}
.profile-img .file input {
    position: absolute;
    opacity: 0;
    right: 0;
    top: 0;
}
.profile-head h5{
    color: #333;
}
.profile-head h6{
    color: #0062cc;
}
.profile-edit-btn{
    border: none;
    border-radius: 1.5rem;
    width: 70%;
    padding: 2%;
    font-weight: 600;
    color: #6c757d;
    cursor: pointer;
}
.proile-rating{
    font-size: 12px;
    color: #818182;
    margin-top: 5%;
}
.proile-rating span{
    color: #495057;
    font-size: 15px;
    font-weight: 600;
}
.profile-head .nav-tabs{
    margin-bottom:5%;
}
.profile-head .nav-tabs .nav-link{
    font-weight:600;
    border: none;
}
.profile-head .nav-tabs .nav-link.active{
    border: none;
    border-bottom:2px solid #0062cc;
}
.profile-work{
    padding: 14%;
    margin-top: -15%;
}
.profile-work p{
    font-size: 12px;
    color: #818182;
    font-weight: 600;
    margin-top: 10%;
}
.profile-work a{
    text-decoration: none;
    color: #495057;
    font-weight: 600;
    font-size: 14px;
}
.profile-work ul{
    list-style: none;
}
.profile-tab label{
    font-weight: 600;
}
.profile-tab p{
    font-weight: 600;
    color: #0062cc;
}    </style>
    <script src="./Bootstrap Profile Page Design - Bootsnipp.com_files/jquery.min.js.download"></script>
    <script src="./Bootstrap Profile Page Design - Bootsnipp.com_files/bootstrap.min.js(1).download"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
    </script>
</head>
<body>


<h1 class="heading">${msg}</h1> 
<%  HttpSession s=request.getSession(false); 
 User student=(User)s.getAttribute("student");
//String s2=student.getImage();
%>
    <div class="container emp-profile">
    
           
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                         <img src=${path } alt="">
                            <div class="file btn btn-lg btn-primary">
                             <!--    Change Photo
                                <input type="file" name="file"> -->
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                       ${student.fullName}
                                    </h5>
                                    <h6>
                                        Student at MBM engineering college
                                    </h6>
                                  
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="https://s.bootsnipp.com/iframe/K0ZmK#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="https://s.bootsnipp.com/iframe/K0ZmK#profile" role="tab" aria-controls="profile" aria-selected="false">Timeline</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                       <form action="studentLogout">
<button  type="submit">logout</button>
</form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                            <p>Update Info</p>
                            <a href="https://s.bootsnipp.com/iframe/K0ZmK">Update Email Here!</a><br>
                            <a href="studentChangePass">Change Password</a><br>
                            <a href="https://s.bootsnipp.com/iframe/K0ZmK">Change contact Number</a>
                           
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Name</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.fullName}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.email}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Branch</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.branch}</p>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-6">
                                                <label>Year</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.year}</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Book-1</label>
                                                
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.book1} </p>
                                               
                                            </div>
                                             
                                        </div>
                                         
                                         <div class="row">
                                            <div class="col-md-6">
                                                <label>Book-2</label>
                                            </div>
                                          <div class="col-md-6">
                                                <p> ${student.book2}
                                               </p>
                                            </div>
                                             
                                        </div>
                                         <div class="row">
                                            <div class="col-md-6">
                                                <label>Book-3</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>${student.book3}</p>
                                            </div>
                                             
                                        </div>
                                        
                            </div>
                            
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Experience</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Hourly Rate</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>10$/hr</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Total Projects</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>230</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>English Level</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>Expert</p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Availability</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p>6 months</p>
                                            </div>
                                        </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label>Your Bio</label><br>
                                        <p>Your detail description</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    
        </div>	<script type="text/javascript">
		</script>

</body></html>