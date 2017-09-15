<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.cnt/50}<Br>
${requestScope.list[0].lectureNum }
<%-- 	<c:if test="${requestScope.cnt/50}"> --%>
		
<%-- 	</c:if> --%>
	
	<table>
		<tr>
			<td>강좌 번호</td>
			<td>강좌 이름</td>
			<td>강사</td>
			<td>강좌 시작 일자</td>
			<td>강좌 종료 일자</td>
			<td>강좌 시작 시간</td>
			<td>강좌 종료 시간</td>
		</tr>
		<c:forEach begin="1" end="10" var="a" varStatus="cnt" step="1">
			<tr>
 				<td>${requestScope.list[a-1].lectureNum}</td>
				<td>${requestScope.list[a-1].lectureName}</td>
				<td>${requestScope.list[a-1].lectureTeacher}</td>
				<td>${requestScope.list[a-1].lectureStartDate}</td>
				<td>${requestScope.list[a-1].lectureEndDate}</td>
				<td>${requestScope.list[a-1].lectureStartTime}</td>
				<td>${requestScope.list[a-1].lectureEndTime}</td>
				<td><button onclick="location.href='Search.do?command=searchDetail&lectureNum=${requestScope.list[a-1].lectureNum}'" >상세 보기</button> </td>
			</tr>
		</c:forEach>
	</table>
		<c:forEach begin="0" end="${requestScope.cnt}" var = "cnt">
			<c:choose>
				<c:when test="${cnt/10 == 1}">
					<a href="${pageContext.request.contextPath}/Search.do?command=searchAll&start=1&end=10">1</a>
				</c:when>
				<c:when test="${cnt/10 == 2}">
					<a href="${pageContext.request.contextPath}/Search.do?command=searchAll&start=11&end=20">2</a>
				</c:when>
			</c:choose>
		</c:forEach>
		${requestScope.msg}
</body>
</html>