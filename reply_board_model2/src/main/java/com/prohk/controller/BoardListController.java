package com.prohk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;

@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		String tempclickPage = request.getParameter("clickPage");
		if(tempclickPage==null) {
			tempclickPage = "1";
		}
		int clickPage = Integer.parseInt(tempclickPage);
		
		int totalPage = replyBoardDao.getTotal();
		int listPerPage = 3; // 한 페이지에 보여질 갯수
		int pageBlock = 2; // pagination에 뿌려질 페이지 갯수   < 1/2 >
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
		
		ArrayList<ReplyBoardDto> boardList = replyBoardDao.getAllList(start, end);
		request.setAttribute("boardList", boardList);
		
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listPerPage", listPerPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("clickPage", clickPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board_list.jsp");
		dispatcher.forward(request, response);
	}
}
