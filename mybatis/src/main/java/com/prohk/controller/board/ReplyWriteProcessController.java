package com.prohk.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/board/ReplyWriteProcess.do")
public class ReplyWriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyWriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		
		replyBoardDto.setSubject("[re]"+request.getParameter("user_subject"));
		replyBoardDto.setName(request.getParameter("user_name"));
		replyBoardDto.setEmail(request.getParameter("user_email"));
		replyBoardDto.setPassword(request.getParameter("user_pw"));
		replyBoardDto.setContents(request.getParameter("user_contents"));
		
		replyBoardDto.setNo(Integer.parseInt(request.getParameter("no")));
		replyBoardDto.setReGroup(Integer.parseInt(request.getParameter("reGroup")));
		replyBoardDto.setReStep(Integer.parseInt(request.getParameter("reStep")));
		replyBoardDto.setReLevel(Integer.parseInt(request.getParameter("reLevel")));
		
		int result = replyBoardDao.insertReplyBoard(replyBoardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "글이 입력되었습니다", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB오류");
		}
	}
}
