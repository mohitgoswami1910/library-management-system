package com.libra.controller;


import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.libra.model.User;
import com.libra.services.adminServices;


@Controller
public class adminController {
	@Autowired
	adminServices w;

	@RequestMapping(value="/")
	public String home(){
		return "home";
	}
		@RequestMapping(value="adminLogin", method=RequestMethod.POST)
		public String login(User u,HttpServletRequest req,HttpServletResponse res)
		{
			/* 	ArrayList<User> z=w.fetchData();
			req.setAttribute("list",z);*/ 
			HttpSession session=req.getSession(false);
			
			if(session!=null){
			
		     return "adminHome";
			}else{
			int x=w.login(u);
			
		    if(x==1){
		        HttpSession s=req.getSession();
		    	s.setAttribute("password", u.getPassword());
				s.setAttribute("email", u.getEmail());
		  
		 return "adminHome";
		 
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
		 

}
		
		@RequestMapping(value="adminChangePassword", method=RequestMethod.POST)
		public String passwordChange(User u,HttpServletRequest req){
			
			HttpSession s=req.getSession(false);
			if(s!=null){
				String mail=(String) s.getAttribute("email");
			String p1=(String)s.getAttribute("password");
			String p2=u.getPassword();
			if(p1.equals(p2)){
				w.adminChangePassword(mail,req);
				s.invalidate();
				req.setAttribute("msg"," Admin! your password is changed succesfully");
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
		@RequestMapping(value="adminForgotPassword")
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
			return "adminEnterOtp";}

			else{
				req.setAttribute("msg", "no account with this email is found");
				return "home";
			}
		}
		
		@RequestMapping(value="adminVerifyOtp", method=RequestMethod.POST)
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
					req.setAttribute("msg", "your password reset succesfully");
			return "home";		
				}
				else{
					req.setAttribute("msg", "please enter correct otp");
					return "adminEnterOtp";
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
		@RequestMapping(value="/adminLogout")
		public String logout(HttpServletRequest req,HttpServletResponse res){
			HttpSession s=req.getSession(false);
			s.invalidate();
			return "home";
		
		}
		
		@RequestMapping(value="enterAdminEmail")
		public String otpVerification(){
return "adminEnterEmail";
		}

		@RequestMapping(value="changePass")
		public String changepass(){
return "changePass";
		}
}
