package com.prohk.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;

public class MemberDeleteController implements AbstractController {

	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "member/delete";
		ModelAndView mav = new ModelAndView(nextPage);
		
		return mav;
	}

}
