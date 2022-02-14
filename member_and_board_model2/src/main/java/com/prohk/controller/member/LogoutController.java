package com.prohk.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prohk.util.ScriptWriter;

@WebServlet("/member/Logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggedName = (String)session.getAttribute("loggedName");
		ScriptWriter.alertAndNext(response, loggedName+"´Ô ·Î±×¾Æ¿ôµÇ¾ú½À´Ï´Ù.", "../board/Index.do");
		session.invalidate();
	}
}
