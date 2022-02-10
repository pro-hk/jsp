package com.prohk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.prohk.model.ClockDao;
import com.prohk.model.ClockDto;

@WebServlet("/ClockJsonList.do") //url-mapping
public class ClockJsonListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClockJsonListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ClockDto> clockList = null;
		ClockDao clockDao = new ClockDao();
		clockList = clockDao.getAllList();
		
		HashMap<String, ArrayList<ClockDto>> hashMap = new HashMap<>();
		hashMap.put("clockList", clockList);
		
		Gson gson = new Gson();
		String clockJsonList = gson.toJson(hashMap);
		// {"clockList" : [] }
		
		request.setAttribute("clockJsonList", clockJsonList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("clock_list.jsp");
		dispatcher.forward(request, response);
	}

}
