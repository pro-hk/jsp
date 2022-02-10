package com.prohk.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.MemberDao;
import com.prohk.model.MemberDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/JoinProcess.do")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		
		String user_phone = "";
		String user_phone_first = request.getParameter("user_phone_first");
		String user_phone_middle = request.getParameter("user_phone_middle");
		String user_phone_last = request.getParameter("user_phone_last");
		user_phone = user_phone_first + "-" + user_phone_middle + "-" + user_phone_last;
		String user_address = "";
		String user_address01 = request.getParameter("address01");
		String user_address02 = request.getParameter("address02");
		user_address = user_address01+user_address02;
		
		memberDto.setId(request.getParameter("user_id"));
		memberDto.setPassword(request.getParameter("user_pw"));
		memberDto.setName(request.getParameter("user_name"));
		memberDto.setEmail(request.getParameter("user_email"));
		memberDto.setPhone(user_phone);
		memberDto.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
		memberDto.setAddress(user_address);
		
		int result = memberDao.insertMember(memberDto);
		if(result > 0 ) {
			ScriptWriter.alertAndNext(response, "회원가입되었습니다", "Index.do");
		} else {
			ScriptWriter.alertAndBack(response, "회원가입에 실패하였습니다.");
		}
	}
}
