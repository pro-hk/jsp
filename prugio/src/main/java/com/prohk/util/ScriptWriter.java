package com.prohk.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ScriptWriter {
	public static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
	}
	
	public static void alert(HttpServletResponse response, String alertMsg) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMsg+"');");
		out.println("</script>");
	}
	public static void alertAndBack(HttpServletResponse response, String alertMsg) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMsg+"');");
		out.println("history.back();");
		out.println("</script>");
	}
	public static void alertAndNext(HttpServletResponse response, String alertMsg, String nextURL) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+alertMsg+"');");
		out.println("location.href='"+nextURL+"';");
		out.println("</script>");
	}
}
