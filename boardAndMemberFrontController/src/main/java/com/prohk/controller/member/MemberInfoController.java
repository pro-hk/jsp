package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;

public class MemberInfoController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "member/member_info";
		ModelAndView mav = new ModelAndView(nextPage);
		
		String user_id = request.getParameter("user_id");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = memberDao.getSelectOne(user_id);
		
		mav.addObject("memberInfo", memberDto);
		
		return mav;
	}

}
