package com.yakcook.review.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yakcook.review.service.ReviewService;
import com.yakcook.review.vo.ReviewImgVo;
import com.yakcook.review.vo.ReviewListVo;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/review")

public class ReviewController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String title = req.getParameter("review_title"); //리뷰제목 받아오기
		String contents = req.getParameter("review_contents");//리뷰내용 받아오기
		String userId = req.getParameter("userId");//회원 아이디 받아오기
		int result = 0;
		int imgResult = 0;
		
		ReviewListVo r = new ReviewListVo();
		ReviewImgVo i = new ReviewImgVo();
		
		//jsp에 있는 모든 parts들을 가져온다.
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
				String serverFile = "" + UUID.randomUUID() + ".jpg";

				// 저장할 경로
				String realPath = req.getServletContext().getRealPath("/resources/images/review");

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
				//count가 0번째일시 첫번째 이미지만 저장함.
				if (count == 0) {
					i.setImgServerFile1(serverFile);
				} else if (count == 1) {
					//count가 1번째일시 두번째 이미지까지 저장함.
					i.setImgServerFile2(serverFile);
				} else if (count == 2) {
					//count가 2번째일시 세번째 이미지까지 저장함.
					i.setImgServerFile3(serverFile);
				} else {
					System.out.println("에러가 발생하였습니다");
				}
				//카운트는 전체 코드가 돌때마다 1번씩 증가한다.
				count += 1;
				// System.out.println(result);
			}
		}
		
		r.setReviewTitle(title);
		r.setReviewContents(contents);
		r.setUserId(userId);
		result = new ReviewService().writerReview(r);
		imgResult = new ReviewService().imgReview(i);
		PrintWriter out = resp.getWriter();
		
		
		if (result > 0 && imgResult > 0) {
			out.println("<script>alert('게시물이 등록되었습니다.')</script>");
			
		
		} else {
			out.println("<script>alert('게시물이 등록이 실패되었습니다.')</script>");
		}

	}
}
