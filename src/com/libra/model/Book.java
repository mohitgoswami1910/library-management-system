package com.libra.model;

public class Book {
private String bookName;
private String edition;
private String writer;
private String publication;
private String count;

public String getEdition() {
	return edition;
}
public void setEdition(String edition) {
	this.edition = edition;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public String getPublication() {
	return publication;
}
public void setPublication(String publication) {
	this.publication = publication;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}

public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
}
