package com.prohk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.front.ModelAndView;

public interface AbstractController {
	// 인터페이스는 method 정의만 해둠
	// Controller에서 구현
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
