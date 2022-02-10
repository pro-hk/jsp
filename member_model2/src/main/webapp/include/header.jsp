<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>INCLUDE</title>
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/layout.css" />
    <link rel="stylesheet" href="css/form.css" />
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="js/jquery-3.6.0.min.js"></script>  
    <script src="js/main.js" defer></script>
  </head>
  </head>
  <body>
    <header id="header">
      <div class="container">
        <h1>
        	<a href="/member_model2">prohk</a>
        </h1>
        <nav id="gnb">
          <h2 class="hidden">global navigation bar</h2>
          	<c:choose>
          		<c:when test="${empty loggedId }">
          			<ul>
            			<li><a href="Login.do">로그인</a></li>
            			<li><a href="Join.do">회원가입</a></li>
            			<li><a href="List.do">회원관리</a></li>
            			<li><a href="Board.do">게시판</a></li>
            		</ul>
          		</c:when>
          		<c:otherwise>
          			<ul>
            			<li><a href="MemberInfo.do?user_id=${loggedId }">${loggedName }님</a></li>
            			<li><a href="Logout.do">로그아웃</a></li>
            			<li><a href="List.do">회원관리</a></li>
            			<li><a href="Board.do">게시판</a></li>
            		</ul>
          		</c:otherwise>
          	</c:choose>
        </nav>
      </div>
    </header>