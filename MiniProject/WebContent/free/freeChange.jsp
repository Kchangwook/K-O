<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeChange</title>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<jsp:include page="../main.jsp" />
	<header class="masthead">
	<div class="w3-container">

		<form action="Free.do" method="get">
			<table class="w3-table-all w3-hoverable">
				<tr id = "list">
					<td>제목</td>
					<td><input type="text" name="title" value="${f.freeName}"></td>
				</tr>
				<tr id = "list">
					<td>내용</td>
					<td><textarea cols="40" rows="10" name="content">${f.freeContent}</textarea></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="command" value="update"> <input
				type="hidden" name="id" value="${f.id}"> <input
				type="hidden" name="num" value="${f.freeNum}"> <input class = "button"
				type="submit" value="수정"> <a href="Free.do?command=getList"><button class = "button">취소</button></a>
		</form>
	</div>
	</header>
</body>
</html>