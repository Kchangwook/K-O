<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="project.dto.Present"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Present</title>
</head>
<body>
	<table style = "border-width:1px;border-style:dashed;border-collapse:collapse;">
		<tr>
			<th>강좌 이름</th>
			<th>강사</th>
			<th>강좌 시작 일자</th>
			<th>강좌 종료 일자</th>
			<th>접수 시작 일자</th>
			<th>접수 종료 일자</th>
		</tr>
		<c:forEach var="present" items="${pList }">
	${present }<br>
		</c:forEach>
	</table>
</body>
</html>