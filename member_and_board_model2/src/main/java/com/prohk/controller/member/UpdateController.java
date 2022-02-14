package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;

@WebServlet("/member/Update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.getSelectOne(user_id);
		
		String phone = memberDto.getPhone();
		String phoneNum[] = phone.split("-");
		
		request.setAttribute("memberDto", memberDto);
		request.setAttribute("phoneMiddle", phoneNum[1]);
		request.setAttribute("phoneLast", phoneNum[2]);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/member/update.jsp");
		dispatcher.forward(request, response);
	}
}
