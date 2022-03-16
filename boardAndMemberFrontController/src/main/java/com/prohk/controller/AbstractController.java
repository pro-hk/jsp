package com.prohk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prohk.front.ModelAndView;

public interface AbstractController {
	// �������̽��� method ���Ǹ� �ص�
	// Controller���� ����
	public ModelAndView requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
