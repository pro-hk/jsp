package com.prohk.util;

public class PageWriter {
	// total : 전체 페이지 갯수 & listPerPage : 한 페이지에 보여질 게시물 갯수
	// pageBlock : 하단 페이지( < 1/2/3/4/5 >) & clickPage : 현재 페이지
	// requestURL : 링크주소
	public static String pageWrite(int total, int listPerPage, int pageBlock, int clickPage, String requestURL) {
		String pageString = "";
		// total을 받아서 전체 페이지 갯수를 구하고
		int totalPages = (int)Math.ceil( (double) total / listPerPage );
		
		int tempPage = ((clickPage - 1) / pageBlock) * pageBlock + 1;
		if(tempPage != 1) {
			pageString += "<li>"
					/* + "<a href=\"\">" */
							+ "<a href='"+requestURL+"?clickPage=1'>"
								+ "<span class='material-icons'> keyboard_double_arrow_left </span>"
							+ "</a>"
							+ "</li>";
			pageString += "<li>"
							+ "<a href='"+requestURL+"?clickPage="+(tempPage - 1)+"'>"
								+ "<span class='material-icons'> chevron_left </span>"
							+ "</a>"
							+ "</li>";
		}
		
		int pageBlockCount = 1;
		while(pageBlockCount <= pageBlock && tempPage <= totalPages) {
			if(tempPage == clickPage) {
				pageString += "<li class='active'><a href=''>"+tempPage+"</a></li>";
			} else {
				pageString += "<li><a href='"+requestURL+"?clickPage="+tempPage+"'>"+tempPage+"</a></li>";
			}
			tempPage++;
			pageBlockCount++;
		}
		
		if(tempPage <= totalPages) {
			pageString += "<li>"
							+ "<a href='"+requestURL+"?clickPage="+ tempPage +"'>"
								+ "<span class='material-icons'> chevron_right </span>"
							+ "</a>"
							+ "</li>";
			pageString += "<li>"
							+ "<a href='"+requestURL+"?clickPage="+totalPages+"'>"
								+ "<span class='material-icons'> keyboard_double_arrow_right </span>"
							+ "</a>"
							+ "</li>";
		}
		System.out.println(pageString);
		/*
		 <c:if test="${startPage != 1 }">
		<li><a href="BoardList.do?clickPage=${startPage - pageBlock }&search_select=${param.search_select}&search_word=${param.search_word}"><span class="material-icons"> chevron_left </span></a></li>
	</c:if>
	
	<c:forEach var="page" begin="${startPage }" end="${endPage }">
		<li class="${clickPage == page ? 'active' : '' }"><a href="BoardList.do?clickPage=${page }&search_select=${param.search_select}&search_word=${param.search_word}">${page}</a></li>
	</c:forEach>
	
	<c:if test="${endPage != lastPage }">
		<li><a href="BoardList.do?clickPage=${startPage + pageBlock }&search_select=${param.search_select}&search_word=${param.search_word}"><span class="material-icons"> chevron_right </span></a></li>
	</c:if>
		 */
		
		return pageString;
	}
}
