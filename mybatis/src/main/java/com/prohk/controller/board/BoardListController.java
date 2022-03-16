package com.prohk.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;
import com.prohk.util.PageWriter;

@WebServlet("/board/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
		request.setAttribute("boardList", boardList);
		
		String page = PageWriter.pageWrite(totalPage, listPerPage, pageBlock, clickPage, "../board/BoardList.do");
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("clickPage", clickPage);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/board_list.jsp");
		dispatcher.forward(request, response);
	}
}
