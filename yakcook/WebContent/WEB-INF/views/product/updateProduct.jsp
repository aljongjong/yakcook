<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="wrap">
        <div class="categoryHorizon">
            <div class="categoryHorizon_title">제품 수정</div>
        </div>

        <div class="register_product">
            <form action="updateProduct" method="POST" id="registerForm" enctype="application/x-www-form-urlencoded">
                <input type="hidden" name="productNo" value="${updateProuctNo}"> <!-- 업데이트를 위해 제품 번호 날려줌 -->
                <table>
                    <tr>
                        <th>카테고리</th>
                        <td>
                        	<span>기존 카테고리 : </span>
                        	<c:forEach items="${updateProductInfo}" var="u" begin="0" end="0">
                        		<span>${u.categoryName}</span>
                        	</c:forEach>
                            <select name="productCategory" id="productCategory">
                                <!-- 카테고리 테이블에 있는 카테고리 불러오기 -->
	                            <% int c = 1; %>
                                <c:forEach items="${categoryList}" var="c">
                                	<option value="<%=c%>">${c.categoryName}</option>
                                	<% c++; %>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>태그 등록</th>
                        <td>
                            <!-- 태그 테이블에 있는 태그 불러오기 -->
                            <span>기존 태그 : </span>
                            <c:forEach items="${updateProductInfo}" var="u">
                  
                        		<span>${u.tagName}</span>
                        	</c:forEach>
                            <select name="productTag1" id="productTag1">
	                            <% int t1 = 1; %>
	                           	<option value="0">----</option>
                                <c:forEach items="${tagList}" var="t">
	                                	<option value="<%=t1%>">${t.tagName}</option>
	                                	<% t1++; %>
                                </c:forEach>
                            </select>
                            <select name="productTag2" id="productTag2">
	                            <% int t2 = 1; %>
	                           	<option value="0">----</option>
                                <c:forEach items="${tagList}" var="t">
	                                	<option value="<%=t2%>">${t.tagName}</option>
	                                	<% t2++; %>
                                </c:forEach>
                            </select>
                            <select name="productTag3" id="productTag3">
	                            <% int t3 = 1; %>
	                           	<option value="0">----</option>
                                <c:forEach items="${tagList}" var="t">
	                                	<option value="<%=t3%>">${t.tagName}</option>
	                                	<% t3++; %>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>제품명</th>
                        <td><input type="text" name="productName" id="productName" required value="${updateProductInfo.get(0).getProductName()}"></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><input type="number" name="productPrice" id="productPrice" required min="0" value="${updateProductInfo.get(0).getPrice()}"></td>
                    </tr>
                    <tr>
                        <th>재고 수량</th>
                        <td><input type="number" name="productAmount" id="productAmount" required min="0" value="${updateProductInfo.get(0).getInventory()}"></td>
                    </tr>
                    <tr>
                        <th>제품 설명</th>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="productContents" id="productContents" cols="120" rows="30" required style="resize: none;">${updateProductInfo.get(0).getProductContents()}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>제품 이미지</th>
                        <td>
                            <input type="file" name="productImg1" class="productImg">
                            <input type="file" name="productImg2" class="productImg">
                            <input type="file" name="productImg3" class="productImg">
                        </td>
                    </tr>
                    <tr>
                        <th colspan="2" style="border: none;">
                            <button type="submit" class="rp_btn">
                                <span>제품 수정 </span>
                                <i class="fas fa-tools"></i>
                            </button>
                            <button class="rp_btn rp_cancle">
                                <span><a href="manageProduct" style="text-decoration:none; color:rgb(250, 174, 88);">돌아 가기</span>
                                <i class="far fa-window-close"></i>
                            </button>
                        </th>
                    </tr>
                    
                </table>


            </form>
        </div>
        
        <div></div>
    </div>
</body>
</html>