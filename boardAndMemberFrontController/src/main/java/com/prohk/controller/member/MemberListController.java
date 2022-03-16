package com.prohk.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;

public class MemberListController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "member/list";
		ModelAndView mav = new ModelAndView(nextPage);
		
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");

		MemberDao memberDao = new MemberDao();
		
		String tempclickPage = request.getParameter("clickPage");
		if(tempclickPage==null) {
			tempclickPage = "1";
		}
		int clickPage = Integer.parseInt(tempclickPage);
		
		int totalPage = memberDao.getTotal(search_select, search_word);
		int listPerPage = 5; // 한 페이지에 보여질 갯수
		int pageBlock = 10; // pagination에 뿌려질 페이지 갯수   < 1/2 >
		int lastPage = 0;
		if(totalPage % listPerPage == 0) {
			lastPage = totalPage/listPerPage;
		} else {
			lastPage = totalPage/listPerPage + 1; // 마지막 페이지 갯수
		}
		
		int startPage = ((clickPage - 1) /pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		
		int start = (clickPage - 1) * listPerPage + 1;
		int end = clickPage * listPerPage;
		
		List<MemberDto> memberList = memberDao.getAllMemberList(start, end, search_select, search_word);
		
		mav.addObject("memberList", memberList);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("listPerPage", listPerPage);
		mav.addObject("pageBlock", pageBlock);
		mav.addObject("lastPage", lastPage);
		mav.addObject("totalPage", totalPage);
		mav.addObject("clickPage", clickPage);
		
		return mav;
	}

}
