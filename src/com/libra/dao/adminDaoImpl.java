package com.libra.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.libra.model.User;
@Repository
public class adminDaoImpl implements adminDao{
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Override
	public int login(User u) {
		int flag = 0;
		
		
		final String ProcedureCall="{call Proc_App(?,?)}";
		Connection con=null;
		try{
		con=jdbcTemplate.getDataSource().getConnection();
		CallableStatement cs=con.prepareCall(ProcedureCall);
		cs.setString(1,"adminLogin");
		cs.setString(2,u.getEmail());
		ResultSet rs=cs.executeQuery();
		if(rs.next()){
			
			if(rs.getString("password").equals(u.getPassword())){
			flag=1;
			}
			else{
				flag=2;
			}}
			else{
				flag=3;
			}}
			catch(Exception e){
				
				e.printStackTrace();
			}
		return flag;	
		}
	@Override
	public ArrayList<User> fetchData() {
		ArrayList<User> s=new ArrayList<User>();
		final String ProcedureCall="{call Proc_App(?)}";
		Connection con=null;
		try{
		    con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(ProcedureCall);
			cs.setString(1,"fetchData");
			ResultSet rs=cs.executeQuery();
		
		while(rs.next()){
			User student = new User();
			student.setFullName(rs.getString("Full_Name"));
			student.setRegistration_No(rs.getString("Registration_No"));
			student.setYear(rs.getInt("Year"));
			student.setFacultyNo(rs.getString("Faculty_No"));
			student.setEmail(rs.getString("Email"));
			student.setPassword(rs.getString("Password"));
			student.setBranch(rs.getString("Branch"));
			s.add(student);
			
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}

		
	return s;}
	@Override
	public void adminChangePassword(String email, HttpServletRequest req) {

		
		final String procedureCall="{call Proc_App(?,?,?)}";
		Connection con=null;
		try{
			con=jdbcTemplate.getDataSource().getConnection();
			CallableStatement cs=con.prepareCall(procedureCall);
			cs.setString(1,"adminChangePassword");
			cs.setString(2,email);
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
			cs.setString(1,"adminResetPassword");
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
			cs.setString(1,"adminVerifyEmail");
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
			
