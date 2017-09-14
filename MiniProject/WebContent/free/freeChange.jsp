<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeChange</title>
</head>
<body>
	<form action = "Free.do" method = "get">
	<table>
		<tr>
			<td>제목</td>
			<td><input type = "text" name = "title" value = "${f.freeName}"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols = "40" rows = "10" name = "content" >${f.freeContent}</textarea></td>
		</tr>
	</table>
	<input type = "hidden" name = "command" value = "update">
	<input type = "hidden" name = "id" value = "${f.id}">
	<input type = "hidden" name = "num" value = "${f.freeNum}">
	<input type = "submit" value = "수정">
	<a href = "Free.do?command=getList"><button>취소</button></a>
	</form>
</body>
</html>