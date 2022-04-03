# 👾 제품 관련 주요 로직

## 제품 조회 
### <카테고리 별/정렬 조회>
```java
  // 제품 이미지 불러오기
  List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
  req.setAttribute("productImgList", piList);

  // 제품 조회 페이지 좌측 카테고리 불러오기
  List<CategoryVo> cList = new ServiceProduct().searchCategory();
  req.setAttribute("categoryList", cList);

  // 제품 조회 페이지 처음 전체 제품 불러오기
  List<ProductVo> pList = new ServiceProduct().searchAllProduct();
  req.setAttribute("allProductList", pList);

  // 카테고리 선택시 선택 카테고리 제품만 불러오기
  if(req.getParameter("categoryNo") != null) {
    String currentPage = req.getParameter("currentPage");
    if(currentPage == null) {
      currentPage = "1";
    }
    int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
    List<ProductVo> cpList = new ServiceProduct().searchSelectedCategoryProduct(categoryNo, currentPage);
    req.setAttribute("categoryNo", categoryNo);
    req.setAttribute("categoryProductList", cpList);
  }
```

### <제품 상세 정보 페이지>
```java

```

## 제품 관리 
### <제품 조회, 등록, 수정, 삭제>
```java

```


## 태그 검색 
### <제품별 등록 태그 검색>
```java

```

## 장바구니
```java

```
