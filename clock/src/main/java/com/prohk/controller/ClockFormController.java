package com.prohk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ClockForm.do")
public class ClockFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClockFormController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// file forward
		request.setAttribute("test", "servlet���� �Ѿ�� ������");
		RequestDispatcher dispatcher = request.getRequestDispatcher("hublot_form.jsp"); // ������ jsp����
		dispatcher.forward(request, response);
	}

}
