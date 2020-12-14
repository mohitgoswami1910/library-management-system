package com.libra.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.libra.model.Book;
import com.libra.model.User;
import com.libra.services.bookServices;

@Controller
public class bookController {
@Autowired
bookServices w;
	@RequestMapping(value="/getDetail")
	public String BookIssue(User u,HttpServletRequest req,HttpServletResponse res){
		HttpSession s=req.getSession(false);
		if(s!=null){
			 if( req.getAttribute("Registration_No")==null)
			 { req.setAttribute("Registration_No",  req.getParameter("Registration_No"));}
			    User student=w.getDetail(u,req);
		        s.setAttribute("student", student);
		        return "studentProfile";
		
		}
		else{
		
			return "New";
			
			
		}                                              }
	
	@RequestMapping(value="/bookList")
	public String bookList(HttpServletRequest req){
		List<Book> bookList=w.bookList();
		  req.setAttribute("book", bookList);
		
		return "bookList";
		
		
	}
	@RequestMapping(value="/addBook")
	public String addBook(Book b,HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		HttpSession s=req.getSession(false);
		if(s==null){
			req.setAttribute("msg", "please login first");
		return "home";	
		}
		else{
		int flag=w.addBook(s,b);
		
		if(flag==0)
			req.setAttribute("msg", "book added succesfully");
		if(flag==1)
			req.setAttribute("msg", "book is not found please check name once again");
		if(flag==2)
			req.setAttribute("msg", "your limit is reached");
		if(flag==3)
			req.setAttribute("msg", "student is not valid");
		
		RequestDispatcher rd=req.getRequestDispatcher("/getDetail");
		User st=(User) s.getAttribute("student");
		req.setAttribute("Registration_No", st.getRegistration_No());
		rd.forward(req, res);
		return "home";
		}
		}

	
	@RequestMapping(value="/returnBook")
	public String returnBook(HttpServletRequest req,HttpSession session,HttpServletResponse res) throws ServletException, IOException{
		if(session!=null){
			User u=(User) session.getAttribute("student");
			String email=u.getEmail();
		String book1=req.getParameter("book1");
		String book2=req.getParameter("book2");
		String book3=req.getParameter("book3");
		if(book1!=null){
			w.returnBook(email,"book1",book1);
		
		}
		
		else if(book2!=null){
			w.returnBook(email,"book2",book2);
		}
		else if(book3!=null){
			w.returnBook(email,"book3",book3);
		}
		else{
			req.setAttribute("msg", "No book to return");
		}	
		RequestDispatcher rd=req.getRequestDispatcher("/getDetail");
		req.setAttribute("Registration_No", u.getRegistration_No());
		rd.forward(req,res);
		return null;
		}
		else{
			req.setAttribute("msg", "you must login first");
		return "home";	
			
		}
		
		
		}
	
}
