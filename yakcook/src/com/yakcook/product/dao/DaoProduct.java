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
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.TagVo;

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
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p WHERE CATEGORY_NO = ?) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT COUNT(*) FROM PRODUCT";
		
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
		String sql = "SELECT COUNT(*) FROM PRODUCT WHERE CATEGORY_NO = ?";
		
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
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM PRODUCT p) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT ORDER BY CATEGORY_DATE) p) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT ORDER BY CATEGORY_DATE DESC) p) WHERE RNUM BETWEEN ? AND ?";
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
			String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT ORDER BY PRICE) p) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, p.* FROM (SELECT * FROM PRODUCT ORDER BY PRICE DESC) p) WHERE RNUM BETWEEN ? AND ?";
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
		String sql = "SELECT * FROM PRODUCT ORDER BY CATEGORY_DATE ASC";
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
		String sql = "SELECT * FROM PRODUCT ORDER BY CATEGORY_DATE DESC";
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
		String sql = "SELECT * FROM PRODUCT ORDER BY PRICE ASC";
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
		String sql = "SELECT * FROM PRODUCT ORDER BY PRICE DESC";
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
//		String sql = "INSERT INTO PRODUCT VALUES (SEQ_PRODUCTNO.NEXTVAL, ?, ?, DEFAULT, ?, DEFAULT, DEFAULT, ?, ?)";
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

	// 태그 등록
	public int registerProductTag1(Connection conn, ProductVo pv, int tagNo1, int tagNo2, int tagNo3) {
		
		PreparedStatement pstmt = null;
		String sql1 = "INSERT INTO PRODUCT VALUES (SEQ_PRODUCTNO.NEXTVAL, ?, ?, DEFAULT, ?, DEFAULT, DEFAULT, ?, ?)";
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
				+ "PRODUCT_CONTENTS = ? "
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

	

	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
