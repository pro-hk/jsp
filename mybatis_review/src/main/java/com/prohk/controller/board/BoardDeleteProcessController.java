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

@WebServlet("/board/DeleteProcess.do")
public class BoardDeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("user_pw");
		
		ReplyBoardDto boardDto = new ReplyBoardDto();
		boardDto.setNo(no);
		boardDto.setPassword(password);
		
		ReplyBoardDao boardDao = new ReplyBoardDao();
		int result = boardDao.deleteBoard(boardDto);
		if(result > 0 ) {
			ScriptWriter.alertAndNext(response, "글이 삭제되었습니다.", "../board/List.do");
		} else {
			ScriptWriter.alertAndBack(response, "글이 삭제되지 않았습니다.");
		}
	}
}
