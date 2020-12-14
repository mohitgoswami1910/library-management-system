<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.libra.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 class="heading">${msg}</h1> 
<%  HttpSession s=request.getSession(false); 
 User student=(User)s.getAttribute("student");
//String s2=student.getImage();
%>
<h2>Name=${student.fullName}</h2>
<h2>Registratin_no=${student.fullName}</h2>
<h2>Year=${student.year}</h2>
<h2>Branch=${student.branch}</h2>
<h2>book1=${student.book1}</h2>
<form action="returnBook">
<input name="book1" type="hidden" value="${student.book1}"><br>
<button type="submit">return</button><br>
	</form>
<h2>book2=${student.image}</h2>
<form action="returnBook">
<input name="book2" type="hidden" value="${student.book2}"  ><br>
<button type="submit">return</button><br>
	</form>
<h2>book3=${student.book3}</h2>
<form action="returnBook">
<input name="book3" type="hidden" value="${student.book3}"><br>
<button type="submit">return</button><br>
	</form>
<img src="${path}" 

>

<form action="addBook">
<input name="bookName" type="text" placeholder="enter book Name" ><br>
<button type="submit">issue a Book</button><br>
	</form>



<form action="logout">
<button  type="submit">logout</button>
</form>
</body>
</html>