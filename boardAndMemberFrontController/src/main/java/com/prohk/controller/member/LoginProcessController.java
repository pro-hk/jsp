package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;
import com.prohk.util.ScriptWriter;

public class LoginProcessController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "BoardList.do";
		ModelAndView mav = null;
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		MemberDao memberDao = new MemberDao();
		MemberDto loggedMember = memberDao.getLoggedMember(memberDto);
		if(loggedMember!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedMember", loggedMember);
			session.setAttribute("loggedId", loggedMember.getId());
			session.setAttribute("loggedName", loggedMember.getName());
			mav = new ModelAndView(nextPage, "alertMsg", loggedMember.getName()+"님 로그인되었습니다");
		} else {
			mav = new ModelAndView(nextPage, "backMsg", "아이디 또는 비밀번호를 확인하세요");
		}
		return mav;
	}
}
