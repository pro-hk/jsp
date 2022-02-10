package com.prohk.controller;

import java.io.File;
import java.io.IOException;

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

@WebServlet("/VisualUpload.do")
public class VisualUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VisualUploadController() {
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
		
		String slogan = multipart.getParameter("user_slogan");
		String visualImg = multipart.getOriginalFileName("user_visual");
		String visualRealImg = multipart.getFilesystemName("user_visual");
		
		VisualDao visualDao = new VisualDao();
		VisualDto visualDto = new VisualDto();
		visualDto.setSlogan(slogan);
		visualDto.setVisualImg(visualImg);
		visualDto.setVisualRealImg(visualRealImg);
		
		int result = visualDao.insertVisual(visualDto);
		if(result > 0) {
			response.sendRedirect("index.do");
		} else {
			ScriptWriter.alertAndBack(response, "DB¿À·ù");
		}
	}

}
