package com.prohk.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.prohk.model.ClockDao;
import com.prohk.model.ClockDto;
import com.prohk.util.ScriptWriter;


// servlet�� java�� html
// jsp�� html�� java
@WebServlet("/ClockUploadController.do")
public class ClockUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ClockUploadController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get / post (�� �� ���� -> action���� �Ѿ���°� �� �� �ްڴ�)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
//		MultipartRequest multiPart = new MultipartRequest(request, ����������, ���ε� ���� ������, ���ڵ�, �ߺ�����ó��)
		String savePath = "upload_clock";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		int fileSize = 1024 * 1024 * 50; // 50mb
		String encoding = "UTF-8";
		// ������ �� : UUID or ��¥�̾Ƽ� ���
		File dir = new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		MultipartRequest multiPart = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		
		//String category = multiPart.getParameter("category");
		
		ClockDao clockDao = new ClockDao();
		ClockDto clockDto = new ClockDto();
		
		clockDto.setCategory(multiPart.getParameter("category"));
		clockDto.setTitle(multiPart.getParameter("title"));
		clockDto.setDepth(Integer.parseInt(multiPart.getParameter("depth")));
		clockDto.setPrice(Integer.parseInt(multiPart.getParameter("price")));
		clockDto.setLink(multiPart.getParameter("link"));
		clockDto.setClockImg(multiPart.getOriginalFileName("hublotFile"));
		clockDto.setClockRealImg(multiPart.getFilesystemName("hublotFile"));
		
		int result = clockDao.insertClock(clockDto);
		if(result > 0) {
			response.sendRedirect("Main.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB�����Դϴ�.");
		}
	}

}
