<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/Join.do" method="post">
		아이디 입력 : <input type="text" name="id"><br>
		비번 입력 : <input type="password" name="password"><br>
		이름 입력 : <input type="text" name="name"><br>
		이메일 입력 : <input type="text" name="email"><br>
		번호 입력 : <input type="text" name="phone"><br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>