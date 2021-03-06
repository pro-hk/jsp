package com.prohk.chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Gugudan() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		String checkdan[] = request.getParameterValues("checkdan");
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
			out.println("<thead><tr><th>" + dan + "단</th></tr></thead>");
			for (int i = 1; i < 10; i++) {
				out.println("<tbody>");
				out.println("<tr><td>" + dan + " X " + i + " = " + dan*i + "</td></tr>");
				out.println("</tbody>");
			}
			for(int j=0; j<checkdan.length;j++) {
				out.println("<thead><tr><th>" + checkdan[j] + "단</th></tr></thead>");
				for (int i = 1; i < 10; i++) {
					out.println("<tbody>");
					out.println("<tr><td>" + checkdan[j] + " X " + i + " = " + Integer.parseInt(checkdan[j])*i + "</td></tr>");
					out.println("</tbody>");
				}
			}
		out.println("</table>");
		out.println("<a href='javascript:history.back();'>돌아가기</a>");
		out.println("</body>");
		out.println("</html>");
//		<table>
//			<thead><tr><th>2단</th></tr></thead>
//			<tbody>
//				<tr><td> 2 X 1 = 2 </td></tr>
//			</tbody>
//		</table>
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
