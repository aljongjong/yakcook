# ๐พ ์ ํ ๊ด๋ จ ์ฃผ์ ๋ก์ง

## ์ ํ ์กฐํ 
### <์นดํ๊ณ ๋ฆฌ ๋ณ/์ ๋ ฌ ์กฐํ>
```java
  // ์ ํ ์ด๋ฏธ์ง ๋ถ๋ฌ์ค๊ธฐ
  List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
  req.setAttribute("productImgList", piList);

  // ์ ํ ์กฐํ ํ์ด์ง ์ข์ธก ์นดํ๊ณ ๋ฆฌ ๋ถ๋ฌ์ค๊ธฐ
  List<CategoryVo> cList = new ServiceProduct().searchCategory();
  req.setAttribute("categoryList", cList);

  // ์ ํ ์กฐํ ํ์ด์ง ์ฒ์ ์ ์ฒด ์ ํ ๋ถ๋ฌ์ค๊ธฐ
  List<ProductVo> pList = new ServiceProduct().searchAllProduct();
  req.setAttribute("allProductList", pList);

  // ์นดํ๊ณ ๋ฆฌ ์ ํ์ ์ ํ ์นดํ๊ณ ๋ฆฌ ์ ํ๋ง ๋ถ๋ฌ์ค๊ธฐ
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

### <์ ํ ์์ธ ์ ๋ณด ํ์ด์ง>
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	// ์ด ๊ธ์ก ๋ณ๊ฒฝ ajax
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

	// ์ ํ ์ด๋ฏธ์ง ๋ถ๋ฌ์ค๊ธฐ
	List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
	req.setAttribute("productImgList", piList);

	// ์ ํ ์กฐํ ํ์ด์ง์์ ์ ํ ์ด๋ฆ ํด๋ฆญ์ ์ ํ ์์ธ ํ์ด์ง ์ด๋ํ๊ธฐ
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

## ์ ํ ๊ด๋ฆฌ 
### <์ ํ ์กฐํ, ๋ฑ๋ก, ์์ , ์ญ์ >
```java
// ๋ค์ค ํ์ผ ์๋ก๋
List<ProductImgVo> pImgList = new ArrayList<>();

Collection<Part> parts = req.getParts(); // ๋ชจ๋  part๋ค์ ๊ฐ์ ธ์ด
ProductImgVo pImg = null;

