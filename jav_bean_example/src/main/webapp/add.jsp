<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	border: 1px solid green;
	width: 240px;
	height: auto;
	margin: 0 auto;
}

form {
	padding: 30px;
}

.heading {
	text-align: center;
	color: blue;
}
</style>
</head>
<body>

	<%@ include file="header.html"%>
	<div>
		<c:out value="${bookToEdit}" />
	</div>
	<div>
		<p style="color: green">
			<c:out value="${message}" />
		</p>
	</div>
	<c:if test="${empty bookToEdit}">
	<div>
		    <form action="books" method="post">
			<lable>Book Number</lable>
			<input type="text" name="bookNumber"/></br>
			<lable>Book Name</lable>
			<input type="text" name="bookName" /></br>
			<lable>Book Author Name</lable>
			<input type="text" name="authorName" /></br>
			<lable>Book Price</lable>
			<input type="text" name="price" /></br> 
			<input style="margin: 15px 70px" type="submit" value="Add" />
		</form>
	</div>
	</c:if>
	
	
	
	<c:if test="${!empty bookToEdit}">
	<h1 class="heading">Update Book Page</h1>
	<div>
		<form action="update" method="get">
			<lable>Book Number</lable>
			<input type="text" name="bookNumber"
				value="${bookToEdit.bookNumber}" readonly="readonly" /></br>
			<lable>Book Name</lable>
			<input type="text" name="bookName" value="${bookToEdit.bookName}" /></br>
			<lable>Book Author Name</lable>
			<input type="text" name="authorName" value="${bookToEdit.authorName}" /></br>
			<lable>Book Price</lable>
			<input type="text" name="price" value="${bookToEdit.price}" /></br> 
			<input style="margin: 15px 70px" type="submit" value="Update" />

		</form>
	</div>
</c:if>
	<jsp:include page="footer.jsp" />
</body>
</html>