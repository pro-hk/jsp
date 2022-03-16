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

@WebServlet("/board/List.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<ReplyBoardDto> boardList = null;
		ReplyBoardDao ReplyBoardDao = new ReplyBoardDao();
		boardList = ReplyBoardDao.getAllList();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}
}
