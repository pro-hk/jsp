package com.prohk.controller;

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

@WebServlet("/LoginProcess.do")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		memberDto.setId(request.getParameter("user_id"));
		memberDto.setPassword(request.getParameter("user_pw"));
		
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		if(loggedMember!=null) {
			// session : jsp ���尴ü
			session.setAttribute("loggedId", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			session.setAttribute("loggedMember", loggedMember); 
			ScriptWriter.alertAndNext(response, loggedMember.getName()+"�� �ȳ��ϼ���.", "/member_model2");
		} else {
			ScriptWriter.alertAndBack(response, "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
		}
	}
}
