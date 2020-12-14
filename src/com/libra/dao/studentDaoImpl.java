
package com.libra.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.libra.model.User;
@Repository
public class studentDaoImpl implements studentDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int addStudent(User u) {
		int flag=0;
		
		final String procedureCall="{call Proc_App(?,?)}";
		Connection con=null;
		try{
		
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"studentLogin");
			cs.setString(2,u.getEmail());
			ResultSet rs=cs.executeQuery();
			if(rs.next()){
				flag=1;          }
			else{
				try{
					String imagePath=uploadFileOnServer(u);
				final String procedureCall1="{call Proc_App(?,?,?,?,?,?,?,?,?)}";
				Connection con1=null;
				con1=jdbcTemplate.getDataSource().getConnection();
				CallableStatement cs1=con1.prepareCall(procedureCall1);
		    cs1.setString(1,"addStudent");
			cs1.setString(2,u.getFullName());
			cs1.setString(3,u.getRegistration_No());	
		    cs1.setInt(4,u.getYear());	
			cs1.setString(5,u.getFacultyNo());
			cs1.setString(6,u.getEmail());
			cs1.setString(7,u.getPassword());
			cs1.setString(8,u.getBranch());
			cs1.setString(9,imagePath);
			System.out.println(u.getRegistration_No());
			cs1.execute();
			
			flag=2;
				}
			
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return flag;
				
	}
	private String uploadFileOnServer(User u) {
	String rootdirectory="C:/workspace/managment/WebContent/UserImages";
	String imagepath = null;
	String imagepath2 = null;
	File directory= new File(rootdirectory);
	if(!directory.exists())
		directory.mkdirs();
	MultipartFile filedata=u.getImage();
	String filename=filedata.getOriginalFilename();
	if(filename!=null && filename.length()>0)
	{
		try {
			
		imagepath=directory.getCanonicalPath() + File.separator+filename;
		imagepath2="UserImages" + File.separator+filename;
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(imagepath));
		bos.write(filedata.getBytes());
		bos.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	return imagepath2;}
	
	@Override
	public int studentLogin(User u) {
int flag=0;

		
		final String procedureCall="{call Proc_App(?,?)}";
		Connection con=null;
		try{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"studentLogin");
			cs.setString(2,u.getEmail());	
			ResultSet rs=cs.executeQuery();
			if(rs.next()){
              
				if(rs.getString("password").equals(u.getPassword())){
					flag=1;
				}
				else{
					flag=2;
				}
				
			}
			else{
				flag=0;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
	
	}
		return flag;
	
	}
	@Override
	public User studentProfile(User u,HttpServletRequest req) {
		User ux=new User();

		final String procedureCall="{call Proc_App(?,?)}";
		Connection con=null;
			try{
				con=jdbcTemplate.getDataSource().getConnection();
			   CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"studentLogin");	
			cs.setString(2,u.getEmail());	
			ResultSet rs=cs.executeQuery();
			while(rs.next()){
				String path=rs.getString("image");
				//File f=new File(path);
				//FileInputStream input = new FileInputStream(f);
				//MultipartFile multipartFile = new MockMultipartFile("f",
			           // f.getName(), "image/jpeg", IOUtils.toByteArray(input));
			HttpSession session=req.getSession(false);
			try{session.setAttribute("path", path);
		    }
				catch(Exception e){
					e.printStackTrace();
		}
				ux.setBranch(rs.getString("branch"));
				ux.setEmail(rs.getString("email"));
				ux.setFullName(rs.getString("Full_Name"));
				ux.setBook1(rs.getString("book1"));
				ux.setBook2(rs.getString("book2"));
				ux.setBook3(rs.getString("book3"));
				ux.setYear(rs.getInt("Year"));
				ux.setPassword(rs.getString("password"));
				ux.setRegistration_No(rs.getString("Registration_No"));
			//ux.setImage(multipartFile);
				 return ux;
			}
			}
           catch(Exception e){
        		e.printStackTrace();
        		
}
			return ux;
}
	@Override
	public void changePassword(HttpServletRequest req, User ux) {
	

		
		final String procedureCall="{call Proc_App(?,?,?)}";
		Connection con=null;
		try{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"changePassword");
			cs.setString(2,ux.getRegistration_No());
			cs.setString(3,req.getParameter("newPassword"));
		    cs.executeUpdate();
			
	}
		catch(Exception e){
			e.printStackTrace();}
		}
	@Override
	public void resetPassword(String email, String password) {

		
		final String procedureCall="{call Proc_App(?,?,?)}";
		Connection con=null;
		try{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"resetPassword");
			cs.setString(2,email);
			cs.setString(3,password);
		    cs.executeUpdate();
			
	}
		catch(Exception e){
			e.printStackTrace();}
		
	}
	@Override
	public int verifyEmail(String email) {
		int flag=0;
		final String procedureCall="{call Proc_App(?,?)}";
		Connection con=null;
		try{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"verifyEmail");
			cs.setString(2,email);
		    ResultSet rs=cs.executeQuery();
		    if(rs.next())
		    flag=1;
		    
			
	}
		catch(Exception e){
			e.printStackTrace();}
		
		return flag;
	}
	}


