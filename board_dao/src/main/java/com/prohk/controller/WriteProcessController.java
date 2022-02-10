package com.prohk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.BoardDao;
import com.prohk.model.BoardDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/WriteProcess.do")
public class WriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String user_subject = request.getParameter("user_subject");
		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_pw");
		String contents = request.getParameter("user_contents");
		
		BoardDto boardDto = new BoardDto();
		boardDto.setName(user_name);
		boardDto.setSubject(user_subject);
		boardDto.setEmail(user_email);
		boardDto.setPassword(user_pw);
		boardDto.setContents(contents);
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.insertBoard(boardDto);
		if(result > 0) {
			response.sendRedirect("List.do");
		} else {
			ScriptWriter.alertAndBack(response, "데이터베이스 오류입니다.");
		}
	}

}
