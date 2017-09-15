<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.dto.Present"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Present</title>
</head>
<body>
	<jsp:include page="../main.jsp" />
	<header class="masthead">
	<div class="w3-container">
		<table class="w3-table-all w3-hoverable">
			<tr id = "list">
				<th>강좌 이름</th>
				<th>강사</th>
				<th>강좌 시작 일자</th>
				<th>강좌 종료 일자</th>
				<th>접수 시작 일자</th>
				<th>접수 종료 일자</th>
				<th></th>
			</tr>
			<c:forEach var="present" items="${pList }">
				<tr id = "list">
					<td>${present.lectureName }</td>
					<td>${present.lectureTeacher }</td>
					<td>${present.lectureStartDate }</td>
					<td>${present.lectureEndDate }</td>
					<td>${present.lectureReceiptStart }</td>
					<td>${present.lectureReceiptEnd }</td>
					<td><a
						href="Present.do?command=detail&num=${present.lectureNum}">상세
							보기</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	${msg} </header>
</body>
</html>