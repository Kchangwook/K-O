<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FreeDetail</title>
</head>
<body>
	<table>
		<tr>
			<td>제목</td>
			<td>${f.freeName }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${f.id }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><pre>${f.freeContent }</pre></td>
		</tr>
	</table>
	<a href = "Free.do?command=detail&num=${f.freeNum}&change=-1"><button>수정</button></a>
	<a href = "Free.do?command=getList"><button>목록으로</button></a>
</body>
</html>