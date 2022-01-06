package com.yakcook.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;

import com.sun.net.httpserver.Authenticator.Result;
import com.yakcook.payment.vo.PaymentVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.review.vo.ReviewListVo;

public class PaymentDao {

	// 입력한 주문정보(주문번호, 이름 , 휴대폰 , 주소 , 배송메세지)를 DB에 저장하는 메소드
	public int insertOrder(Connection conn, PaymentVo p) {

		String sql = "INSERT INTO ORDER_INFO(ORDER_NO , USER_ID , ORDER_NAME, ORDER_PHONE , POST_NO , ADDRESS ,DETAILADDRESS,EXTRAADDRESS,MEMO_OPTION,INPUT_MEMO,ORDER_DATE , COMPLEATE) VALUES(SEQ_ORDER.NEXTVAL, ? ,  ? , ? , ? , ? ,  ? ,  ? ,  ? , ? ,SYSDATE , ? )";
		PreparedStatement pstmt = null;

		int rs = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getUserId().trim());
			pstmt.setString(2, p.getOrder());
			pstmt.setString(3, p.getPhone1() + p.getPhone2() + p.getPhone3());
			pstmt.setString(4, p.getPostcode());
			pstmt.setString(5, p.getAddress());
			pstmt.setString(6, p.getDetailaddress());
			pstmt.setString(7, p.getExtra());
			pstmt.setString(8, p.getMemo_option());
			pstmt.setString(9, p.getInput_memo());
			pstmt.setString(10, "N");
			rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			commit(conn);
			close(conn);

		}
		return rs;
	}

	public int updateComplate(Connection conn) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE  ORDER_INFO SET COMPLEATE =  'Y', STATUS ='결제완료' WHERE ORDER_NO = (SELECT ORDER_NO FROM (SELECT * FROM ORDER_INFO ORDER BY ORDER_NO DESC) WHERE ROWNUM =1)";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}

		return rs;
	}

	public List<ProductVo> getProductList(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List productList = new ArrayList<ProductVo>();
		ProductVo p = null;
		String sql = "SELECT PRODUCT_NAME , PRICE FROM PRODUCT WHERE PRODUCT_NO =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				p = new ProductVo();
				
				
				p.setProductName(productName);
				p.setPrice(price);
			

				productList.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}
		return productList;
	}

	public List<ProductVo> getShoppingBagList(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List shoppingBagList = new ArrayList<ProductVo>();
		ProductVo s = null;

		String sql = "SELECT P.PRODUCT_NAME, P.PRICE , S.INVENTORY ,P.PRICE*S.INVENTORY FROM PRODUCT P, SHOPPINGBAG_PRO S "
				+ "WHERE P.PRODUCT_NO = S.PRODUCT_NO AND SHOPPINGBAG_NO =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String productName = rs.getString("PRODUCT_NAME");
				int price = rs.getInt("PRICE");
				int inventory = rs.getInt("INVENTORY");
				int productSum = rs.getInt("P.PRICE*S.INVENTORY");

				s = new ProductVo();

				s.setProductName(productName);
				s.setPrice(price);
				s.setInventory(inventory);
				s.setProductSum(productSum);
				shoppingBagList.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
		}

		return shoppingBagList;
	}

	public int updateMethodCard(Connection conn) {
		PreparedStatement pstmt = null;
		int rs = 0;

		String sql = "UPDATE ORDER_INFO SET PAYMETHOD = '카드' WHERE ORDER_NO = (SELECT ORDER_NO FROM (SELECT * FROM ORDER_INFO ORDER BY ORDER_NO DESC) WHERE ROWNUM =1)";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}

		return rs;
	}

	public int updateMethodAccount(Connection conn) {
		PreparedStatement pstmt = null;
		int rs = 0;
		
		String sql = "UPDATE ORDER_INFO SET PAYMETHOD = '계좌이체' WHERE ORDER_NO = (SELECT ORDER_NO FROM (SELECT * FROM ORDER_INFO ORDER BY ORDER_NO DESC) WHERE ROWNUM =1)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			commit(conn);
			close(conn);
			close(pstmt);
		}
		
		return rs;
	}
}