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

@WebServlet("/member/UpdateProcess.do")
public class UpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_phone_first = request.getParameter("user_phone_first");
		String user_phone_middle = request.getParameter("user_phone_middle");
		String user_phone_last = request.getParameter("user_phone_last");
		String user_phone = user_phone_first + "-" + user_phone_middle + "-" + user_phone_last;
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String address01 = request.getParameter("address01");
		String address02 = request.getParameter("address02");
		String address = address01 + address02;
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		memberDto.setName(user_name);
		memberDto.setEmail(user_email);
		memberDto.setPhone(user_phone);
		memberDto.setZipCode(zipcode);
		memberDto.setAddress(address);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.updateMember(memberDto);
		if(result > 0) {
			session.setAttribute("loggedName", user_name);
			ScriptWriter.alertAndNext(response, "회원정보가 변경되었습니다.", "../board/Index.do");
		} else {
			ScriptWriter.alertAndBack(response, "아이디 또는 비밀번호를 확인하세요.");
		}
	}
}
