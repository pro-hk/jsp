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
							<td>${loop.index+1 }</td>
							<td><a href="MemberInfo.do?user_id=${memberDto.id }">${memberDto.id }</a></td>
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
			</div>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>