<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	   
	    <!-- CSS -->
	    <link rel="stylesheet" href="./assets/css/main.css">
	    <!--menu 버튼 링크-->
	    <link rel="stylesheet" href="./assets/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
	
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	    <!--jquery 버튼 링크-->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	    <script src="./assets/js/header.js"></script>
	    <!-- 부가적인 테마 -->
	    <title>header</title>
	</head>
	<body>
		<div id="header" class="container">
        <div id="logo" class="col-xs-3">
            <img class="logo-img" src="./assets/image/logo2.jpg">
        </div>
        <div id="search" class="col-xs-4">
            <img class="logo-img-search" src="./assets/image/검색이미지.png">
        </div>
        <div id="menu" class="col-xs-2">
            <button type="button" class="btn btn-default menu">펫시터되기</button>
            <button type="button" class="btn btn-default menu"><span class="glyphicon glyphicon-envelope" aria-hidden="true" style="margin:0px;"></span><span class="badge">0</span></button>
            <button type="button" class="btn btn-default menu"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true" style="margin:0px;"></span></button>
            <div class="dropdown"><span class="lnr lnr-menu"></span>
                <ul class="dropdown-list">
                    <li><span class="lnr"></span>홈</li>
                    <li><span class="lnr"></span>펫트너되기</li>
                    <li><span class="lnr"></span>메세지</li>
                    <li><span class="lnr"></span>회원가입</li>
                    <li><span class="lnr"></span>로그아웃</li>
                    <li><span class="lnr"></span>계정</li>
                </ul>
            </div>
        </div>
    </div> 
    <div id="header_line" class="row"></div>

    <div id="wrap" class="container">
        <!-- main -->
        <div id="main" class="container-fluid">
            <div class="video-container">
                <video controlslist="nodownload" autoplay loop muted>
                    <source src="./assets/video/pexels-ron-lach-9986449.mp4" type="video/mp4">
                </video>
                <div id="main-title">
                    <p class="title-a title_a_padding-right80">Easy, Fast & Convenient</p>
                    <p class><a class="title-b">Take Care of Your</a></p>
                    <p class="title-b"><a class="title-b">Puppy.</a></p>
                    <p class="title-a">Protect Your</p>
                </div>
            </div>
        </div>
         <!-- main -->

         <!-- footer -->
        <div id="footer" class="container-fluid">
            <div class="row">
                <div class="footer col-xs-4">
                    <div class="col-xs-2">
                        <img class="footer-img" src="./assets/image/집.jpg">
                    </div>
                    <div class="footer-text  col-xs-2">
                        <p class="footer-h">House</p>
                        <p class="footer-b">To Your Door</p>
                    </div>  
                </div>
                <div class="footer col-xs-4">
                    <div class="col-xs-2">
                        <img class="footer-img" src="./assets/image/버스.jpg">
                    </div>
                    <div class="footer-text col-xs-2">
                        <p class="footer-h">Pickup</p>
                        <p class="footer-b">Check Out Location</p>
                    </div>  
                </div>
                <div class="footer col-xs-4">
                    <div class="col-xs-2">
                        <img class="footer-img" src="./assets/image/문의.jpg">
                    </div>
                    <div class="footer-text col-xs-2">
                        <p class="footer-h">Available for You</p>
                        <p class="footer-b">Online Support</p> 
                    </div>  
                </div>
                <div class="footer col-xs-4">
                    <div class="col-xs-2">
                        <img class="footer-img" src="./assets/image/메세지.jpg">
                    </div>  
                    <div class="footer-text col-xs-2">
                       <p class="footer-h">Order on the Go</p> 
                       <p class="footer-b">Download Our App</p>
                    </div>  
                </div>
            </div>
            <div class="row">
                <div class="footer-text2 col-md-1">
                    © 2022 최승은 한상선 강소희 송성빈 유다운GariBnB.com
                </div>
            </div>
        </div>


    </div>

	<!--메뉴 버튼-->
	<script src="./assets/js/menu-button.js"></script>
	</body>
</html>