package com.libra.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libra.dao.bookDao;
import com.libra.model.Book;
import com.libra.model.User;
@Service
public class bookServicesimpl implements bookServices {
@Autowired 
bookDao w;
	@Override
	public User getDetail(User u,HttpServletRequest req) {
		return w.getDetail(u,req);
		
	}
	@Override
	public List<Book> bookList() {
	return w.bookList();
		
	}
	@Override
	public int addBook(HttpSession s,Book b) {
		return w.addBook(s,b);
	}
	@Override
	public void returnBook(String email, String Action, String book1) {
		w.returnBook(email,Action,book1);
		
	}

}