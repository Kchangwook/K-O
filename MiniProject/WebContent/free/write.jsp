<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write</title>
	 <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/freelancer.css" rel="stylesheet">
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
	<jsp:include page = "../main.jsp"/>
	<header class="masthead">
	<div class="w3-container">
		<form action="../Free.do" method="get">
			<table class="w3-table-all w3-hoverable">
				<tr id = "list">
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr id = "list">
					<td>작성자</td>
					<td>${id }</td>
				</tr>
				<tr id = "list">
					<td>내용</td>
					<td><textarea cols="40" rows="10" name="content"></textarea></td>
				</tr>
			</table>
			<br>
			<input class = "button" type="hidden" name="command" value="write"> <input class = "button"
				type="submit" value="글쓰기"> <input class = "button" type="reset" value="취소">
			<a href="../Free.do?command=getList"><button class = "button">목록으로</button></a>
		</form>
	</div>
	</header>
</body>
</html>