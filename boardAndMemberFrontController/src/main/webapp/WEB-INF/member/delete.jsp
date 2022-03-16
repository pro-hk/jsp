<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
    <main>
      <div class="inner">
      	<h2 class="subTitle">회원탈퇴</h2>
      	<div id=contents>
      		<form method="post" action="DeleteProcess.do" id="join" class="form">
   				<input type="hidden" name="user_id" value="${param.user_id }">
      			<table style="width:500px; margin:auto">
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
<%@ include file="../include/footer.jsp" %>
    