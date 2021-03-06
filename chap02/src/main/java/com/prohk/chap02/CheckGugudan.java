package com.prohk.chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckGugudan")
public class CheckGugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckGugudan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String checkdan[] = request.getParameterValues("checkdan");
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
			for(int j=0; j<checkdan.length;j++) {
				int dan = Integer.parseInt(checkdan[j]);
				out.println("<td>" + dan + "단</td>");
			}
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for (int i = 1; i < 10; i++) {
			out.println("<tr>");
				for(int j=0; j<checkdan.length;j++) {
					int dan = Integer.parseInt(checkdan[j]);
					out.println("<td>" + dan + " X " + i + " = " + dan*i + "</td>");
				}
			out.println("</tr>");
			}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='javascript:history.back();'>돌아가기</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
