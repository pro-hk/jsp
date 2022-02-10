package com.prohk.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.prohk.model.VisualDao;
import com.prohk.model.VisualDto;
import com.prohk.util.ScriptWriter;

@WebServlet("/VisualUpload02.do")
public class VisualUploadController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VisualUploadController02() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String savePath = "upload_visual";
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		int fileSize = 1024 * 1024 * 50;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		File dir = new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		MultipartRequest multipart = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		
		// Iterator
		Enumeration files = multipart.getFileNames(); // 여러 개의 파일을 받을 수 있다.
		int count = 0;
		while(files.hasMoreElements()) { // 리턴타입 : t/f
			count++;
			String visual = (String)files.nextElement();
			
			String slogan = multipart.getParameter("user_slogan"+count);
			String visualImg = multipart.getOriginalFileName(visual);
			String visualRealImg = multipart.getFilesystemName(visual);
			
			VisualDao visualDao = new VisualDao();
			VisualDto visualDto = new VisualDto();
			visualDto.setSlogan(slogan);
			visualDto.setVisualImg(visualImg);
			visualDto.setVisualRealImg(visualRealImg);
			
			int result = visualDao.insertVisual(visualDto);
			/*
			 * if(result > 0) { response.sendRedirect("index.do"); } else {
			 * ScriptWriter.alertAndBack(response, "DB오류"); }
			 */
		}
	}
}
