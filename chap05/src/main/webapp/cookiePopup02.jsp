<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String popup = "on";

	String oneDay = request.getParameter("oneDay");
	System.out.println(oneDay);
	if(oneDay!=null && oneDay.equals("off")) {
		Cookie cookie = new Cookie("popup","off");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
	
	Cookie cookies[] = request.getCookies();
	if(cookies!=null) {
		for(Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			out.print(cookieName+" : "+cookieValue+"<br>");
			if(cookieName.equals("popup")) {
				popup = cookieValue;
			}
		}
	};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/layout.css" />
    <script src="js/jquery-3.6.0.min.js"></script>
<body>
	<%
		if(popup.equals("on")) {
	%>
	<div id="popup">
      <div class="contents">
        <h2>Notice</h2>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
        <p>공지사항입니다.</p>
      </div>
      <div class="btns">
        <button class="btn btnOneday">오늘 하루 이 창을 열지 않기</button>
        <button class="btn btnClose">닫기</button>
      </div>
    </div>
    <%
		}    
    %>
    <script>
    	$(".btnClose").on("click",function(){
    		$("#popup").hide();    		
    	});
    	$(".btnOneday").on("click",function(){
    		$("#popup").hide();
    		$.ajax({
    			url:"./cookiePopup02.jsp",
    			type:"get",
    			data:{oneDay:"off"}
    		});
    	});
    </script>
</body>
</html>