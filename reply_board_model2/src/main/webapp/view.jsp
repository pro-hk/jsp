<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      			<!-- 다음글 이전글 보기 -->
      			<div class="prevAndNext">
					<div class="item">
						<span class="inner"><span class="material-icons">arrow_drop_up</span>이전글</span>
						<c:if test="${empty prevReplyBoardDto }">
						<a href="">이전글 없음</a>
						</c:if>
						<a href="View.do?no=${prevReplyBoardDto.no }&num=${prevReplyBoardDto.num }">${prevReplyBoardDto.subject }</a>
					</div>
					<div class="item">
						<span class="inner"><span class="material-icons">arrow_drop_down</span>다음글</span>
						<c:if test="${empty nextReplyBoardDto }">
						<a href="">다음글 없음</a>
						</c:if>
						<a href="View.do?no=${nextReplyBoardDto.no }&num=${nextReplyBoardDto.num }">${nextReplyBoardDto.subject }</a>
					</div>
      			</div>
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
    