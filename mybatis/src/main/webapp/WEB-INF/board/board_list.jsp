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
						<col style="width: 150px">
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
								<a href="View.do?no=${boardDto.no }&num=${boardDto.num }">${boardDto.subject }</a>
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
						${page }
					</ul>
				</div>
<!-- 			<form action="BoardSearchList.do" class="form" method="get"> -->
				<form action="BoardList.do" class="form" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="subject" ${param.search_select==subject ? "selected" : "" }>제목</option>
							<option value="name" ${param.search_select==name ? "selected" : "" }>작성자</option>
							<option value="contents" ${param.search_select==contents ? "selected" : "" }>내용</option>
						</select> 
						<input type="text" placeholder="검색할 내용을 입력하세요." name="search_word" value="${param.search_word }">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
				<div class="btns">
					<%-- <c:if test="${not empty loggedMember }"> --%>
					<a href="Write.do" class="btn btnconfirm">글쓰기</a>
					<%-- </c:if> --%>
				</div>
			</div>
		</div>
	</div>
</main>
<script>
	$(".btnConfirm").on("click",function(){
		if(${empty loggedMember}){
			alert("로그인해야 글을 작성할 수 있습니다.");
			location.href="../member/Login.do";
			return false;
		}
	})
</script>
<%@ include file="../include/footer.jsp"%>