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
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// 총 금액 변경 ajax
	int dpPrice = Integer.parseInt(req.getParameter("price"));	
	int dpAmount = Integer.parseInt(req.getParameter("amount"));

	int totalPrice = dpPrice * dpAmount;
	int totalPriceD = totalPrice + 2500;
	if(totalPrice >= 100000) {
		resp.getWriter().print(totalPrice);	
	} else {
		resp.getWriter().print(totalPriceD);	
	}

}


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// 제품 이미지 불러오기
	List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
	req.setAttribute("productImgList", piList);

	// 제품 조회 페이지에서 제품 이름 클릭시 제품 상세 페이지 이동하기
	String productNo = req.getParameter("productNo");
	String price = req.getParameter("price");
	String categoryDate = req.getParameter("categoryDate");
	String productContents = req.getParameter("productContents");
	String productDelete = req.getParameter("productDelete");
	String lasteditDate = req.getParameter("lasteditDate");
	String inventory = req.getParameter("inventory");
	String categoryNo = req.getParameter("categoryNo");
	String productName = req.getParameter("productName");

	ProductVo pv = new ProductVo();
	pv.setProductNo(Integer.parseInt(productNo));
	pv.setPrice(Integer.parseInt(price));
	pv.setProductContents(productContents);
	pv.setInventory(Integer.parseInt(inventory));
	pv.setCategoryNo(Integer.parseInt(categoryNo));
	pv.setProductName(productName);

	req.setAttribute("detailsProduct", pv);

	req.getRequestDispatcher("/WEB-INF/views/product/detailsProduct.jsp").forward(req, resp);
}
```

## 제품 관리 
### <제품 조회, 등록, 수정, 삭제>
```java
// 다중 파일 업로드
List<ProductImgVo> pImgList = new ArrayList<>();

Collection<Part> parts = req.getParts(); // 모든 part들을 가져옴
ProductImgVo pImg = null;

if(resultTag == 3) {
	for(Part file : parts) {
		if(!file.getName().equals("f")) continue; // name이 f인 경우에 실행

		// 사용자가 업로드한 파일 이름 알아오기
		String originName = file.getSubmittedFileName();

		// 사용자가 업로드한 파일에 input 스트림 연결
		InputStream fis = file.getInputStream();

		// 파일 이름 변경
		String changeName = "Z" + UUID.randomUUID();
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());

		// 저장할 경로
		String realPath = req.getServletContext().getRealPath("/upload/product");

		// 파일 경로
		String filePath = realPath + File.separator + changeName + ext;

		// 파일 저장
		FileOutputStream fos = new FileOutputStream(filePath);

		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		fis.close();
		fos.close();

		pImg = new ProductImgVo();
		pImg.setProductImgName(changeName + ext);

		pImgList.add(pImg);
	}
}
```


## 태그 검색 
### <제품별 등록 태그 검색>
```java

```

## 장바구니
```java

```
