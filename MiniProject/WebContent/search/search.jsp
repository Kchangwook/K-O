<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http//www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#list{
	color:white;
}
table, tr, td {
	background-color:#18bc9c;
	color:white;
}

.button {
    background-color: #18bc9c; /* Green */
    border-color:white;
    border-width:1px;
    border-style:solid;
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

.button:hover{
	background-color: white; /* Green */
    border-color:white;
    border-width:1px;
    border-style:solid;
    color: #18bc9c;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<jsp:include page = "../main.jsp"/>
	<header class="masthead">
	<div class="w3-container" >
		<table class="w3-table-all w3-hoverable">
			<tr class="w3-pale-green">
				<td>강좌 번호</td>
				<td>강좌 이름</td>
				<td>강사</td>
				<td>강좌 시작 일자</td>
				<td>강좌 종료 일자</td>
				<td>강좌 시작 시간</td>
				<td>강좌 종료 시간</td>
				<td>상세 보기</td>
			</tr>
			<c:forEach begin="1" end="10" var="a" varStatus="cnt" step="1">
			<c:if test = "${not empty requestScope.list[a-1].lectureName }">
				<tr>
					<td>${requestScope.list[a-1].lectureNum}</td>
					<td>${requestScope.list[a-1].lectureName}</td>
					<td>${requestScope.list[a-1].lectureTeacher}</td>
					<td>${requestScope.list[a-1].lectureStartDate}</td>
					<td>${requestScope.list[a-1].lectureEndDate}</td>
					<td>${requestScope.list[a-1].lectureStartTime}</td>
					<td>${requestScope.list[a-1].lectureEndTime}</td>
					<td><button class = "button button1" onclick="location.href='Search.do?command=searchDetail&lectureNum=${requestScope.list[a-1].lectureNum}'">상세
							보기</button></td>
				</tr>
			</c:if>
			</c:forEach>
		</table>
	</div><br><br>
	<div align="center">
		<c:if test="${requestScope.cnt > 0}">
			<c:set var="pageBlock" value="${5}" />
			<fmt:parseNumber var="pageCount"
				value="${requestScope.cnt/requestScope.boardSize+(requestScope.cnt%requestScope.boardSize==0 ? 0:1)}"
				integerOnly="true" />
			<fmt:parseNumber var="result"
				value="${(requestScope.currentPage-1)/pageBlock}" integerOnly="true" />

			<c:set var="startPage" value="${result*pageBlock+1}" />
			<c:set var="endPage" value="${startPage+pageBlock-1}" />
		</c:if>

		<!-- 마지막페이지가 출력되는 페이지보다 크면 마지막페이지를 출력되는 페이지로 바꿔줌 -->
		<c:if test="${endPage > pageCount }">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > pageBlock }">
			<a id = "list"
				href="${pageContext.request.contextPath}/Search.do?command=searchAll&pageNumber=${startPage-1}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a id = "list"
				href="${pageContext.request.contextPath}/Search.do?command=searchAll&pageNumber=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a id = "list"
				href="${pageContext.request.contextPath}/Search.do?command=searchAll&pageNumber=${startPage+pageBlock}">[다음]</a>
		</c:if>
	</div>
	</header>

</body>
</html>