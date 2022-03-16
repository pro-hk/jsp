package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;

public class JoinProcessController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "Index.do";
		ModelAndView mav = new ModelAndView(nextPage);
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone_first = request.getParameter("user_phone_first");
		String user_phone_middle = request.getParameter("user_phone_middle");
		String user_phone_last = request.getParameter("user_phone_last");
		String user_phone = user_phone_first+ "-" + user_phone_middle+ "-" + user_phone_last;
		String zipcode = request.getParameter("zipcode");
		String address01 = request.getParameter("address01");
		String address02 = request.getParameter("address02");
		String address = address01 + address02;
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		memberDto.setName(user_name);
		memberDto.setEmail(user_email);
		memberDto.setPhone(user_phone);
		memberDto.setZipCode(Integer.parseInt(zipcode));
		memberDto.setAddress(address);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.insertMember(memberDto);
		if(result > 0) {
			mav.addObject("alertMsg", "회원가입되었습니다.");
		} else {
			mav.addObject("backMsg", "회원가입에 실패하였습니다");
		}
		
		return mav;
	}

}
