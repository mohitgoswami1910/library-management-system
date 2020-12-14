package com.libra.services;

import javax.servlet.http.HttpServletRequest;

import com.libra.model.User;

public interface studentServices {

	int addStudent(User u);
	
	int studentLogin(User u);

	User studentProfile(User u,HttpServletRequest req);

	void changePassword(HttpServletRequest req, User ux);

	void resetPassword(String email, String password);

	int emailVerify(String email);
}
