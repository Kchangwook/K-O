<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.dto.Present"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, tr, th , td{
	border-width: 1px;
	border-style: dashed;
	border-collapse: collapse;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Present</title>
</head>
<body>
	<table>
		<tr>
			<th>강좌 이름</th>
			<th>강사</th>
			<th>강좌 시작 일자</th>
			<th>강좌 종료 일자</th>
			<th>접수 시작 일자</th>
			<th>접수 종료 일자</th>
			<th></th>
		</tr>
		<c:forEach var="present" items="${pList }">
			<tr>
				<td>${present.lectureName }</td>
				<td>${present.lectureTeacher }</td>
				<td>${present.lectureStartDate }</td>
				<td>${present.lectureEndDate }</td>
				<td>${present.lectureReceiptStart }</td>
				<td>${present.lectureReceiptEnd }</td>
				<td>
					<a href = "Present.do?command=detail&num=${present.lectureNum}">상세 보기</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	${msg }
</body>
</html>