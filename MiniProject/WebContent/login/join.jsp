<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <div>
	<form action="${pageContext.request.contextPath}/Join.do" method="post">
		아이디 입력 : <input type="text" name="id"><br>
		비번 입력 : <input type="password" name="password"><br>
		이름 입력 : <input type="text" name="name"><br>
		이메일 입력 : <input type="text" name="email"><br>
		번호 입력 : <input type="text" name="phone"><br>
		<input type="submit" value="회원가입">
	</form>
</div> --%>
<form action="${pageContext.request.contextPath}/Join.do" method="post">
      <div class="container">
        <h2 class="text-center">회원 가입</h2>
        <hr class="star-primary">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
            <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
<!--             <form name="sentMessage" id="contactForm" novalidate> -->
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>Name</label>
                  <input class="form-control" id="id" type="text" placeholder="id" required data-validation-required-message="Please enter your name." name="id">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>password</label>
                  <input class="form-control" id="id" type="password" placeholder="password" required data-validation-required-message="Please enter your name." name="password">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>Name</label>
                  <input class="form-control" id="name" type="text" placeholder="Name" required data-validation-required-message="Please enter your name." name="name">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>Email Address</label>
                  <input class="form-control" id="email" type="email" placeholder="Email Address" required data-validation-required-message="Please enter your email address." name="email">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>Phone Number</label>
                  <input class="form-control" id="phone" type="tel" placeholder="Phone Number" required data-validation-required-message="Please enter your phone number."name="phone">
                  <p class="help-block text-danger"></p>
                </div>
              </div>
              <!-- 
              <div class="control-group">
                <div class="form-group floating-label-form-group controls">
                  <label>Message</label>
                  <textarea class="form-control" id="message" rows="5" placeholder="Message" required data-validation-required-message="Please enter a message."></textarea>
                  <p class="help-block text-danger"></p>
                </div>
              </div>
               -->
              <br>
              <div id="success"></div>
              <div class="form-group">
                <button type="submit" class="btn btn-success btn-lg" id="sendMessageButton" onclick="${pageContext.request.contextPath}/Join.do">회원 가입</button>
              </div>
<!--             </form> -->
          </div>
        </div>
      </div>
</form>
</body>
</html>