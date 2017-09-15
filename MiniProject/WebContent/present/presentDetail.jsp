<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.dto.Lecture"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>presentDetail</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
<body>
<jsp:include page="../main.jsp" />
	<header class="masthead">
<div class="w3-container">
	<table class="w3-table-all w3-hoverable">
		<tr>
			<td>강좌 이름:</td>
			<td>${lecture.lectureName }</td>
		</tr>
		<tr>
			<td>강사:</td>
			<td>${lecture.lectureTeacher }</td>
		</tr>
		<tr>
			<td>강좌 시작 일자:</td>
			<td>${lecture.lectureStartDate }</td>
		</tr>
		<tr>
			<td>강좌 종료 일자:</td>
			<td>${lecture.lectureEndDate }</td>
		</tr>
		<tr>
			<td>강좌 시작 시간:</td>
			<td>${lecture.lectureStartTime }</td>
		</tr>
		<tr>
			<td>강좌 종료 시간:</td>
			<td>${lecture.lectureEndTime }</td>
		</tr>
		<tr>
			<td>강좌 내용:</td>
			<td>${lecture.lectureContent }</td>
		</tr>
		<tr>
			<td>교육 대상:</td>
			<td>${lecture.lectureStudent }</td>
		</tr>
		<tr>
			<td>강의 요일:</td>
			<td>${lecture.lectureDay }</td>
		</tr>
		<tr>
			<td>정원:</td>
			<td>${lecture.lectureMaxNum }</td>
		</tr>
		<tr>
			<td>가격:</td>
			<td>${lecture.lecturePrice }</td>
		</tr>
		<tr>
			<td>교육장 주소:</td>
			<td>${lecture.lectureAddress }</td>
		</tr>
		<tr>
			<td>주최 기관:</td>
			<td>${lecture.lectureCompany }</td>
		</tr>
		<tr>
			<td>접수 시작 기간:</td>
			<td>${lecture.lectureReceiptStart }</td>
		</tr>
		<tr>
			<td>접수 종료 기간:</td>
			<td>${lecture.lectureReceiptEnd }</td>
		</tr>
		<tr>
			<td>접수 방법:</td>
			<td>${lecture.lectureReceiptMethod }</td>
		</tr>
	</table>
	<a href = "Present.do?command=delete&num=${lecture.lectureNum}"><button>삭제</button></a>
	<a href = "Present.do?command=getList"><button>확인</button></a>
	<input type = "reset" value = "취소">
</div>
</header>
</body>
</html>