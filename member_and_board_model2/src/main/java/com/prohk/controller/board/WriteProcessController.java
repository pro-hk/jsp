package com.prohk.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/board/WriteProcess.do")
public class WriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		
		replyBoardDto.setSubject(request.getParameter("user_subject"));
		replyBoardDto.setName(request.getParameter("user_name"));
		replyBoardDto.setEmail(request.getParameter("user_email"));
		replyBoardDto.setPassword(request.getParameter("user_pw"));
		replyBoardDto.setContents(request.getParameter("user_contents"));
		replyBoardDto.setId((String)session.getAttribute("loggedId"));
		
		int result = replyBoardDao.insertBoard(replyBoardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "글이 입력되었습니다", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류");
		}
	}
}
