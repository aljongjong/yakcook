package com.yakcook.product.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yakcook.product.service.ServiceProduct;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.TagVo;


@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
@WebServlet("/registerProduct")
public class RegisterProduct extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 카테고리 불러오기
		List<CategoryVo> categoryList = new ServiceProduct().registerCategoryList();
		req.setAttribute("categoryList", categoryList);
		
		// 태그 불러오기
		List<TagVo> tagList = new ServiceProduct().registerTagList();
		req.setAttribute("tagList", tagList);
		
		req.getRequestDispatcher("/WEB-INF/views/product/registerProduct.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 제품 등록
		String categoryNum = req.getParameter("productCategory");
		String productName = req.getParameter("productName");
		String productPrice = req.getParameter("productPrice");
		String productAmount = req.getParameter("productAmount");
		String productContents = req.getParameter("productContents");
		
		ProductVo pv = new ProductVo();
		pv.setCategoryNo(Integer.parseInt(categoryNum));
		pv.setProductName(productName);
		pv.setPrice(Integer.parseInt(productPrice));
		pv.setInventory(Integer.parseInt(productAmount));
		pv.setProductContents(productContents);
		
		// 태그
		int tagNo1 = Integer.parseInt(req.getParameter("productTag1"));
		int tagNo2 = Integer.parseInt(req.getParameter("productTag2"));
		int tagNo3 = Integer.parseInt(req.getParameter("productTag3"));
		
		int resultTag = 0;
		if(tagNo1 != tagNo2 && tagNo1 != tagNo3 && tagNo2 != tagNo3) {
			resultTag = new ServiceProduct().registerProductTag(pv, tagNo1, tagNo2, tagNo3);			
		} else if(tagNo1 == 0 || tagNo2 == 0 || tagNo3 == 0) {
			resultTag = new ServiceProduct().registerProductTag(pv, tagNo1, tagNo2, tagNo3);
		}
		System.out.println("resultTag : " + resultTag);
		
		// 다중 파일 업로드
		List<ProductImgVo> pImgList = new ArrayList<>();
		
		Collection<Part> parts = req.getParts(); // 모든 part들을 가져옴
		ProductImgVo pImg = null;
		
		if(resultTag == 3) {
			for(Part file : parts) {
				if(!file.getName().equals("f")) continue; // name이 f인 경우에 실행
				
				// 사용자가 업로드한 파일 이름 알아오기
				String originName = file.getSubmittedFileName();
				
				// 사용자가 업로드한 파일에 input 스트림 연결
				InputStream fis = file.getInputStream();
				
				// 파일 이름 변경
				String changeName = "Z" + UUID.randomUUID();
				String ext = originName.substring(originName.lastIndexOf("."), originName.length());
				
				// 저장할 경로
				String realPath = req.getServletContext().getRealPath("/upload/product");
				
				// 파일 경로
				String filePath = realPath + File.separator + changeName + ext;
				
				// 파일 저장
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while((size = fis.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				fis.close();
				fos.close();
				
				pImg = new ProductImgVo();
				pImg.setProductImgName(changeName + ext);
				
				pImgList.add(pImg);
			}
		}
		int resultImg = new ServiceProduct().registerProductImg(pImgList); // 이미지테이블에 이미지 인서트하는 메소
		System.out.println("resultImg : " + resultImg);
		
		if(resultTag == 3) {
			req.setAttribute("msg", "제품 등록을 성공했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/product/registerSuccessProduct.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "제품 등록을 실패하였습니다. 태그 중복을 확인해주세요.");
			req.getRequestDispatcher("/WEB-INF/views/product/registerErrorProduct.jsp").forward(req, resp);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
