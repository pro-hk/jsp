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

@WebServlet("/DeleteProcess.do")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setNo(Integer.parseInt(request.getParameter("no")));
		boardDto.setPassword(request.getParameter("user_pw"));
		int result = boardDao.deleteBoard(boardDto);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "삭제되었습니다.", "List.do");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인하세요.");
		}
	}

}
