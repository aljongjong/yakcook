<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>제품 관리</title>
        <link rel="stylesheet" href="/yakcook/resources/css/product/searchProduct.css">
        <script src="https://kit.fontawesome.com/77be500183.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="wrap">
            <div class="category">
                <div class="category_title">제품 관리</div>
                <div class="category_content">
                    <ul>
                        <!-- 반복문, 카테고리 테이블에서 데이터 가져옴 -->
                        <li><a href="#" style="font-weight: 700;">카테고리1<i class="far fa-check-circle"></i></a></li>
                        <li><a href="#">카테고리2</a></li>
                        <li><a href="#">카테고리3</a></li>
                        <li><a href="#">카테고리4</a></li>
                        <li><a href="#">카테고리5</a></li>
                        <li><a href="#">카테고리6</a></li>
                        <li><a href="#">카테고리7</a></li>
                        <li><a href="#">카테고리8</a></li>
                        <li><a href="#">카테고리9</a></li>
                        <li><a href="#">카테고리10</a></li>
                    </ul>
                </div>
            </div>
            <div class="products">
                <div class="p_title_range">
                    <div class="p_title">
                        <a href="#">전체상품 or 선택카테고리</a>
                    </div>
                    
                    <!-- 제품 등록 삭제 버튼 -->
                    <div class="p_register">
                        <a href="#">
                            <span>제품 등록 </span>
                            <i class="fas fa-edit"></i>
                        </a>
                    </div>
                    <div class="p_delete">
                        <a href="#">
                            <span>선택 제품 삭제 </span>
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </div>
                    <div class="p_range">
                        <label for="panel-label">정렬 : </label>
                        <select name="range" id="">
                            <option value="1" selected="selected">제품 번호 순</option>
                            <option value="2">제품 이름 순</option>
                            <option value="3">가격 높은 순</option>
                            <option value="4">가격 낮은 순</option>
                            <option value="5">최근 등록 순</option>
                            <option value="6">최근 수정 순</option>
                        </select>
                    </div>
                </div>


                <!-- 제품관리 헤더 -->
                <div class="manage_product mp_header">
                    <div class="mp_photo">사진
                    </div>
                    <div class="mp_no">제품 번호</div>
                    <div class="mp_name">이름</div>
                    <div class="mp_price">가격</div>
                    <div class="mp_tag">등록된 태그</div>
                    <div class="mp_register_date">등록 일자</div>
                    <div class="mp_update_date">수정 일자</div>
                    <div class="mp_update">수정</div>
                    <div class="mp_check">선택</div>
                </div>
                
                <!-- 여기부터 디비접근 반복문 -->
                <div class="manage_product">
                    <div class="mp_photo">
                        <a href="#"><img src="35.jpeg"></a>
                    </div>
                    <div class="mp_no">773210</div>
                    <div class="mp_name">LIFE, 비타민D3</div>
                    <div class="mp_price">₩50,000</div>
                    <div class="mp_tag">태그1, 태그2, 태그3</div>
                    <div class="mp_register_date">22.01.01</div>
                    <div class="mp_update_date">22.01.05</div>
                    
                    <div class="mp_update_button">
                        <a href="#"><span>수정하기 </span><i class="fas fa-tools"></i></a>
                    </div>

                    <div class="mp_check"><input type="checkbox" name="mp_check" id="mp_check"></div>
                </div>

                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
                <div class="manage_product"></div>
    
                <!-- fas아이콘 한페이지씩 이동 , 선택 페이지 넘버 fontweight 900, ...뒤 마지막 페이지 넘버 나오게, 선택 페이지 앞뒤 넘버 2개씩 보이게 하기  -->
                <div class="paging">
                    <ul>
                        <li>
                            <a href="#">
                                <span>
                                    <i class="fas fa-chevron-circle-left"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="circle"></span>
                                <span style="font-weight: 900;">1</span>
                            </a>
                        </li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li>...</li>
                        <li>
                            <a href="#">10</a>
                        </li>
                        <li>
                            <a href="#">
                                <span>
                                    <i class="fas fa-chevron-circle-right"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            
            
        
        </div>
    </body>
</html>