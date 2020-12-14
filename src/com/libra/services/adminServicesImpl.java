package com.libra.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libra.dao.adminDao;
import com.libra.model.User;
@Service
public class adminServicesImpl implements adminServices{
@Autowired
adminDao w;
	@Override
	public int login(User u) {
		
return w.login(u);
	}
	@Override
	public ArrayList<User> fetchData() {
		return w.fetchData();
	}
	@Override
	public User studentProfile(User u, HttpServletRequest req) {
		
		return null;
	}
	@Override
	public void adminChangePassword(String mail, HttpServletRequest req) {
		w.adminChangePassword(mail,req);
	}
	@Override
	public void resetPassword(String email, String password) {
		w.resetPassword(email, password);
		
	}
	@Override
	public int emailVerify(String email) {
		
		return w.verifyEmail(email);
	}
}
