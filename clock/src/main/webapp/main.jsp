<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HUBLOT</title>
    <link rel="shortcut icon" href="images/layout/favicon.png" type="image/x-icon">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/splitting.css">
    <link rel="stylesheet" href="css/fullpage.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/gsap/gsap.min.js"></script>
    <script src="js/gsap/CSSRulePlugin.min.js"></script>
    <script src="js/splitting.min.js"></script>
    <script src="js/fullpage.min.js"></script>
	<script src="js/main.js" defer></script>
</head>
<body>
    <header id="header">
        <h1 id="logo">
            <a href=""><img src="images/hublot02/logo.png" alt=""></a>
        </h1>
        <nav id="gnb">
            <h2 class="hidden">global navigation</h2>
            <ul class="gnbList">
                <li data-url="bigbang" class="on"><a href="">BIGBANG</a></li>
                <li data-url="classic"><a href="">CLASSIC</a></li>
                <li><a href="">BOUTIQUES</a></li>
            </ul>
        </nav>
        <div class="utilMenu">
            <a href="">HUBLOTISTA</a>
            <a href="">
                <span class="material-icons">favorite_border</span>
            </a>
            <a href="">
                <span class="material-icons">search</span>
            </a>
        </div>
    </header>
    <main id="main">
    	<c:forEach items="${clockList }" var="clockDto" varStatus="loof">
	        <div class="section" id="clock${loof.index }" style="background-image:url('upload_clock/${clockDto.clockRealImg}')">
	            <div class="info">
	                <p class="category" data-splitting>${clockDto.category }</p>
	                <p class="title" data-splitting>${clockDto.title }</p>
	                <p class="depth" data-splitting>${clockDto.depth } MM</p>
	                <p class="price" data-splitting>CHF <fmt:formatNumber value="${clockDto.price }" pattern="0,000" /></p>
	            </div>
	        </div>
    	</c:forEach>
    </main>
    
</body>
</html>