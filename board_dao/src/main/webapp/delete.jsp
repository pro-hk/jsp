<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
    <main>
      <div class="inner">
      	<h2 class="subTitle">DELETE</h2>
      	<div id=contents>
      		<form method="post" action="DeleteProcess.do" id="join" class="form">
      			<input type="hidden" name="no" value="${param.no }" >
      			<table>
      				<colgroup>
      					<col style="width:20%">
      					<col style="width:80%">
      				</colgroup>
      				<tbody>
      					<tr>
      						<th>패스워드 <span class="required">*</span></th>
      						<td>
      						<input type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요." >
      						</td>
      					</tr>
      				</tbody>
      			</table>
      			<div class="btns">
      				<button type="submit" class="btn btnConfirm">삭제</button>
      				<button type="reset" class="btn btnCancel">취소</button>
      				<a href="List.do" class="btn btnCancel">글목록</a>
      			</div>
      		</form>
     	</div>
      </div>
    </main>
<%@ include file="./include/footer.jsp" %>
    