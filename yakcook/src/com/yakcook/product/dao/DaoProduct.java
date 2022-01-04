package com.yakcook.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.MemberVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;
import com.yakcook.product.vo.TagVo;

public class DaoProduct {

	// 제품 이미지 불러오는 메소드
	public List<ProductImgVo> searchAllProductImg(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT_IMG ORDER BY PRODUCT_IMG_NO";
		ProductImgVo piv = null;
		List<ProductImgVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productImgNo = rs.getInt("PRODUCT_IMG_NO");
				int productNo = rs.getInt("PRODUCT_NO");
				String productImgName = rs.getString("PRODUCT_IMG_NAME");
				
				piv = new ProductImgVo();
				
				piv.setProductImgNo(productImgNo);
				piv.setProductNo(productNo);
				piv.setProductImgName(productImgName);
				
				list.add(piv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	// 제품 조회 페이지에 좌측 카테고리 가지고 오는 메소드
	public List<CategoryVo> searchCategory(Connection conn) {
		
		PreparedStatement pstmt = null;
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
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	public List<ProductVo> searchSelectedCategoryProduct(int categoryNo, Connection conn, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N') WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryno = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryno);
				
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

	// 카테고리 중 등록순
	public List<ProductVo> pagingCategoryRangeDateO(Connection conn, int categoryNo, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N' ORDER BY CATEGORY_DATE ASC) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryno = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryno);
				
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
	// 카테고리 중 최신순
	public List<ProductVo> pagingCategoryRangeDateN(Connection conn, int categoryNo, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N' ORDER BY P.CATEGORY_DATE DESC) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryno = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryno);
				
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
	// 카테고리 중 가격 낮은 순
	public List<ProductVo> pagingCategoryRangePriceL(Connection conn, int categoryNo, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N' ORDER BY P.PRICE ASC) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryno = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryno);
				
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
	// 카테고리 중 가격 높은 순
	public List<ProductVo> pagingCategoryRangePriceH(Connection conn, int categoryNo, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N' ORDER BY P.PRICE DESC) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			pstmt.setInt(2, startNo);
			pstmt.setInt(3, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryno = rs.getInt("CATEGORY_NO");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setCategoryDate(categoryDate);
				pv.setProductContents(productContents);
				pv.setProductDelete(productDelete);
				pv.setLasteditDate(lasteditDate);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryno);
				
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

	// 페이징
	public int countProductAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE PRODUCT_DELETE = 'N'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	// 페이징
	public int countProductAll(Connection conn, int categoryNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY_NO = ? AND PRODUCT_DELETE = 'N'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryNo);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	}
	// 페이징
	public List<ProductVo> paging(Connection conn, int startNo, int endNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE PRODUCT_DELETE = 'N') WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	public List<ProductVo> pagingRangeDateO(Connection conn, int startNo, int endNo) { // 정렬 등록순

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY CATEGORY_DATE) p) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	public List<ProductVo> pagingRangeDateN(Connection conn, int startNo, int endNo) { // 정렬 최신순
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY CATEGORY_DATE DESC) p) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	public List<ProductVo> pagingRangePriceL(Connection conn, int startNo, int endNo) { // 정렬 가격 낮은 순
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY PRICE) p) WHERE RNUM BETWEEN ? AND ?";
			ProductVo pv = null;
			List<ProductVo> list = new ArrayList<>();
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNo);
				pstmt.setInt(2, endNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int productNo = rs.getInt("PRODUCT_NO");
					String productName = rs.getString("PRODUCT_NAME");
					int price = rs.getInt("PRICE");
					Date categoryDate = rs.getDate("CATEGORY_DATE");
					String productContents = rs.getString("PRODUCT_CONTENTS");
					String productDelete = rs.getString("PRODUCT_DELETE");
					Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	public List<ProductVo> pagingRangePriceH(Connection conn, int startNo, int endNo) { // 정렬 가격 높은 순
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY PRICE DESC) p) WHERE RNUM BETWEEN ? AND ?";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	
	
	// 태그 매치
	public List<ProductVo> tagProductList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT P.*, TK.TAG_NAME "
				+ "FROM PRODUCT P "
				+ "INNER JOIN TAG T ON(P.PRODUCT_NO = T.PRODUCT_NO) "
				+ "INNER JOIN TAG_KEYWORD TK ON(T.TAG_NUMBER = TK.TAG_NUMBER)";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryNo = rs.getInt("CATEGORY_NO");
				String tagName = rs.getString("TAG_NAME");
				
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
				pv.setTagName(tagName);
				
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
	// 정렬 (날짜 등록순)
	public List<ProductVo> searchRangeProductDateO(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY CATEGORY_DATE ASC";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	// 정렬 (날짜 최신순)
	public List<ProductVo> searchRangeProductDateN(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY CATEGORY_DATE DESC";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	// 정렬 (가격 낮은 순)
	public List<ProductVo> searchRangeProductPriceLow(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY PRICE ASC";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	// 정렬 (가격 높은 순)
	public List<ProductVo> searchRangeProductPriceHigh(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_DELETE = 'N' ORDER BY PRICE DESC";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
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
	
	// 정렬 (리뷰 순)

	
/*-------------------------------------제품 등록----------------------------------------*/
	// 카테고리 불러오기
	public List<CategoryVo> registerCategoryList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CATEGORY ORDER BY CATEGORY_NO";
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
	// 태그 불러오기
	public List<TagVo> registerTagList(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TAG_KEYWORD ORDER BY TAG_NUMBER";
		TagVo tv = null;
		List<TagVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int tagNo = rs.getInt("TAG_NUMBER");
				String tagName = rs.getString("TAG_NAME");
				
				tv = new TagVo();
				
				tv.setTagNo(tagNo);
				tv.setTagName(tagName);
				
				list.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
	// 제품 등록
//	public int registerProduct(Connection conn, ProductVo pv) {
//		
//		PreparedStatement pstmt = null;
//		String sql = "INSERT INTO PRODUCT VALUES (SEQ_PRODUCT_NO.NEXTVAL, ?, ?, DEFAULT, ?, DEFAULT, DEFAULT, ?, ?)";
//		int result = 0;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, pv.getProductName());
//			pstmt.setInt(2, pv.getPrice());
//			pstmt.setString(3, pv.getProductContents());
//			pstmt.setInt(4, pv.getInventory());
//			pstmt.setInt(5, pv.getCategoryNo());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

	// 제품 등록
	public int registerProductTag1(Connection conn, ProductVo pv, int tagNo1, int tagNo2, int tagNo3) {
		
		PreparedStatement pstmt = null;
		String sql1 = "INSERT INTO PRODUCT VALUES (SEQ_PRODUCT_NO.NEXTVAL, ?, ?, DEFAULT, ?, DEFAULT, DEFAULT, ?, ?)";
		int result1 = 0;
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, pv.getProductName());
			pstmt.setInt(2, pv.getPrice());
			pstmt.setString(3, pv.getProductContents());
			pstmt.setInt(4, pv.getInventory());
			pstmt.setInt(5, pv.getCategoryNo());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		if(tagNo1 != 0) {
			String sql2 = "INSERT INTO TAG "
					+ "VALUES(?, "
					+ "(SELECT PRODUCT_NO FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p ORDER BY P.PRODUCT_NO DESC) WHERE ROWNUM = 1), "
					+ "'N')";
			
			if(result1 > 0) {
				try {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, tagNo1);
					
					result2 = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
			}
		} else {
			result2 = 1;
		}
		if(tagNo2 != 0) {
			result3 = registerProductTag2(conn, pv, tagNo2);			
		} else {
			result3 = 1;
		}
		if(tagNo3 != 0) {
			result4 = registerProductTag3(conn, pv, tagNo3);			
		} else {
			result4 = 1;
		}
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);
		
		return result2 + result3 + result4;
	}
	public int registerProductTag2(Connection conn, ProductVo pv, int tagNo2) {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TAG VALUES(?, (SELECT PRODUCT_NO FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p ORDER BY P.PRODUCT_NO DESC) WHERE ROWNUM = 1), 'N')";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tagNo2);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int registerProductTag3(Connection conn, ProductVo pv, int tagNo3) {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TAG "
				+ "VALUES(?, "
				+ "(SELECT PRODUCT_NO FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p ORDER BY P.PRODUCT_NO DESC) WHERE ROWNUM = 1), "
				+ "'N')";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tagNo3);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 이미지 등록
	public int registerProductImg(Connection conn, List<ProductImgVo> pImgList) {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PRODUCT_IMG VALUES"
				+ "(SEQ_PRODUCT_IMG_NO.NEXTVAL, "
				+ "(SELECT PRODUCT_NO FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p ORDER BY P.PRODUCT_NO DESC) WHERE ROWNUM = 1), "
				+ "?, "
				+ "SYSDATE, 'N')";
		int result = 0;
		
		for(int i = 0; i < pImgList.size(); i++) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pImgList.get(i).getProductImgName());
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		
		System.out.println("이미지이름 1: " + pImgList.get(0).getProductImgName());
		System.out.println("이미지이름 2: " + pImgList.get(1).getProductImgName());
		return result;
	}

/*-------------------------------------제품 수정----------------------------------------*/
	// 제품 관리 페이지에서 제품 수정시 기존값 가지고 오는 메소드
	public List<ProductVo> updateProductInfo(Connection conn, int updateProuctNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT p.*, TK.TAG_NAME, C.CATEGORY_NAME "
				+ "FROM (SELECT * FROM PRODUCT WHERE PRODUCT_NO = ?) p "
				+ "INNER JOIN CATEGORY C ON (P.CATEGORY_NO = C.CATEGORY_NO)"
				+ "INNER JOIN TAG T ON(P.PRODUCT_NO = T.PRODUCT_NO) "
				+ "INNER JOIN TAG_KEYWORD TK ON(T.TAG_NUMBER = TK.TAG_NUMBER)";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updateProuctNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				Date categoryDate = rs.getDate("CATEGORY_DATE");
				String productContents = rs.getString("PRODUCT_CONTENTS");
				String productDelete = rs.getString("PRODUCT_DELETE");
				Date lasteditDate = rs.getDate("LASTEDIT_DATE");
				int inventory = rs.getInt("INVENTORY");
				int categoryNo = rs.getInt("CATEGORY_NO");
				String tagName = rs.getString("TAG_NAME");
				String categoryName = rs.getString("CATEGORY_NAME");
				
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
				pv.setTagName(tagName);
				pv.setCategoryName(categoryName);
				
				list.add(pv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		if(list.size() == 0) {
			sql = "SELECT p.*, C.CATEGORY_NAME "
					+ "FROM (SELECT * FROM PRODUCT WHERE PRODUCT_NO = ?) p "
					+ "INNER JOIN CATEGORY C ON (P.CATEGORY_NO = C.CATEGORY_NO)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, updateProuctNo);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int productNo = rs.getInt("PRODUCT_NO");
					String productName = rs.getString("PRODUCT_NAME");
					int price = rs.getInt("PRICE");
					Date categoryDate = rs.getDate("CATEGORY_DATE");
					String productContents = rs.getString("PRODUCT_CONTENTS");
					String productDelete = rs.getString("PRODUCT_DELETE");
					Date lasteditDate = rs.getDate("LASTEDIT_DATE");
					int inventory = rs.getInt("INVENTORY");
					int categoryNo = rs.getInt("CATEGORY_NO");
					String categoryName = rs.getString("CATEGORY_NAME");
					
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
					pv.setCategoryName(categoryName);
					
					list.add(pv);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			
		}
		
		return list;
	}
	// 제품 수정 메소드
	public int updateProductTag1(Connection conn, ProductVo pv, int tagNo1, int tagNo2, int tagNo3) {
			
		PreparedStatement pstmt = null;
		String sql1 = "UPDATE PRODUCT "
				+ "SET CATEGORY_NO = ?, "
				+ "PRODUCT_NAME = ?, "
				+ "PRICE = ?, "
				+ "INVENTORY = ?, "
				+ "PRODUCT_CONTENTS = ?,"
				+ "LASTEDIT_DATE = SYSDATE "
				+ "WHERE PRODUCT_NO = ?";
		int result1 = 0;
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, pv.getCategoryNo());
			pstmt.setString(2, pv.getProductName());
			pstmt.setInt(3, pv.getPrice());
			pstmt.setInt(4, pv.getInventory());
			pstmt.setString(5, pv.getProductContents());
			pstmt.setInt(6, pv.getProductNo());
			
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("result1 : " + result1);
		
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		
		// 등록된 태그 삭제하고 밑에서 재등록하는거
		String sql2 = "DELETE FROM TAG WHERE PRODUCT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, pv.getProductNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		if(tagNo1 != 0) {
			String sql3 = "INSERT INTO TAG VALUES(?, ?, 'N')";
			
		if(result1 > 0) {
			try {
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, tagNo1);
				pstmt.setInt(2, pv.getProductNo());
				
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		} else {
			result2 = 1;
		}
		if(tagNo2 != 0) {
			result3 = updateProductTag2(conn, pv, tagNo2);			
		} else {
			result3 = 1;
		}
		if(tagNo3 != 0) {
			result4 = updateProductTag3(conn, pv, tagNo3);			
		} else {
			result4 = 1;
		}
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);
		
		return result2 + result3 + result4;
	}
	

	public int updateProductTag2(Connection conn, ProductVo pv, int tagNo2) {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TAG VALUES(?, ?, 'N')";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tagNo2);
			pstmt.setInt(2, pv.getProductNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int updateProductTag3(Connection conn, ProductVo pv, int tagNo3) {
		
		PreparedStatement pstmt = null;
		String sql =  "INSERT INTO TAG VALUES(?, ?, 'N')";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tagNo3);
			pstmt.setInt(2, pv.getProductNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 제품 이미지 수정
	public int updateProductImg(Connection conn, ProductVo pv, List<ProductImgVo> pImgList) {

		PreparedStatement pstmt = null;
		String sql1 = "DELETE FROM PRODUCT_IMG WHERE PRODUCT_NO = ?";
		String sql2 = "INSERT INTO PRODUCT_IMG VALUES"
				+ "(SEQ_PRODUCT_IMG_NO.NEXTVAL, "
				+ "?, "
				+ "?, "
				+ "SYSDATE, 'N')";
		int result1 = 0;
		int result2 = 0;
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, pv.getProductNo());
			result1 = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		for(int i = 0; i < pImgList.size(); i++) {
			try {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, pv.getProductNo());
				pstmt.setString(2, pImgList.get(i).getProductImgName());
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		}
		System.out.println("이미지이름 1: " + pImgList.get(0).getProductImgName());
		System.out.println("이미지이름 2: " + pImgList.get(1).getProductImgName());
		System.out.println("제품 넘버: " + pv.getProductNo());
		System.out.println("이미지삭제행: " + result1);
		System.out.println("이미지등록행: " + result2);
		
		return result2;
	}
	
	
/*-------------------------------------제품 삭제----------------------------------------*/
	public int deleteProduct(Connection conn, int deleteProuctNo) {
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE PRODUCT SET PRODUCT_DELETE = 'Y' WHERE PRODUCT_NO = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deleteProuctNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

/*-------------------------------------장바구니----------------------------------------*/

//	장바구니를 먼저 조회하는 쿼리 실행 후 있는 장바구니면 그대로 그 장바구니 반환하고 없으면 만든다음에 반환
	public ShoppingBasketVo shoppingBasket(Connection conn, MemberVo mv) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoppingBasketVo sv = null;
		String sql = "SELECT * FROM SHOPPINGBAG WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mv.getMemberNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int shoppingBasketNo = rs.getInt("SHOPPINGBAG_NO");
				int memberNo = rs.getInt("USER_NO");
				
				sv = new ShoppingBasketVo();
				
				sv.setShoppingBasketNo(shoppingBasketNo);
				sv.setMemberNo(memberNo);
				
			} else {
				sv = shoppingBasketInsert(conn, mv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return sv;
	}
	// 기존 장바구니가 없으면 장바구니 만들고 셀렉트해서 장바구니 반환
	private ShoppingBasketVo shoppingBasketInsert(Connection conn, MemberVo mv) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		ShoppingBasketVo sv = null;
		String sql = "INSERT INTO SHOPPINGBAG VALUES(SEQ_SHOPPINGBAG_NO.NEXTVAL, ?)";
		String sql1 = "SELECT * FROM SHOPPINGBAG WHERE USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mv.getMemberNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		if(result == 1) {
			try {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setInt(1, mv.getMemberNo());
				rs = pstmt.executeQuery();
				
				rs.next();
				
				int shoppingBasketNo = rs.getInt("SHOPPINGBAG_NO");
				int memberNo = rs.getInt("USER_NO");
				
				sv = new ShoppingBasketVo();
				
				sv.setShoppingBasketNo(shoppingBasketNo);
				sv.setMemberNo(memberNo);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		}
		
		return sv;
	}
	// 장바구니에 이미 있는 제품인지 확인
	public int checkMyShoppingBasket(Connection conn, ShoppingBasketVo sv, ProductVo pv) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "SELECT * FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ? AND PRODUCT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sv.getShoppingBasketNo());
			pstmt.setInt(2, pv.getProductNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	// 가져온 장바구니에 제품 넣기
	public List<ShoppingBasketProVo> putShoppingBasket(Connection conn, ShoppingBasketVo sv, ProductVo pv) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		List<ShoppingBasketProVo> list = new ArrayList<>();
		
		// 이미 존재하는 제품일수도 있는데... 삭제하고? --> 셀렉트해서 0개행이면 바로 인서트, 1개행이면 딜리트 후 인서트
		String sql = "SELECT * FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ? AND PRODUCT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sv.getShoppingBasketNo());
			pstmt.setInt(2, pv.getProductNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result == 1) {
			String sql1 = "DELETE FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ? AND PRODUCT_NO = ?";
			
			try {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setInt(1, sv.getShoppingBasketNo());
				pstmt.setInt(2, pv.getProductNo());
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			list = insertShoppingBasket(conn, sv, pv);
		} else {
			list = insertShoppingBasket(conn, sv, pv);
		}
		return list;
	}

	// 지금 장바구니에 추가한 상품 인서트하고 그 장바구니별제품 전부 셀렉트에서 리스트로 반환
	private List<ShoppingBasketProVo> insertShoppingBasket(Connection conn, ShoppingBasketVo sv, ProductVo pv) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO SHOPPINGBAG_PRO VALUES (?, ?, ?)";
		int result = 0;
		ShoppingBasketProVo spv = null;
		List<ShoppingBasketProVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sv.getShoppingBasketNo());
			pstmt.setInt(2, pv.getProductNo());
			pstmt.setInt(3, pv.getInventory());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result == 1) {
			String sql1 = "SELECT * FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ?";
			
			try {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setInt(1, sv.getShoppingBasketNo());
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int shoppingbagNo = rs.getInt("SHOPPINGBAG_NO");
					int productNo = rs.getInt("PRODUCT_NO");
					int inventory = rs.getInt("INVENTORY");
					
					spv = new ShoppingBasketProVo();
					
					spv.setShoppingBasketNo(shoppingbagNo);
					spv.setProductNo(productNo);
					spv.setInventory(inventory);
					
					list.add(spv);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
		}
		
		return list;
	}

	// 장바구니에 담긴 총 상품 금액 불러오기
	public int totalProductPrcie(Connection conn, ShoppingBasketVo sv) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SP.SHOPPINGBAG_NO, SUM(P.PRICE * SP.INVENTORY) SUM "
				+ "FROM SHOPPINGBAG_PRO SP "
				+ "INNER JOIN PRODUCT P ON(SP.PRODUCT_NO = P.PRODUCT_NO) "
				+ "GROUP BY SP.SHOPPINGBAG_NO";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int shoppingbagNo = rs.getInt("SHOPPINGBAG_NO");
				int sum = rs.getInt("SUM");
				
				if(sv.getShoppingBasketNo() == shoppingbagNo) {
					result = sum;
				}
			}
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}

	// 장바구니에 담긴 상푸 삭제 후 장바구니 제품 리턴
	public List<ShoppingBasketProVo> deleteShoppingBasket(Connection conn, ShoppingBasketProVo sbp) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ? AND PRODUCT_NO = ?";
		String sql1 = "SELECT * FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ?";
		ShoppingBasketProVo sb = null;
		List<ShoppingBasketProVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sbp.getShoppingBasketNo());
			pstmt.setInt(2, sbp.getProductNo());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, sbp.getShoppingBasketNo());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int shoppingBasketNo = rs.getInt("SHOPPINGBAG_NO");
				int productNo = rs.getInt("PRODUCT_NO");
				int inventory = rs.getInt("INVENTORY");
				
