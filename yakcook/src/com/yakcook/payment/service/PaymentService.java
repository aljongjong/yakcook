package com.yakcook.payment.service;
import static com.yakcook.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import static com.yakcook.common.JDBCTemplate.*;

import com.yakcook.payment.dao.PaymentDao;
import com.yakcook.payment.vo.PaymentVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;

public class PaymentService {
	//입력한 주문정보를 DB에 넣는 서비스메소드
	public int insertOrder(PaymentVo p) {
		Connection conn = getConnection();
		return new PaymentDao().insertOrder(conn,p);
	}



	public int paymentComplate() {
		Connection conn = getConnection();
		return new PaymentDao().updateComplate(conn);
	}



	public List<ProductVo> selectList(String productNo) {
		Connection conn = getConnection();
		int no = Integer.parseInt(productNo); 
		return new PaymentDao().getProductList(conn , no);
	}



	public List<ShoppingBasketProVo> selectShoppingBag(String shoppingBagNo) {
		Connection conn = getConnection();
		int no = Integer.parseInt(shoppingBagNo);
		return new PaymentDao().getShoppingBagList(conn, no);
	}



	public int paymentCard() {
		Connection conn = getConnection();
		return new PaymentDao().updateMethodCard(conn);
	}
	
	
	
}
	
