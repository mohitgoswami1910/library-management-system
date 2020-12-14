package com.libra.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private MultipartFile image;
private String fullName;
private String Registration_No;
private String facultyNo;
private int year;
private String password;
private String branch; 
private String email;
private String book1;
private String book2;
private String book3;
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}



public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

public String getFacultyNo() {
	return facultyNo;
}
public void setFacultyNo(String facultyNo) {
	this.facultyNo = facultyNo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBook1() {
	return book1;
}
public void setBook1(String book1) {
	this.book1 = book1;
}
public String getBook2() {
	return book2;
}
public void setBook2(String book2) {
	this.book2 = book2;
}
public String getBook3() {
	return book3;
}
public void setBook3(String book3) {
	this.book3 = book3;
}
public String getRegistration_No() {
	return Registration_No;
}
public void setRegistration_No(String registration_No) {
	Registration_No = registration_No;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}

}