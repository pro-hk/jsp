package com.prohk.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/Index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/index.jsp");
		dispatcher.forward(request, response);
	}
	
	// web-inf 경로는 브라우저에서 접근 불가능..
	// Spring은 web-inf 밑에 wiews라는 폴더를 만들어 놓고 쓴다.
	// view Resolver를 통해서 prefix와 suffix를 통해 파일의 경로를 만들어 쓴다.
}
