package com.yakcook.product.service;

import static com.yakcook.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.yakcook.product.dao.DaoProduct;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.ProductVo;

public class ServiceProduct {

	// 제품 조회 페이지에 좌측 카테고리 가지고 오는 메소드
	public List<CategoryVo> searchCategory() {
		
		Connection conn = getConnection();
		
		List<CategoryVo> list = new DaoProduct().searchCategory(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}
	
	// 제품 조회 페이지 처음 전체 품목 가지고 오는 메소드
	public List<ProductVo> searchAllProduct() {
		
		Connection conn = getConnection();
		
		List<ProductVo> list = new DaoProduct().searchAllProduct(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}

	// 카테고리 선택시 선택 카테고리의 제품만 가지고 오는 메소드
	public List<ProductVo> searchSelectedCategoryProduct(int categoryNo) {
		
		Connection conn = getConnection();
		
		List<ProductVo> list = new DaoProduct().searchSelectedCategoryProduct(categoryNo, conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}
	
	// 정렬한 제품 가져오기 보류%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//	public List<ProductVo> searchRangeProduct(int range) {
//		
//		Connection conn = getConnection();
//		
//		if(range == 1) {
//			List<ProductVo> list = new DaoProduct().searchRangeProductDate(range, conn);			
//		} else if(range == 2 || range == 3) {
//			List<ProductVo> list = new DaoProduct().searchRangeProductPrice(range, conn);
//		}
//		
//		try {
//			commit(conn);
//		} catch (Exception e) {
//			rollback(conn);
//		} finally {
//			close(conn);
//		}
//		
//		return list;
//	}	
}
