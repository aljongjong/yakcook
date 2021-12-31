package com.yakcook.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewVo;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/review")

public class ReviewController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("review_title");
		String contents = req.getParameter("review_contents");
		String writer = req.getParameter("writer_name");
		int result = 0;
		int imgResult = 0;
		
		
		ReviewVo r = new ReviewVo();
		ReviewImgVo i = new ReviewImgVo();
		
		Collection<Part> parts = req.getParts();
		
	
		// 모든 part들이 p라는 변수에 담겼음.
		int count = 0;
		for (Part p : parts) {
			if (!p.getName().equals("review_img"))
				continue;
			// part의 이름이 review_img인 경우에만 실행됨
			

			String originName = p.getSubmittedFileName();
			InputStream fis = p.getInputStream();
			if (!originName.equals("")) {
				// 파일 저장하면서 맨뒤에 ".png"를 추가해줌
				String serverFile = " " + UUID.randomUUID() + ".jpg";

				// 저장할 경로
				String realPath = req.getServletContext().getRealPath("/reviewImg");

				String filepath = realPath + File.separator + serverFile  ;

				// 파일저장
				FileOutputStream fos = new FileOutputStream(filepath);

				// 파일 기록 (업로드파일 read->write)
				byte[] buf = new byte[1024];
				int size = 0;

				while ((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				
				// 파일 inputstream,outputstream닫아주기
				fis.close();
				fos.close();
				
				if (count == 0) {
					i.setServerFile1(serverFile);
				} else if (count == 1) {
					i.setServerFile2(serverFile);
				} else if (count == 2) {
					i.setServerFile3(serverFile);
				} else {
					System.out.println("에러가 발생하였습니다");
				}
				count += 1;
				// System.out.println(result);
			}
		}
		
		r.setTitle(title);
		r.setContents(contents);
		r.setWriter(writer);
		
		result = new ReviewService().writerReview(r);
		imgResult = new ReviewService().imgReview(i);

		if (result > 0) {
			req.setAttribute("msg", "게시물등록에 성공하였습니다");
			req.getRequestDispatcher("WEB-INF/views/common/Review/ReviewWriterSuccessPage.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "게시물등록이 실패되었습니다.");
			req.getRequestDispatcher("WEB-INF/views/common/Review/ReviewWriterErrorPage.jsp").forward(req, resp);
		}

	}
}
