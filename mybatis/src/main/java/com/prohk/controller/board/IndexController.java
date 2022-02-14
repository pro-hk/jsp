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
	
	// web-inf ��δ� ���������� ���� �Ұ���..
	// Spring�� web-inf �ؿ� wiews��� ������ ����� ���� ����.
	// view Resolver�� ���ؼ� prefix�� suffix�� ���� ������ ��θ� ����� ����.
}
