package com.prohk.chap02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userId = request.getParameter("user_id");
		int userAge = Integer.parseInt(request.getParameter("user_age"));
		String isAdult = "어른";
		if(userAge<20) isAdult = "미성년자";
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>");
		out.println("당신의 아이디는 " + userId+"이고 나이는 "+userAge+"입니다. 당신은 "+isAdult+"입니다.");
		out.println("</p>");
		out.println("<a href='javascript:history.back();'>돌아가기</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userId = request.getParameter("user_id");
		int userAge = Integer.parseInt(request.getParameter("user_age"));
		String isAdult = "어른";
		if(userAge<20) isAdult = "미성년자";
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<p>");
		out.println("당신의 아이디는 " + userId+"이고 나이는 "+userAge+"입니다. 당신은 "+isAdult+"입니다.");
		out.println("</p>");
		out.println("<a href='javascript:history.back();'>돌아가기</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
