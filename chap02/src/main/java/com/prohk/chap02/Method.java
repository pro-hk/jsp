package com.prohk.chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Method")
public class Method extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Method() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("user_name");
		PrintWriter out = response.getWriter();
		out.println("<h1>GET ��� �޾Ƽ� ó��"+name+"</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("user_name");
		PrintWriter out = response.getWriter();
		out.println("<h1>POST ��� �޾Ƽ� ó��"+name+"</h1>");
	}

}