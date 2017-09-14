<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${sessionScope.id}님 안녕하세요
	<a href="${pageContext.request.contextPath}/mypage/mypage.jsp">mypage</a>
	<a href="${pageContext.request.contextPath}/SearchAll.do">전체 목록</a>
	<a href="${pageContext.request.contextPath}/Present.do?command=getList">수강 신청 목록</a>
	<a href="${pageContext.request.contextPath}/faq/faq.jsp">FAQ</a>
	<a href="${pageContext.request.contextPath}/free/free.jsp">자유 게시판</a>
</body>
</html>