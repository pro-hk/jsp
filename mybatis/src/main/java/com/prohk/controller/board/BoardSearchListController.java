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
import com.prohk.util.ScriptWriter;

@WebServlet("/board/BoardSearchList.do")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchListController() {
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
		int totalPage = replyBoardDao.getSearchTotal(search_select, search_word);
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
		
		String search_start = Integer.toString((clickPage - 1) * listPerPage + 1);
		String search_end = Integer.toString(clickPage * listPerPage);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("clickPage", clickPage);
		
		if(search_word.equals("") || search_word==null) {
			ScriptWriter.alertAndBack(response, "검색어를 입력하세요.");
		} else {
			List<ReplyBoardDto> boardList = replyBoardDao.getSearchAllList(search_select, search_word, search_start, search_end);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/search_list.jsp");
			dispatcher.forward(request, response);
		}
	}
}
