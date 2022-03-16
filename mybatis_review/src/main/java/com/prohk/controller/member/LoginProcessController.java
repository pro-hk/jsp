package com.prohk.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/member/LoginProcess.do")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		if(loggedMember != null) {
			session.setAttribute("loggedMember", loggedMember);
			session.setAttribute("loggedId", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			ScriptWriter.alertAndNext(response, "로그인되었습니다.", "../board/Index.do");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 또는 비밀번호를 확인하세요.");
		}
		
	}
}
