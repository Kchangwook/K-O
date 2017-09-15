<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>mini project</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/freelancer.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">MiniProject(합습관 정보)</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
       <c:if test="${not empty sessionScope.id}">
	   <div class="w3-dropdown-click navbar-brand js-scroll-trigger">
	    	  <div class="w3-dropdown-hover">
		   <button class="w3-button"  style="font-size: 25px;">Dropdown
		     <i class="fa fa-caret-down"></i>
		   </button>
		   <div class="w3-dropdown-content w3-bar-block">
		    <a href="${pageContext.request.contextPath}/MyPage.do?command=mypage" class="w3-bar-item w3-button" style="font-size: 24px;" >mypage</a>
			<a href="${pageContext.request.contextPath}/Search.do?command=searchAll&start=1&end=10" class="w3-bar-item w3-button" style="font-size: 24px;">전체 목록</a>
			<a href="${pageContext.request.contextPath}/Present.do?command=getList" class="w3-bar-item w3-button"  style="font-size: 24px;">수강 신청 목록</a>
			<a href="${pageContext.request.contextPath}/FAQ.do?command=getList" class="w3-bar-item w3-button" style="font-size: 24px;">FAQ</a>
			<a href="${pageContext.request.contextPath}/Free.do?command=getList" class="w3-bar-item w3-button"  style="font-size: 24px;">자유 게시판</a>
		   </div>
		 </div> 
	  </div>
	  </c:if>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">Portfolio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">회원가입</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Header -->
    <header class="masthead">
      <div class="container">
        <img class="img-fluid" src="img/profile.png" alt="">
        <div class="intro-text">
          <span class="name">MiniProject - 평생학습관</span>
          <hr class="star-light">
          <span class="skills">배움으로 도약하고 나눔으로 행복한 평생 학습관</span>
        </div>
        <c:if test="${empty sessionScope.id}">
        <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large">Login</button>
        <div>
        	<jsp:include page="login/login.jsp"/>
        </div>
        </c:if>
        <c:if test="${not empty param.msg }">
        	${param.msg}
        </c:if>
      </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
      <div class="container">
        <h2 class="text-center">Portfolio</h2>
        <hr class="star-primary">
        <div class="row">
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal1" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cabin.png" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal2" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/cake.png" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal3" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/circus.png" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal4" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/game.png" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal5" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/safe.png" alt="">
            </a>
          </div>
          <div class="col-sm-4 portfolio-item">
            <a class="portfolio-link" href="#portfolioModal6" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/portfolio/submarine.png" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- About Section -->
    <section class="success" id="about">
      <div class="container">
        <h2 class="text-center">About</h2>
        <hr class="star-light">
        <div class="row">
          <div class="col-lg-4 ml-auto">
            <p>Freelancer is a free bootstrap theme created by Start Bootstrap. The download includes the complete source files including HTML, CSS, and JavaScript as well as optional LESS stylesheets for easy customization.</p>
          </div>
          <div class="col-lg-4 mr-auto">
            <p>Whether you're a student looking to showcase your work, a professional looking to attract clients, or a graphic artist looking to share your projects, this template is the perfect starting point!</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Contact Section -->
    <section id="contact"/>
    <jsp:include page="login/join.jsp" />
    

    <!-- Footer -->
    <footer class="text-center">
      <div class="footer-above">
        <div class="container">
          <div class="row">
            <div class="footer-col col-md-4">
              <h3>Location</h3>
              <p>3481 Melrose Place
                <br>Beverly Hills, CA 90210</p>
            </div>
            <div class="footer-col col-md-4">
              <h3>Around the Web</h3>
              <ul class="list-inline">
                <li class="list-inline-item">
                  <a class="btn-social btn-outline" href="#">
                    <i class="fa fa-fw fa-facebook"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a class="btn-social btn-outline" href="#">
                    <i class="fa fa-fw fa-google-plus"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a class="btn-social btn-outline" href="#">
                    <i class="fa fa-fw fa-twitter"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a class="btn-social btn-outline" href="#">
                    <i class="fa fa-fw fa-linkedin"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a class="btn-social btn-outline" href="#">
                    <i class="fa fa-fw fa-dribbble"></i>
                  </a>
                </li>
              </ul>
            </div>
            <div class="footer-col col-md-4">
              <h3>About Freelancer</h3>
              <p>Freelance is a free to use, open source Bootstrap theme created by
                <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="footer-below">
        <div class="container">
          <div class="row">
            <div class="col-lg-12">
              Copyright &copy; Your Website 2017
            </div>
          </div>
        </div>
      </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top d-lg-none">
      <a class="btn btn-primary js-scroll-trigger" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>

    <!-- Portfolio Modals -->
    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/cabin.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/cake.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/circus.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/game.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/safe.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="close-modal" data-dismiss="modal">
            <div class="lr">
              <div class="rl"></div>
            </div>
          </div>
          <div class="container">
            <div class="row">
              <div class="col-lg-8 mx-auto">
                <div class="modal-body">
                  <h2>Project Title</h2>
                  <hr class="star-primary">
                  <img class="img-fluid img-centered" src="img/portfolio/submarine.png" alt="">
                  <p>Use this area of the page to describe your project. The icon above is part of a free icon set by
                    <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can download their free set with 16 icons, or you can purchase the entire set with 146 icons for only $12!</p>
                  <ul class="list-inline item-details">
                    <li>Client:
                      <strong>
                        <a href="http://startbootstrap.com">Start Bootstrap</a>
                      </strong>
                    </li>
                    <li>Date:
                      <strong>
                        <a href="http://startbootstrap.com">April 2014</a>
                      </strong>
                    </li>
                    <li>Service:
                      <strong>
                        <a href="http://startbootstrap.com">Web Development</a>
                      </strong>
                    </li>
                  </ul>
                  <button class="btn btn-success" type="button" data-dismiss="modal">
                    <i class="fa fa-times"></i>
                    Close</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>
<script type="text/javascript">
function myDropFunc() {
    var x = document.getElementById("demoDrop");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-green";
    } else { 
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-green", "");
    }
}
</script>
  </body>

</html>