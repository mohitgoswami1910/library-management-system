package com.libra.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.libra.model.User;

public interface adminServices {


	int login(User u);

	ArrayList<User> fetchData();

	User studentProfile(User u, HttpServletRequest req);

	void adminChangePassword(String mail, HttpServletRequest req);

	void resetPassword(String email, String password);

	int emailVerify(String email);

}
