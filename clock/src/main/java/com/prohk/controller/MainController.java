package com.prohk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.model.ClockDao;
import com.prohk.model.ClockDto;

@WebServlet("/Main.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ClockDto> clockList = null;
		ClockDao clockDao = new ClockDao();
		clockList = clockDao.getAllList();
		request.setAttribute("clockList", clockList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
