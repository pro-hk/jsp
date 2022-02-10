<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<%
	String user_id = request.getParameter("user_id");
%>
    <main>
      <div class="container">
      	<h2 class="subTitle">JOIN</h2>
      	<div id=contents>
      		<form method="post" action="delete_process.jsp" id="join" class="form">
      			<table style="width:500px; margin:auto">
      				<input type="hidden" name="user_id" value="<%= user_id %>">;
      				<tbody>
      					<tr>
      						<th>PASSWORD</th>
      						<td><input type="password" name="user_pw" placeholder="password"></td>
      					</tr>
      				</tbody>
      			</table>
      			<div class="btns">
    	  			<button type="submit" class="btn btnConfirm">회원탈퇴</button>
      			</div>
      		</form>
     	</div>
      </div>
    </main>
    
<%@ include file="./include/footer.jsp" %>
    