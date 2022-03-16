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
public class BoardUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String user_name = request.getParameter("user_name");
		String user_subject = request.getParameter("user_subject");
		String user_email = request.getParameter("user_email");
		String user_pw = request.getParameter("user_pw");
		String user_contents = request.getParameter("user_contents");
		
		ReplyBoardDto boardDto = new ReplyBoardDto();
		boardDto.setNo(no);
		boardDto.setName(user_name);
		boardDto.setSubject(user_subject);
		boardDto.setEmail(user_email);
		boardDto.setPassword(user_pw);
		boardDto.setContents(user_contents);
		
		ReplyBoardDao boardDao = new ReplyBoardDao();
		int result = boardDao.updateBoard(boardDto);
		if(result > 0 ) {
			ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "../board/List.do");
		} else {
			ScriptWriter.alertAndBack(response, "글이 수정되지 않았습니다.");
		}
	}
}
