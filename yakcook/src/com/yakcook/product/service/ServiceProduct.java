package com.yakcook.product.service;

import static com.yakcook.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.yakcook.product.dao.DaoProduct;
import com.yakcook.product.vo.CategoryVo;
import com.yakcook.product.vo.MemberVo;
import com.yakcook.product.vo.ProductImgVo;
import com.yakcook.product.vo.ProductVo;
import com.yakcook.product.vo.ShoppingBasketProVo;
import com.yakcook.product.vo.ShoppingBasketVo;
import com.yakcook.product.vo.TagVo;

public class ServiceProduct {

/*-------------------------------------제품 조회----------------------------------------*/
	// 제품 조회 페이지 제품 이미지 가지고 오는 메소드
	public List<ProductImgVo> searchAllProductImg() {
		
		Connection conn = getConnection();
		
		List<ProductImgVo> list = new DaoProduct().searchAllProductImg(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}
	
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
	public List<ProductVo> searchSelectedCategoryProduct(int categoryNo, String currentPage) {
		
		Connection conn = getConnection();
		
		int p = Integer.parseInt(currentPage);
		int boardLimit = 16;
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<ProductVo> list = new DaoProduct().searchSelectedCategoryProduct(categoryNo, conn, startNo, endNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}
	public List<ProductVo> searchSelectedCategoryProductM(int categoryNo, String currentPage) {
		
		Connection conn = getConnection();
		
		int p = Integer.parseInt(currentPage);
		int boardLimit = 13;
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<ProductVo> list = new DaoProduct().searchSelectedCategoryProduct(categoryNo, conn, startNo, endNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}

	// 맥스 페이지
	public int maxPage() {
		
		Connection conn = getConnection();
		
		int totalBoardCount = new DaoProduct().countProductAll(conn);
		int boardLimit = 16;
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return maxPage;
	}
	public int maxPageM() {
		
		Connection conn = getConnection();
		
		int totalBoardCount = new DaoProduct().countProductAll(conn);
		int boardLimit = 13;
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return maxPage;
	}

	public int maxPage(int categoryNo) {
		
		Connection conn = getConnection();
		
		int totalBoardCount = new DaoProduct().countProductAll(conn, categoryNo);
		int boardLimit = 16;
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return maxPage;
	}
	public int maxPageM(int categoryNo) {
		
		Connection conn = getConnection();
		
		int totalBoardCount = new DaoProduct().countProductAll(conn, categoryNo);
		int boardLimit = 13;
		int maxPage = 0;
		
		maxPage = totalBoardCount / boardLimit;
		if(totalBoardCount % boardLimit != 0) {
			maxPage++;
		}
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return maxPage;
	}

	public List<ProductVo> nextPageList(String currentPage) {
		
		Connection conn = getConnection();
		
		int p = Integer.parseInt(currentPage);
		int boardLimit = 16;
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<ProductVo> pagingList = new DaoProduct().paging(conn, startNo, endNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return pagingList;
	}
	public List<ProductVo> nextPageListRange(String currentPage, int range) { // 정렬 추가
		
		Connection conn = getConnection();
		
		int p = Integer.parseInt(currentPage);
		int boardLimit = 16;
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<ProductVo> pagingList = new ArrayList<>();
		
		if(range == 1) { // 등록순
			pagingList = new DaoProduct().pagingRangeDateO(conn, startNo, endNo);			
		} else if(range == 2) { // 최신순
			pagingList = new DaoProduct().pagingRangeDateN(conn, startNo, endNo);						
		} else if(range == 3) { // 가격 낮은 순
			pagingList = new DaoProduct().pagingRangePriceL(conn, startNo, endNo);									
		} else if(range == 4) { // 가격 높은 순
			pagingList = new DaoProduct().pagingRangePriceH(conn, startNo, endNo);												
		}
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return pagingList;
	}
	public List<ProductVo> nextPageListM(String currentPage) { // manageProduct 페이지 메소드
		
		Connection conn = getConnection();
		
		int p = Integer.parseInt(currentPage);
		int boardLimit = 13;
		int endNo = p * boardLimit;
		int startNo = endNo - boardLimit + 1;
		
		List<ProductVo> pagingList = new DaoProduct().paging(conn, startNo, endNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return pagingList;
	}

	// 태그 매치
	public List<ProductVo> tagProductList() {
		
		Connection conn = getConnection();
		
		List<ProductVo> tagProductList = new DaoProduct().tagProductList(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		return tagProductList;
	}

	// 정렬
	public List<ProductVo> searchRangeProduct(int range) {
		
		Connection conn = getConnection();
		List<ProductVo> list = new ArrayList<>();
		if(range == 1) {
			list = new DaoProduct().searchRangeProductDateO(conn);
		} else if(range == 2) {
			list = new DaoProduct().searchRangeProductDateN(conn);	
		} else if(range == 3) {
			list = new DaoProduct().searchRangeProductPriceLow(conn);
		} else if(range == 4) {
			list = new DaoProduct().searchRangeProductPriceHigh(conn);
		} 
//		else {
//			list = new DaoProduct().searchRangeProductReview(conn);
//		} 리뷰 보류 머리아퍼~~~~~~~~~~~~~~
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;

	}
/*-------------------------------------제품 등록----------------------------------------*/

	// 카테고리 불러오기
	public List<CategoryVo> registerCategoryList() {
		
		Connection conn = getConnection();
		List<CategoryVo> list = new DaoProduct().registerCategoryList(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}

	// 태그 불러오기
	public List<TagVo> registerTagList() {
		
		Connection conn = getConnection();
		List<TagVo> list = new DaoProduct().registerTagList(conn);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}
	

	// 제품, 태그 등록
	public int registerProductTag(ProductVo pv, int tagNo1, int tagNo2, int tagNo3) {
		
		Connection conn = getConnection();
		
		int result =  new DaoProduct().registerProductTag1(conn, pv, tagNo1, tagNo2, tagNo3);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		System.out.println("result : " + result);
		return result;
	}
	
	// 제품 이미지 등록 메소드
	public int registerProductImg(List<ProductImgVo> pImgList) {
		
		Connection conn = getConnection();
		
		int result = new DaoProduct().registerProductImg(conn, pImgList);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}
/*-------------------------------------제품 수정----------------------------------------*/
	// 제품 관리 페이지에서 제품 수정 페이지 이동시 기존값 가져오는 메소드
	public List<ProductVo> updateProductInfo(int updateProuctNo) {
		
		Connection conn = getConnection();
		
		List<ProductVo> list = new DaoProduct().updateProductInfo(conn, updateProuctNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}

	// 제품 수정 메소드
	public int updateProductTag(ProductVo pv, int tagNo1, int tagNo2, int tagNo3) {
		
		Connection conn = getConnection();
		
		int result =  new DaoProduct().updateProductTag1(conn, pv, tagNo1, tagNo2, tagNo3);
		
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		
		return result;
	}
	// 제품 이미지 수정
	public int updateProductImg(ProductVo pv, List<ProductImgVo> pImgList) {
		
		Connection conn = getConnection();
		
		int result = new DaoProduct().updateProductImg(conn, pv, pImgList);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}
/*-------------------------------------제품 삭제----------------------------------------*/
	public int deleteProduct(int deleteProuctNo) {

		Connection conn = getConnection();
		
		int result = new DaoProduct().deleteProduct(conn, deleteProuctNo);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}
/*-------------------------------------장바구니----------------------------------------*/
	
	// 기존 회원 장바구니가 있으면 기존거 반환, 없으면 생성하고 반환 하기
	public ShoppingBasketVo shoppingBasket(MemberVo mv) {
		
		Connection conn = getConnection();
		
		ShoppingBasketVo sv = new DaoProduct().shoppingBasket(conn, mv);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		return sv;
	}
	// 장바구니에 이미 있는 제품인지 확인
	public int checkMyShoppingBasket(ShoppingBasketVo sv, ProductVo pv) {
		
		Connection conn = getConnection();
		
		int result = new DaoProduct().checkMyShoppingBasket(conn, sv, pv);
		
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}
	
	// 가져온 장바구니에 제품 넣기
	public List<ShoppingBasketProVo> putShoopingBasket(ShoppingBasketVo sv, ProductVo pv) {
		
		Connection conn = getConnection();
		
		List<ShoppingBasketProVo> list = new DaoProduct().putShoopingBasket(conn, sv, pv);
		
		try {
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return list;
	}

	

	
	


	

	
	
	
}
