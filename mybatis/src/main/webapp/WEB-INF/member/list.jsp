<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">MEMBER LIST</h2>
		<div id=contents>
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 100px">
						<col style="width: 100px">
						<col style="width: 200px">
						<col style="width: 150px">
						<col style="width: 100px">
						<col>
						<col style="width: 150px">
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>ID</th>
							<th>NAME</th>
							<th>EMAIL</th>
							<th>PHONE</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>DATE</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${memberList }" var="memberDto" varStatus="loop" >
					<fmt:parseDate value="${memberDto.regDate }" var="convertDate" pattern="yyyy-MM-dd HH:mm:ss" />
						<tr>
							<%-- <td>${loop.index + 1 + (clickPage-1)*listPerPage }</td> 오름차순 --%>
							<td>${totalPage - (clickPage-1)*listPerPage - loop.index }</td><!-- 내림차순 -->
							<td><a href="../member/MemberInfo.do?user_id=${memberDto.id }">${memberDto.id }</a></td>
							<td>${memberDto.name }</td>
							<td>${memberDto.email }</td>
							<td>${memberDto.phone }</td>
							<td>${memberDto.zipCode }</td>
							<td>${memberDto.address }</td>
							<td><fmt:formatDate value="${convertDate }" pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<ul>
						<c:if test="${startPage != 1 }">
							<li><a href="List.do?clickPage=${startPage - pageBlock }&search_select=${param.search_select}&search_word=${param.search_word}"><span class="material-icons"> chevron_left </span></a></li>
						</c:if>
						
						<c:forEach var="page" begin="${startPage }" end="${endPage }">
							<li class="${clickPage == page ? 'active' : '' }"><a href="List.do?clickPage=${page }&search_select=${param.search_select}&search_word=${param.search_word}">${page}</a></li>
						</c:forEach>
						
						<c:if test="${endPage != lastPage }">
							<li><a href="List.do?clickPage=${startPage + pageBlock }&search_select=${param.search_select}&search_word=${param.search_word}"><span class="material-icons"> chevron_right </span></a></li>
						</c:if>
					</ul>
				</div>
				<form action="List.do" class="form" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="id" ${param.search_select==id ? "selected" : "" }>아이디</option>
							<option value="name" ${param.search_select==name ? "selected" : "" }>이름</option>
						</select> 
						<input type="text" placeholder="검색할 내용을 입력하세요." name="search_word" value="${param.search_word }">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>