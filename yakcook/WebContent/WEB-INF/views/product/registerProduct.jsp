<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 등록</title>
<link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
<script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="wrap">
        <div class="categoryHorizon">
            <div class="categoryHorizon_title">제품 등록</div>
        </div>

        <div class="register_product">
        
            <form action="registerProduct" method="POST" id="registerForm" enctype="application/x-www-form-urlencoded">
                <table>
                    <tr>
                        <th>카테고리</th>
                        <td>
                            <select name="productCategory" id="productCategory" required="required">
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
                        <td><input type="text" name="productName" id="productName" required></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><input type="number" name="productPrice" id="productPrice" required min="0"></td>
                    </tr>
                    <tr>
                        <th>재고 수량</th>
                        <td><input type="number" name="productAmount" id="productAmount" required min="0"></td>
                    </tr>
                    <tr>
                        <th>제품 설명</th>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="productContents" id="productContents" cols="120" rows="30" required style="resize: none;"></textarea>
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
                                <span>제품 등록 </span>
                                <i class="fas fa-edit"></i>
                            </button>
                            <button class="rp_btn rp_cancle">
                                <span><a href="manageProduct" style="text-decoration:none; color:rgb(250, 174, 88);">돌아 가기</a></span>
                                <i class="far fa-window-close"></i>
                            </button>
                        </th>
                    </tr>
                </table>

            </form>
        </div>
        
    </div>
</body>
</html>