				sb = new ShoppingBasketProVo();
				
				sb.setShoppingBasketNo(shoppingBasketNo);
				sb.setProductNo(productNo);
				sb.setInventory(inventory);
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	// 장바구니 안에 전체 제품 삭제
	public int deleteAllShoppingBasket(Connection conn, int shoppingBasketNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "DELETE FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shoppingBasketNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	// 장바구니 안에 제품 수량 변경 후 제품들 리턴
	public List<ShoppingBasketProVo> updateShoppingBasket(Connection conn, ShoppingBasketProVo sbp) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE SHOPPINGBAG_PRO SET INVENTORY = ? WHERE SHOPPINGBAG_NO = ? AND PRODUCT_NO = ?";
		String sql1 = "SELECT * FROM SHOPPINGBAG_PRO WHERE SHOPPINGBAG_NO = ?";
		ShoppingBasketProVo sb = null;
		List<ShoppingBasketProVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sbp.getInventory());
			pstmt.setInt(2, sbp.getShoppingBasketNo());
			pstmt.setInt(3, sbp.getProductNo());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, sbp.getShoppingBasketNo());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int shoppingBasketNo = rs.getInt("SHOPPINGBAG_NO");
				int productNo = rs.getInt("PRODUCT_NO");
				int inventory = rs.getInt("INVENTORY");
				
				sb = new ShoppingBasketProVo();
				
				sb.setShoppingBasketNo(shoppingBasketNo);
				sb.setProductNo(productNo);
				sb.setInventory(inventory);
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	
/*-------------------------------------태그 검색 결과----------------------------------------*/
	public List<ProductVo> tagSearchProduct(Connection conn, String tagName) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM "
				+ "( "
				+ "SELECT * FROM PRODUCT P "
				+ "INNER JOIN TAG T ON(P.PRODUCT_NO = T.PRODUCT_NO) "
				+ "INNER JOIN TAG_KEYWORD TK ON(T.TAG_NUMBER = TK.TAG_NUMBER) "
				+ ") "
				+ "WHERE TAG_NAME = ? AND TAG_DELETE = 'N' AND PRODUCT_DELETE = 'N'";
		ProductVo pv = null;
		List<ProductVo> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tagName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				int inventory = rs.getInt("INVENTORY");
				int categoryNo = rs.getInt("CATEGORY_NO");
				String tag = rs.getString("TAG_NAME");
				
				pv = new ProductVo();
				
				pv.setProductNo(productNo);
				pv.setProductName(productName);
				pv.setPrice(price);
				pv.setInventory(inventory);
				pv.setCategoryNo(categoryNo);
				pv.setTagName(tag);
				
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

	

	





	

	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
