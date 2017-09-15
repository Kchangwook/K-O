<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.page{
	width:50%;
	margin:0 auto;
}
.bbox{
	
}
</style>
</head>
<body>
<%-- 	<form action="${pageContext.request.contextPath}/MyPage.do" method="post">
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
	</form> --%>
	<jsp:include page = "../main.jsp"/>
	<header class="masthead bbox">
<form class="w3-container w3-card-4 w3-light-grey w3-text-blue page" method="post"  action="${pageContext.request.contextPath}/MyPage.do">
<h2 class="w3-center">회원정보 수정</h2>
 
<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
    	<input class="w3-input w3-border" name="id" type="text" value="${requestScope.member.id}" disabled="disabled">
      	<input type="hidden" value="${requestScope.member.id}" name="id">
      
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="password" type="password" value="${requestScope.member.password}" >
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="name" type="text" value="${requestScope.member.name}" >
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="email" type="text" value="${requestScope.member.email}" >
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="phone" type="text" value="${requestScope.member.phone}" >
    </div>
</div>

<p class="w3-center">
	<button class="w3-button w3-section w3-blue w3-ripple" onclick="location.href='${pageContext.request.contextPath}/MyPage.do?command=update'" > Send </button>
	<input type="hidden" value="update" name="command">
</p>
</form>
</header>
</body>
</html>