package com.prohk.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.controller.AbstractController;
import com.prohk.util.ScriptWriter;

// .do�� ������ ��� url�� ó��
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// ModelAndView
		ModelAndView mav = null;

		// command : xxx.do �̸��� ã��
		String context = request.getContextPath();
		String uri = request.getRequestURI(); // ��ü ��û �ּ�
		String command = uri.substring(context.length());
		
		// view mapping : jsp���� ��� ã��
		ViewResolver viewResolver = new ViewResolver();
		viewResolver.setPrefix("WEB-INF/");
		viewResolver.setSuffix(".jsp");
		
		// Mappings���� Controller ������
		// controller mapping ���ִ� HandlerMapping
		HandlerMapping mappings = new HandlerMapping();
		AbstractController controller = null;
		controller = mappings.getController(command);
		mav = controller.requestHandler(request, response);

		String tempPage = mav.getNextPage();
		String nextPage = null;
		if(tempPage.contains(".do")) {
			nextPage = tempPage;
		} else {
			nextPage = viewResolver.getViewPage(tempPage);
		}
		
		Map<String, Object> model = mav.getModel();
		for(String key : model.keySet()) {
			request.setAttribute(key, model.get(key));
		}
		String alertMsg = (String)model.get("alertMsg");
		String backMsg = (String)model.get("backMsg");
		
		// ������ �Ʊ�( request.setAttribute )
		if(alertMsg!=null) {
			ScriptWriter.alertAndNext(response, alertMsg, nextPage);
		} else if(backMsg!=null) {
			ScriptWriter.alertAndBack(response, backMsg);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	}
}
