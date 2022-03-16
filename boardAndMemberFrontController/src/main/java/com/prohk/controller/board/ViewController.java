package com.prohk.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.front.ModelAndView;
import com.prohk.model.ReplyBoardDao;
import com.prohk.model.ReplyBoardDto;

public class ViewController implements AbstractController {
	@Override
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "board/view";
		ModelAndView mav = new ModelAndView(nextPage);
		
		int no =  Integer.parseInt(request.getParameter("no"));
		ReplyBoardDao replyBoardDao = new ReplyBoardDao();
		ReplyBoardDto replyBoardDto = replyBoardDao.getSelectOne(no);
		mav.addObject("replyBoardDto", replyBoardDto);
		
		int num =  Integer.parseInt(request.getParameter("num"));
		ReplyBoardDto prevReplyBoardDto = null;
		prevReplyBoardDto = replyBoardDao.getPrevSelect(num);
		mav.addObject("prevReplyBoardDto", prevReplyBoardDto);
		
		ReplyBoardDto nextReplyBoardDto = null;
		nextReplyBoardDto = replyBoardDao.getNextSelect(num);
		mav.addObject("nextReplyBoardDto", nextReplyBoardDto);
		
		return mav;
	}

}
