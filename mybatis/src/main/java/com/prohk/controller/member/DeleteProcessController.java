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
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(user_id);
		memberDto.setPassword(user_pw);
		
		int result = memberDao.deleteMember(memberDto);
		if(result > 0) {
			if(user_id.equals(session.getAttribute("loggedId"))) {
				session.invalidate();
			}
			ScriptWriter.alertAndNext(response, "회원탈퇴되었습니다", "../member/List.do");
		} else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인하세요.");
		}
	}
}
