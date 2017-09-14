<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/MyPage.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" value="${requestScope.member.id}" disabled="disabled"> </td>
				<td><input type="hidden" value="${requestScope.member.id}" name="id"> </td>
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="text" value="${requestScope.member.password}" name="password"> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" value="${requestScope.member.name}" name="name"> </td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" value="${requestScope.member.email}" name="email"> </td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" value="${requestScope.member.phone}" name="phone"> </td>
			</tr>
		</table>
		
			<input type="hidden" value="update" name="command">
			<input type="submit" value="수정">
			<input type="reset" value="취소">
	</form>
</body>
</html>