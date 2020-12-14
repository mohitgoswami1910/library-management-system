package com.libra.services;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.libra.model.Book;
import com.libra.model.User;

public interface bookServices {

	User getDetail(User u,HttpServletRequest req);

	List<Book> bookList();

	int addBook(HttpSession s, Book b);

	void returnBook(String email, String Action, String book1);

}
