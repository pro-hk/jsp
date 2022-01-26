package com.prohk.chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckboxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String items[] = request.getParameterValues("item");  // checkbox�� �迭�� �Ѿ��
		out.println("<html>");
		out.println("<body>");
		if(items==null) out.println("<p>�����Ѱ� �ϳ��� �����.</p>");
		else {
			out.println("<p>����� ������ �׸��Դϴ�.</p>");
			out.println("<ul>");
			for(int i=0; i<items.length; i++) {
				out.println("<li>"+items[i]+"</li>");
			}
			out.println("</ul>");
		}
		out.println("<a href='javascript:history.back();'>���ư���</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}