if(resultTag == 3) {
	for(Part file : parts) {
		if(!file.getName().equals("f")) continue; // name์ด f์ธ ๊ฒฝ์ฐ์ ์คํ

		// ์ฌ์ฉ์๊ฐ ์๋ก๋ํ ํ์ผ ์ด๋ฆ ์์์ค๊ธฐ
		String originName = file.getSubmittedFileName();

		// ์ฌ์ฉ์๊ฐ ์๋ก๋ํ ํ์ผ์ input ์คํธ๋ฆผ ์ฐ๊ฒฐ
		InputStream fis = file.getInputStream();

		// ํ์ผ ์ด๋ฆ ๋ณ๊ฒฝ
		String changeName = "Z" + UUID.randomUUID();
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());

		// ์ ์ฅํ  ๊ฒฝ๋ก
		String realPath = req.getServletContext().getRealPath("/upload/product");

		// ํ์ผ ๊ฒฝ๋ก
		String filePath = realPath + File.separator + changeName + ext;

		// ํ์ผ ์ ์ฅ
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


## ํ๊ทธ ๊ฒ์ 
### <์ ํ๋ณ ๋ฑ๋ก ํ๊ทธ ๊ฒ์>
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String tagName = req.getParameter("tagName");

	System.out.println("tagName:" + tagName);
	req.setAttribute("tagName", tagName);

	// ๊ฐ์ ํ๊ทธ๋ฅผ ๊ฐ์ง๊ณ  ์๋ ์ ํ๋ค ๊ฒ์ ํ ๋ฆฌํด
	List<ProductVo> list = new ArrayList<>();
	list = new ServiceProduct().tagSearchProduct(tagName);

	if(list.size() > 0) {
		req.setAttribute("tagSearchList", list);
	} else {
		req.setAttribute("msg", "๊ฒ์ํ ํ๊ทธ ๊ฒฐ๊ณผ๊ฐ ์์ต๋๋ค.");
	}

	// ์ ํ ์ด๋ฏธ์ง ๋ถ๋ฌ์ค๊ธฐ
	List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
	req.setAttribute("productImgList", piList);

	// ํ๊ทธ ๋งค์น
	List<ProductVo> tagProductList = new ServiceProduct().tagProductList();
	req.setAttribute("tagProductList", tagProductList);


	req.getRequestDispatcher("/WEB-INF/views/product/tagSearchProduct.jsp").forward(req, resp);
}
```

## ์ฅ๋ฐ๊ตฌ๋
```java
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	String productNo = req.getParameter("productNo");
	String price = req.getParameter("price");
	String categoryNo = req.getParameter("categoryNo");
	String productName = req.getParameter("productName");
	String amount = req.getParameter("amount");

	ProductVo pv = new ProductVo();
	pv.setProductNo(Integer.parseInt(productNo));
	pv.setPrice(Integer.parseInt(price));
	pv.setCategoryNo(Integer.parseInt(categoryNo));
	pv.setProductName(productName);
	pv.setInventory(Integer.parseInt(amount));
	
	// ํ์์ ๋ณด ๋ฐ์์ค๊ธฐ
	HttpSession session = req.getSession(); 
	String loginUserId = ((MemberVo)session.getAttribute("loginUser")).getUser_id();
	int loginUserNo = new ServiceProduct().getMemberNoForShoppingBasket(loginUserId);
	MemberCheckVo mv = new MemberCheckVo();
	mv.setMemberNo(loginUserNo);
	mv.setId(loginUserId);

	// ํ์ธ ํ์ ์ ๋ณด๊ฐ์ ธ์์ ๊ทธ ํ์์ ๋ํ ์ฅ๋ฐ๊ตฌ๋ ์์ฑ
	ShoppingBasketVo sv = new ServiceProduct().shoppingBasket(mv);

//		์ฅ๋ฐ๊ตฌ๋์ ์ด๋ฏธ ์๋ ์ ํ์ธ์ง ํ์ธ (์์ผ๋ฉด ๋ฉ์์ง๋ ๋ ๋ ค์ฃผ๊ธฐ)
	int result = new ServiceProduct().checkMyShoppingBasket(sv, pv);
//		๊ฐ์ ธ์จ ์ฅ๋ฐ๊ตฌ๋ ๋ฒํธ์ ์ ํ ๋ฃ๊ธฐ , ์ฅ๋ฐ๊ตฌ๋์ ๊ทธ ์ ํ์ด ์์๋
	List<ShoppingBasketProVo> list = new ArrayList<>();
//		if(result == 0) {
		list = new ServiceProduct().putShoppingBasket(sv, pv);
//		}
	System.out.println("result : " + result);
	// ์ ํ ์ด๋ฏธ์ง ๋ถ๋ฌ์ค๊ธฐ
	List<ProductImgVo> piList = new ServiceProduct().searchAllProductImg();
	req.setAttribute("productImgList", piList);

	// ์ ํ ์กฐํ ํ์ด์ง ์ฒ์ ์ ์ฒด ์ ํ ๋ถ๋ฌ์ค๊ธฐ
	List<ProductVo> pList = new ServiceProduct().searchAllProduct();
	req.setAttribute("allProductList", pList);

	// ์ฅ๋ฐ๊ตฌ๋์ ๋ด๊ธด ์ด ์ํ ๊ธ์ก ๋ถ๋ฌ์ค๊ธฐ
	int totalProductPrice = new ServiceProduct().totalProductPrcie(sv);
	req.setAttribute("totalProductPrice", totalProductPrice);

	req.setAttribute("shoppingBasket", list);
	req.setAttribute("pv", pv);
	req.setAttribute("sv", sv);

	req.getRequestDispatcher("/WEB-INF/views/product/shoppingBasket.jsp").forward(req, resp);

}
```
