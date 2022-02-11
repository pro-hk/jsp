<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="./include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">BORAD LIST</h2>
		<div id=contents>
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 100px">
						<col>
						<col style="width: 200px">
						<col style="width: 200px">
						<col style="width: 50px">
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>NAME</th>
							<th>SUBJECT</th>
							<th>EMAIL</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${boardList }" var="boardDto" varStatus="loop" begin="0" end="${totalPage }">
						<tr>
							<%-- <td>${boardDto.no }</td> --%>
							<td>${totalPage - (clickPage-1)*listPerPage - loop.index }</td>
							<td>${boardDto.name }</td>
							<td class="space${boardDto.reStep } left">
								<c:if test="${boardDto.reStep > 1 }">
								<span class="material-icons">subdirectory_arrow_right</span>
								</c:if>
								<a href="View.do?no=${boardDto.no }">${boardDto.subject }</a>
							</td>
							<td>${boardDto.email }</td>
							<td>${boardDto.regDate }</td>
							<td>${boardDto.hit }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<ul>
						<!-- <li><a href="BoardList.do?start=1&end=5">1</a></li>
						<li><a href="BoardList.do?start=6&end=10">2</a></li>
						<li><a href="BoardList.do?start=11&end=15">3</a></li>
						<li><a href="BoardList.do?start=16&end=20">4</a></li> -->
						<c:if test="${startPage != 1 }">
							<li><a href="BoardList.do?clickPage=${startPage - pageBlock }"><span class="material-icons"> chevron_left </span></a></li>
						</c:if>
						
						<c:forEach var="page" begin="${startPage }" end="${endPage }">
							<li class="${clickPage == page ? 'active' : '' }"><a href="BoardList.do?clickPage=${page }">${page }</a></li>
						</c:forEach>
						
						<c:if test="${endPage != lastPage }">
							<li><a href="BoardList.do?clickPage=${startPage + pageBlock }"><span class="material-icons"> chevron_right </span></a></li>
						</c:if>
					</ul>
				</div>
				<form action="boardSearchList.do" class="form" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="subject" selected>제목</option>
							<option value="name">작성자</option>
							<option value="contents">내용</option>
						</select> 
						<input type="text" placeholder="검색할 내용을 입력하세요." name="search_word">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
				<div class="btns">
					<a href="Write.do" class="btn btnconfirm">글쓰기</a>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="./include/footer.jsp"%>