package com.prohk.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ReplyBoardDao;
import com.prohk.util.ScriptWriter;

@WebServlet("/board/AllDelete.do")
public class AllDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllDeleteController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// checkbox는 배열로 받음
		String[] checkList = request.getParameterValues("delete_check");
		
		ReplyBoardDao boardDao = new ReplyBoardDao();
		int result = 0;
		for(String item: checkList) {
			boardDao.allDeleteBoard(Integer.parseInt(item));
			result++;
		}
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "삭제되었습니다.", "../board/List.do");
		}
	}
}
