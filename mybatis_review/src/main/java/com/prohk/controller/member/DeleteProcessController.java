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

@WebServlet("/member/DeleteProcess.do")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.deleteMember(memberDto);
		System.out.println(result);
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "회원탈퇴 되었습니다. \r\n 이용해주셔서 감사합니다.", "../board/Index.do");
			session.invalidate();
		} else {
			ScriptWriter.alertAndBack(response, "아이디 또는 비밀번호를 확인하세요.");
		}
	}
}
