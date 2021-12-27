<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <form action="updateProduct" method="POST" id="registerForm" enctype="multipart/form-data">
                <table>
                    <tr>
                        <th>카테고리</th>
                        <td>
                            <select name="productCategory" id="productCategory">
                                <!-- 카테고리 테이블에 있는 카테고리 불러오기 -->
                                <option value="category1" selected="selected">기존카테고리</option>
                                <option value="category2">category2</option>
                                <option value="category3">category3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>태그 등록</th>
                        <td>
                            <!-- 태그 테이블에 있는 태그 불러오기 -->
                            <select name="productTag1" id="productTag1">
                                <option value="tag1" selected="selected">기존태그1</option>
                            </select>
                            <select name="productTag2" id="productTag2" selected="selected">
                                <option value="tag2">기존태그2</option>
                            </select>
                            <select name="productTag3" id="productTag3" selected="selected">
                                <option value="tag3">기존태그3</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>제품명</th>
                        <td><input type="text" name="productName" id="productName" required value="기존 제품명"></td>
                    </tr>
                    <tr>
                        <th>가격</th>
                        <td><input type="number" name="productPrice" id="productPrice" required min="0" value="10000"></td>
                    </tr>
                    <tr>
                        <th>재고 수량</th>
                        <td><input type="number" name="productAmount" id="productAmount" required min="0" value="999"></td>
                    </tr>
                    <tr>
                        <th>제품 설명</th>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="productContent" id="productContent" cols="120" rows="30" required style="resize: none;">기존 설명</textarea>
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
                                <span>취소 하기 </span>
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