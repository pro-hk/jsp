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

@WebServlet("/board/UpdateProcess.do")
public class UpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = new ReplyBoardDto();
		replyBoardDto.setNo(Integer.parseInt(request.getParameter("no")));
		replyBoardDto.setName(request.getParameter("user_name"));
		replyBoardDto.setSubject(request.getParameter("user_subject"));
		replyBoardDto.setEmail(request.getParameter("user_email"));
		replyBoardDto.setPassword(request.getParameter("user_pw"));
		replyBoardDto.setContents(request.getParameter("user_contents"));
		int result = replyBoardDao.updateBoard(replyBoardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "수정되었습니다.", "BoardList.do");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인하세요.");
		}
	}
}
