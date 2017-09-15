<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/freelancer.css" rel="stylesheet">
</head>
<body>
	    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href = "index.jsp">MiniProject</a>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        <c:if test="${not empty sessionScope.id}">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/MyPage.do?command=mypage" class="w3-bar-item w3-button" >mypage</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Search.do?command=searchAll&start=1&end=10" class="w3-bar-item w3-button" >강좌 검색</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Present.do?command=getList" class="w3-bar-item w3-button" >수강 목록</a>
            </li>
             <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/Free.do?command=getList" class="w3-bar-item w3-button">자유 게시판</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/FAQ.do?command=getList" class="w3-bar-item w3-button">FAQ</a>
            </li>
          </ul>
          </c:if>
        </div>
      </div>
    </nav>
</body>
</html>