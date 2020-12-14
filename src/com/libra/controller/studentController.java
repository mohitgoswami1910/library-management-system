package com.libra.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.libra.model.User;
import com.libra.services.studentServices;
@Controller
public class studentController{
	@Autowired
	studentServices w;
	
	@RequestMapping(value="studentSignup")
public String studentSignup(){
		return "studentSignup";
	}
	@RequestMapping(value="addStudent")
	public String adduser(User u,HttpServletRequest req){
		
	int x=w.addStudent(u);
	if(x==1){
	req.setAttribute("msg","email id already registerd");
		return "studentSignup";
	}
	else{
		req.setAttribute("msg","successfully signup please login to continue");
		return "home";
	}
	
	}

	@RequestMapping( value="studentLogin", method=RequestMethod.POST)
	public String login(User u,HttpServletRequest req)
	{
		HttpSession session=req.getSession(false);
		
		if(session!=null){
		
	     return "Bootstrap Profile Page Design - Bootsnipp.com";
		}
		else{
			
			 if(u.getEmail()!=null && u.getPassword()!=null)
			 {
	                int x=w.studentLogin(u);
	                if(x==1){
		            HttpSession s=req.getSession();
		            User ux=w.studentProfile(u,req);
		            s.setAttribute("student", ux);
	                return "Bootstrap Profile Page Design - Bootsnipp.com";
	                  }
	                else if(x==2){
		            req.setAttribute("msg","wrong password");
		            return "home";
	                             }	

	                else{
		            req.setAttribute("msg","emailid not registerd");
	                return "home";
	                     }
			   }
			 else{
				 req.setAttribute("msg","you must login first");
				  return "home";
			      }
		}
		

	  	
	}
	@RequestMapping(value="studentLogout")
	public String logout(HttpServletRequest req){
		HttpSession s=req.getSession(false);
		s.invalidate();
		return "home";
		
	}
	@RequestMapping(value="studentChangePassword", method=RequestMethod.POST)
	public String passwordChange(User u,HttpServletRequest req){
		
		HttpSession s=req.getSession(false);
		if(s!=null){
			User ux=(User)s.getAttribute("student");
		String p1=ux.getPassword();
		String p2=u.getPassword();
		if(p1.equals(p2)){
			w.changePassword(req,ux);
			s.invalidate();
			req.setAttribute("msg"," your password changed succesfully");
			return "home";
		}
		else{
			req.setAttribute("msg"," please enter correct password");
			return "studentProfile1";
		}
		
		}
		else{
			req.setAttribute("msg"," please login first");
			return "home";
		}
		
	}
	@RequestMapping(value="studentForgotPassword")
	public String forgotPassword(User u,HttpServletRequest req) throws MessagingException{
		
		String email=u.getEmail();
		int x=w.emailVerify(email);
		if(x==1){
		sendMail mail=new sendMail();
	    String otp=getOtp();
	     mail.sendEmail(email, "mohitgoswami133@gmail.com", otp);
	    HttpSession s=req.getSession();
	    s.setAttribute("email",email );
	    s.setAttribute("otp",otp );
		return "enterStudentOtp";}

		else{
			req.setAttribute("msg", "no account with this email is found");
			return "studentEnterEmail";
		}
	}
	
	@RequestMapping(value="verifyStudentOtp", method=RequestMethod.POST)
	public String otpVerification(HttpServletRequest req){
		HttpSession s=req.getSession(false);
		if(s!=null){
		String email=(String) s.getAttribute("email");
		String otp1=(String) s.getAttribute("otp");
			String otp=req.getParameter("otp");
			String password=req.getParameter("newPassword");
			if(otp1.equals(otp)){
				w.resetPassword(email,password);
				s.invalidate();
				req.setAttribute("msg", "your password is reset succesfully");
		return "home";		
			}
			else{
				req.setAttribute("msg", "please enter correct otp");
				return "enterStudentOtp";
			}}
		else{
			return "home";		}
		
		
	
	
	}
	public String getOtp(){	
		Random obj = new Random(); 
        char[] otp = new char[6]; 
	    for (int i=0; i<6; i++) 
        { 
           otp[i]= (char)(obj.nextInt(10)+48); 
          } 
        String otp1 = String.valueOf(otp);
	    return otp1;
	                      }
	
	
	@RequestMapping(value="enterStudentEmail")
	public String otpVerification(){
return "studentEnterEmail";
	}
	@RequestMapping(value="studentChangePass")
	public String changepass(){
return "studentChangePass";
	}
}
