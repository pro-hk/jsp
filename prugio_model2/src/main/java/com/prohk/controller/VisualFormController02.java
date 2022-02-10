package com.prohk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisualForm02.do")
public class VisualFormController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VisualFormController02() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("visual02.jsp");
		dispatcher.forward(request, response);
	}

}
