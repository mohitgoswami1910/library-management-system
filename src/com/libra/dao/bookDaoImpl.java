package com.libra.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.libra.model.Book;
import com.libra.model.User;
@Repository
public class bookDaoImpl implements bookDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
@Override
	public User getDetail(User u,HttpServletRequest req) {
		final String ProcedureCall="{call Proc_App(?,?)}";
		Connection con=null;
		User student = new User();
		try{
		    con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(ProcedureCall);
			cs.setString(1,"getDetail");
			cs.setString(2,(String) req.getAttribute("Registration_No"));
			ResultSet rs=cs.executeQuery();
			
		while(rs.next()){
			String path=rs.getString("image");
			req.setAttribute("path", path);
			
			student.setFullName(rs.getString("Full_Name"));
			student.setRegistration_No(rs.getString("Registration_No"));
			student.setYear(rs.getInt("Year"));
			student.setBranch(rs.getString("Branch"));
			student.setBook1(rs.getString("book1"));
			student.setBook2(rs.getString("book2"));
			student.setBook3(rs.getString("book3"));
			student.setEmail(rs.getString("Email"));
			
	                    }
		     }
		
		catch(Exception e)
		 {
		 e.printStackTrace();
	     }
		return student;
	    }
@Override
public List<Book> bookList() {
	List<Book> bookList=new ArrayList<Book>();
	final String ProcedureCall="{call Proc_App(?)}";
	Connection con=null;
	try{
	    con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(ProcedureCall);
		cs.setString(1,"bookList");
		ResultSet rs=cs.executeQuery();
	
	while(rs.next()){
		Book book = new Book();
		book.setBookName(rs.getString("name"));
		book.setEdition(rs.getString("edition"));
		book.setWriter(rs.getString("writer"));
		book.setPublication(rs.getString("publication"));
		book.setCount(rs.getString("count"));
	    bookList.add(book);
	  
		
		}
	}
	catch(Exception e){
		e.printStackTrace();
		
	}

	
	return bookList;
}
@Override
public int addBook(HttpSession s,Book b) {
	int x = 0;
	int flag=0;
	final String ProcedureCall="{call Proc_App(?,?)}";
	Connection con=null;
	try{
		User st=(User) s.getAttribute("student");
	    con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(ProcedureCall);
		cs.setString(1,"checking");
		cs.setString(2,b.getBookName());
	ResultSet rs=cs.executeQuery();
		if(rs.next()){
			
		try{	
			Connection con1=null;
		    final String ProcedureCall1="{call Proc_App(?,?)}";
			con1=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs0=con1.prepareCall(ProcedureCall1);
			cs0.setString(1,"checking1");
			cs0.setString(2,st.getRegistration_No());
			ResultSet rs1=cs0.executeQuery();
		 try{
				Connection con2=null;
			    con2=jdbcTemplate.getDataSource().getConnection();
				final String ProcedureCall2="{call Proc_App(?,?,?)}";
				CallableStatement cs1=con2.prepareCall(ProcedureCall2);
			if( rs1.next()){
                       if(rs1.getString("book1")==null){
			                	  
				                 cs1.setString(1,"addBook1");
				                }
		                       	else{
				
			                    	if(rs1.getString("book2")==null){
					              cs1.setString(1,"addBook2");
				                   }
				                   else{
				                	   if(rs1.getString("book3")==null){
					              cs1.setString(1,"addBook3");}
				                	  
				                       }
				                       }
		
			cs1.setString(2,b.getBookName());
			cs1.setString(3,st.getRegistration_No());
			try
			{
				
				x=cs1.executeUpdate();
			}
			catch(Exception e){
				flag=2;	}
			if(x==1){
			int count=rs.getInt("count");
			count--;
			cs1.setString(1,"counter");
			cs1.setInt(2,count);
			cs1.setString(3,rs.getString("name") );
			cs1.execute();
			}	
			}
			else{
				flag=3;
			}	
		 }
		
			catch(Exception e){
				e.printStackTrace();	}
			
		}
			catch(Exception e){
				e.printStackTrace();}
			}
		else{
			flag=1;
		}	
	}
		catch(Exception e){
			e.printStackTrace();
			 }  
	return flag;
	
	}
@Override
public void returnBook(String email, String action, String bookName) {
	final String ProcedureCall="{call Proc_App(?,?,?)}";
	Connection con=null;
	ResultSet rs=null;
	try{
	    con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(ProcedureCall);
		cs.setString(1,action);
		cs.setString(2,email);
		cs.setString(3,bookName);
		rs=cs.executeQuery();
		
	
         }
	 catch(Exception e)
	           {
	               e.printStackTrace();
                } 
	final String ProcedureCall1="{call Proc_App(?,?,?)}";
	try {
		
		 con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(ProcedureCall1);
		if(rs.next()){
			int count=rs.getInt("count");
			count++;
			cs.setString(1,"counter");
			cs.setInt(2,count);
			cs.setString(3,bookName);
			cs.execute();
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
}
