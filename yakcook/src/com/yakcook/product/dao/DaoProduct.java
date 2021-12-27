package com.yakcook.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.ProductVo;

public class DaoProduct {

	// 제품 조회 페이지에 좌측 카테고리 가지고 오는 메소드
	public List<CategoryVo> searchCategory(Connection conn) {
		
		PreparedStatement pstmt = null;;
		ResultSet rs = null;
		String sql = "SELECT * FROM CATEGORY";
		CategoryVo cv = null;
		List<CategoryVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int categoryNo = rs.getInt("CATEGORY_NO");
				String categoryName = rs.getString("CATEGORY_NAME");
				
				cv = new CategoryVo();
				
				cv.setCategoryNo(categoryNo);
				cv.setCategoryName(categoryName);
				
				list.add(cv);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	// 제품 조회 페이지 처음 전체 품목 가지고 오는 메소드
	public List<ProductVo> searchAllProduct(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Timestamp categoryDate = rs.getTimestamp("CATEGORY_DATE");
				String productContents = rs.getString("PRODCUT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Timestamp lasteditDate = rs.getTimestamp("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryNo = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryNo);
				
				
				list.add(pv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
	// 카테고리 선택시 선택 카테고리의 제품만 가지고 오는 메소드
	public List<ProductVo> searchSelectedCategoryProduct(int categoryNo, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE CATEGORY_NO = ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				
				pv = new ProductVo();
				
				pv.setProductName(productName);
				pv.setPrice(price);
				
				list.add(pv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	// 정렬한 제품 가져오기 최신 순 보류%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//	public List<ProductVo> searchRangeProductDate(int range, Connection conn) {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "SELECT * FROM PRODUCT "
//		
//		
//		
//		return null;
//	}

}
