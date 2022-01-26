package com.prohk.chap03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public start() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

// servlet �� �ڹ� ���Ͽ� html ����
// jsp �� html�� �ڹ� ���� model1
// model2 : Model(java dto)View(jsp)Controller(java)

