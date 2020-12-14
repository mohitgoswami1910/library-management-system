package com.libra.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libra.dao.studentDao;
import com.libra.model.User;

@Service
public class studentServicesImpl implements studentServices {
@Autowired
studentDao w;

@Override
public int addStudent(User u) {
	// TODO Auto-generated method stub
	return w.addStudent(u);
}
@Override
public int studentLogin(User u) {

	return w.studentLogin(u);
}

@Override
public User studentProfile(User u,HttpServletRequest req){
return	w.studentProfile(u,req );
	
}
@Override
public void changePassword(HttpServletRequest req, User ux) {
	// TODO Auto-generated method stub
	w.changePassword(req,ux);
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
