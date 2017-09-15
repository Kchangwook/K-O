<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<%-- <div class="w3-container w3-half w3-margin-top">
	<form action="${pageContext.request.contextPath}/Login.do" method="post"  class="w3-container w3-card-4">
		<p>
		<input class="w3-input" type="text" style="width:90%" name="id">
		<label>ID</label></p>
		<p>
		<input class="w3-input" type="password" style="width:90%" name="password">
		<label>Password</label></p>
		<input type="submit" value="로그인">
	</form>
</div>	 --%>
	${requestScope.msg}
	<c:if test="${not empty param.msg }">
		${param.msg} 
	</c:if>
<div class="w3-container" style="text-align: left;">	
	  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
  
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
        <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" action="${pageContext.request.contextPath}/Login.do" method="post">
        <div class="w3-section">
          <label style="color:black;"><b>Userid</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Userid" name="id">
          <label style="color:black;"><b>Password</b></label>
          <input class="w3-input w3-border" type="text" placeholder="Enter Password" name="password">
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red" >Cancel</button>
        <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span>
      </div>

    </div>
  </div>
</div>
	
</body>
</html>