<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show book</title>
<style type="text/css">

table,th,td{
  border:1px solid black; 
  border-collapse:collapse;
}

th,td{
padding:5px ;
}

th{
background-color:yellow;
}

</style>
</head>

<body>
<%@ include file="header.html" %>
<!--<c:out value="${books}" /> -->
<%--<jsp:useBean id="service" class="com.training.services.BookService" scope="request" /> --%>

<table >

	<tr >
		<th>Book number</th>
		<th>Book Name</th>
		<th>Author Name</th>
		<th >Price</th>
	</tr>
	
	

<%--<c:set var="books" value="${service.findAll()}" />--%>

<c:forEach items="${books}" var="eachBook">
<tr>

	<td ><c:out value="${eachBook.bookNumber}" /></td>
	<td ><c:out value="${eachBook.bookName}" /></td>
	<td ><c:out value="${eachBook.authorName}" /></td>
	<td ><c:out value="${eachBook.price}" /></td>
	
	
	<td><a href="edit?id=<c:out value='${eachBook.bookNumber}' />">Edit</a></td>
	<td><a href="delete?id=<c:out value='${eachBook.bookNumber}' />">Delete</a></td>

</tr>
</c:forEach>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>