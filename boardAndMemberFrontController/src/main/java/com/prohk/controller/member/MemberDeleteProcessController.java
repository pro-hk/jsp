package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;

public class MemberDeleteProcessController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "Index.do";
		ModelAndView mav = new ModelAndView(nextPage);
		
		String user_id = request.getParameter("user_id"); 
		String user_pw = request.getParameter("user_pw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.deleteMember(memberDto);
		if (result > 0) {
			mav.addObject("alertMsg", "ȸ��Ż��Ǿ����ϴ�");
		} else {
			mav.addObject("backMsg", "���̵� �Ǵ� ��й�ȣ�� Ȯ���ϼ���");
		}
		
		return mav;
	}

}
