package com.libra.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.libra.model.User;

public interface adminDao {

	int login(User u);

	ArrayList<User> fetchData();

	void adminChangePassword(String mail, HttpServletRequest req);

	void resetPassword(String email, String password);

	int verifyEmail(String email);

}
