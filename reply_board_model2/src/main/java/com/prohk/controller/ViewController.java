package com.prohk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;

@WebServlet("/View.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no =  Integer.parseInt(request.getParameter("no"));
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = replyBoardDao.getSelectOne(no);
		request.setAttribute("replyBoardDto", replyBoardDto);
		
		// 이전글 보기
		// no는 sequence이기 때문에 글이 연결되지 않는다. rownum을 이용해서 가져오기를 해야된다.
		int num =  Integer.parseInt(request.getParameter("num"));
		ReplyBoardDto prevReplyBoardDto = null;
		prevReplyBoardDto = replyBoardDao.getPrevSelect(num);
		request.setAttribute("prevReplyBoardDto", prevReplyBoardDto);
		
		ReplyBoardDto nextReplyBoardDto = null;
		nextReplyBoardDto = replyBoardDao.getNextSelect(num);
		request.setAttribute("nextReplyBoardDto", nextReplyBoardDto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}
}
