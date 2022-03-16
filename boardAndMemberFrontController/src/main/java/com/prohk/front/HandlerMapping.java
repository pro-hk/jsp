package com.prohk.front;

import java.util.HashMap;

import com.prohk.controller.AbstractController;
import com.prohk.controller.board.*;
import com.prohk.controller.member.*;

// command에 실려 넘어오는 주소를 Controller Mapping
public class HandlerMapping {
	private HashMap<String, AbstractController> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, AbstractController>();
		
		//boardMapping
		mappings.put("/BoardList.do", new BoardListController());
		mappings.put("/View.do", new ViewController());
		
		//memberMapping
		mappings.put("/Login.do", new LoginController());
		mappings.put("/LoginProcess.do", new LoginProcessController());
		mappings.put("/Logout.do", new LogoutController());
		mappings.put("/Join.do", new JoinController());
		mappings.put("/JoinProcess.do", new JoinProcessController());
		mappings.put("/MemberList.do", new MemberListController());
		mappings.put("/MemberInfo.do", new MemberInfoController());
		mappings.put("/MemberDelete.do", new MemberDeleteController());
		mappings.put("/MemberDeleteProcess.do", new MemberDeleteProcessController());
	}
	public AbstractController getController(String key) {
		return mappings.get(key);
	}
}
