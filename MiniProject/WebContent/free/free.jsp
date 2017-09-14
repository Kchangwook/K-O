<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "project.dto.Free" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>free</title>
</head>
<body>
	<table>
		<tr>
			<th>글 제목</th>
			<th>작성자</th>
		</tr>
		<c:forEach var = "free" items = "${list}">
		<tr>
			<td><a href = "Free.do?command=detail&num=${free.freeNum}">${free.freeName}</a></td>
			<td>${free.id}</td>
		</tr>
		</c:forEach>
	</table>
	<a href = "free/write.jsp"><button>글쓰기</button></a>
</body>
</html>