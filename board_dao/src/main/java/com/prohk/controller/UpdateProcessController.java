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

@WebServlet("/UpdateProcess.do")
public class UpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(Integer.parseInt(request.getParameter("no")));
		boardDto.setName(request.getParameter("user_name"));
		boardDto.setSubject(request.getParameter("user_subject"));
		boardDto.setEmail(request.getParameter("user_email"));
		boardDto.setPassword(request.getParameter("user_pw"));
		boardDto.setContents(request.getParameter("user_contents"));
		int result = boardDao.updateBoard(boardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "�����Ǿ����ϴ�.", "List.do");
		} else {
			ScriptWriter.alertAndBack(response, "��й�ȣ�� Ȯ���ϼ���.");
		}
	}
}
