<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student</title>
</head>
<body>
<table>
<tr>
<th>name</th>
<th>edition</th>
<th>writer</th>
<th>publication</th>
<th>No.</th>

</tr>
<c:forEach items="${book}" var="book">
<tr>
<td>${book.bookName}</td>
<td>${book.edition}</td>
<td>${book.writer}</td>
<td>${book.publication}</td>
<td>${book.count}</td>

</tr>
</c:forEach>


</table>
</body>
</html>