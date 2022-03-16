package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/Update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String user_id = request.getParameter("id"); String user_name =
		 * request.getParameter("name");
		 */
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/update.jsp");
		dispatcher.forward(request, response);
	}
}
