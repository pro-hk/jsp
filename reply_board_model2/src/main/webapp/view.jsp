<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./include/header.jsp" %>
    <main>
      <div class="inner">
      	<h2 class="subTitle">VIEW</h2>
      	<div id=contents>
      		<div class="form">
      			<table>
      				<colgroup>
      					<col style="width:10%">
      					<col style="width:40%">
      					<col style="width:10%">
      					<col style="width:40%">
      				</colgroup>
      				<tbody>
      					<tr>
      						<th>이름</th>
      						<td class="left">${replyBoardDto.name }</td>
      						<th>HIT</th>
      						<td class="left">${replyBoardDto.hit }</td>
      					</tr>
      					<tr>
      						<th>이메일</th>
      						<td class="left">${replyBoardDto.email }</td>
      						<th>작성일</th>
      						<td class="left">${replyBoardDto.regDate }</td>
      					</tr>
      					<tr>
      						<th>제목</th>
      						<td colspan="3" class="left">${replyBoardDto.subject }</td>
      					</tr>
      					<tr>
      						<th>내용</th>
      						<td colspan="3" class="left">${replyBoardDto.contents }<br></td>
      					</tr>
      				</tbody>
      			</table>
      			<div class="btns">
      				<a href="BoardList.do" class="btn btnConfirm">글목록</a>
      				<a href="Write.do"  class="btn btnConfirm">글쓰기</a>
      				<a href="ReplyWrite.do?no=${replyBoardDto.no }
      				&reGroup=${replyBoardDto.reGroup }
      				&reStep=${replyBoardDto.reStep }
      				&reLevel=${replyBoardDto.reLevel }"  class="btn btnConfirm">답글쓰기</a>
      				<a href="Delete.do?no=${param.no }"  class="btn btnConfirm">삭제</a>
      				<a href="Update.do?no=${param.no }"  class="btn btnConfirm">수정</a>
      			</div>
      		</div>
     	</div>
      </div>
    </main>
<%@ include file="./include/footer.jsp" %>
    