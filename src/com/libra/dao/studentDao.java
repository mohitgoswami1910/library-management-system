package com.libra.dao;

import javax.servlet.http.HttpServletRequest;

import com.libra.model.User;

public interface studentDao {

	int addStudent(User u);
	int studentLogin(User u);

	User studentProfile(User u,HttpServletRequest req);
	void changePassword(HttpServletRequest req, User ux);
	void resetPassword(String email, String password);
	int verifyEmail(String email);
}
