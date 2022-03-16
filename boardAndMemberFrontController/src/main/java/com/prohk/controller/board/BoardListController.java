package com.prohk.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;
import com.prohk.util.PageWriter;

public class BoardListController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "board/board_list";
		ModelAndView mav = new ModelAndView(nextPage);
		
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");
		
		String tempclickPage = request.getParameter("clickPage");
		if(tempclickPage==null) {
			tempclickPage = "1";
		}
		int clickPage = Integer.parseInt(tempclickPage);
		int totalPage = replyBoardDao.getTotal(search_select, search_word);
		int listPerPage = 5;
		int pageBlock = 3;
		
		int start = (clickPage - 1) * listPerPage + 1;
		int end = clickPage * listPerPage;
		
		List<ReplyBoardDto> boardList = replyBoardDao.getAllList(start, end, search_select, search_word);
		mav.addObject("boardList", boardList);
		
		String page = "";
		if(search_word != null && search_word != "") {
			page = PageWriter.pageWrite(totalPage, listPerPage, pageBlock, clickPage,
										"BoardList.do?search_select="+search_select+"&search_word="+search_word);
		} else {
			page = PageWriter.pageWrite(totalPage, listPerPage, pageBlock, clickPage, "BoardList.do");
		}
		
		mav.addObject("page", page);
		mav.addObject("totalPage", totalPage);
		mav.addObject("listPerPage", listPerPage);
		mav.addObject("clickPage", clickPage);
		
		return mav;
	}

}
