<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
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
					<c:forEach items="${boardList }" var="boardDto" varStatus="loop">
						<tr>
							<td>${boardDto.no }</td>
							<td>${boardDto.name }</td>
							<td class="space${boardDto.reStep }">
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
						<c:if test="${startPage != 1 }">
							<li><a href="BoardSearchList.do?clickPage=${startPage - pageBlock }"><span class="material-icons"> chevron_left </span></a></li>
						</c:if>
						
						<c:forEach var="page" begin="${startPage }" end="${endPage }">
							<li class="${clickPage == page ? 'active' : '' }"><a href="BoardSearchList.do?search_select=${param.search_select}&search_word=${param.search_word}&clickPage=${page }">${page }</a></li>
						</c:forEach>
						
						<c:if test="${endPage != lastPage }">
							<li><a href="BoardSearchList.do.do?clickPage=${startPage + pageBlock }"><span class="material-icons"> chevron_right </span></a></li>
						</c:if>
					</ul>
				</div>
				<form action="BoardSearchList.do" class="form" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="subject" ${param.search_select=="subject"?"selected":"" }>??????</option>
							<option value="name" ${param.search_select=="name"?"selected":"" }>?????????</option>
							<option value="contents" ${param.search_select=="contents"?"selected":"" }>??????</option>
						</select> 
						<input type="text" placeholder="????????? ????????? ???????????????." name="search_word" value="${param.search_word }">
						<button class="btn btnBlack">??????</button>
					</div>
				</form>
				<div class="btns">
					<a href="Write.do" class="btn btnconfirm">?????????</a>
					<a href="BoardList.do" class="btn btnconfirm">??????</a>
				</div>
			</div>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>