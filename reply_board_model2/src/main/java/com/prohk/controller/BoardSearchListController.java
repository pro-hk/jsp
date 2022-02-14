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
import com.prohk.util.ScriptWriter;

@WebServlet("/BoardSearchList.do")
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String search_select = request.getParameter("search_select");
		String search_word = request.getParameter("search_word");
		
		if(search_word.equals("") || search_word==null) {
			ScriptWriter.alertAndBack(response, "검색어를 입력하세요.");
		} else {
			ReplyBoardDao replyBoardDao = new ReplyBoardDao();
			ArrayList<ReplyBoardDto> boardList = replyBoardDao.getSearchAllList(search_select, search_word);
			request.setAttribute("boardList", boardList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("search_list.jsp");
			dispatcher.forward(request, response);
		}
	}
}
