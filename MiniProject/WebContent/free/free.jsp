<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.dto.Free"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>free</title>
<style>

#list {
	background-color: #18bc9c;
	color: white;
}

tr, td {
	background-color: #18bc9c;
	color: white;
}

.button {
	background-color: #18bc9c; /* Green */
	border-color: white;
	border-width: 1px;
	border-style: solid;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
}

.button:hover {
	background-color: white; /* Green */
	border-color: white;
	border-width: 1px;
	border-style: solid;
	color: #18bc9c;
}
</style>
</head>
<body style = "background-color: #18bc9c;">
	<jsp:include page="../main.jsp" />
	<header class="masthead">
	<div class="w3-container">
		<table class="w3-table-all w3-hoverable">
			<tr id = "list">
				<th>글 제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="free" items="${list}">
				<tr id = "list">
					<td><a id = "list" href="Free.do?command=detail&num=${free.freeNum}">${free.freeName}</a></td>
					<td>${free.id}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="free/write.jsp"><button class = "button">글쓰기</button></a>
	</div>
	</header>
</body>
</html>