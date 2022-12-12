<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 22/11/2022
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<body class="goto-here">
<jsp:include page="header.jsp"/>
<!-- END nav -->

<div class="hero-wrap hero-bread"
     style="background-image: url('<%=request.getContextPath()%>/views/images/anhdep.png');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center ">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home</a></span> <span>Products</span></p>
                <h1 class="mb-0 bread">Products</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul class="product-category">
                    <c:forEach items="${listCat}" var="cat">
                        <li class="${catId==cat.catalogId?'active':''}" >
                            <a href="<%=request.getContextPath()%>/HomeServlet?action=getProductByCatalog&&catId=${cat.catalogId}">${cat.catalogName}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${listPro}" var="pro">
            <div class="col-md-6 col-lg-3 ftco-animate">
                <div class="product">
                    <a href="<%=request.getContextPath()%>/HomeServlet?action=proDetail&&productId=${pro.productId}"
                       class="img-prod"><img class="img-fluid"
                                             src="<%=request.getContextPath()%>/views/images/${pro.productImage}"
                                             alt="${pro.productName}">
                    </a>
                    <div class="text py-3 pb-4 px-3 text-center">
                        <h3><a href="#">${pro.productName}</a></h3>
                        <div class="d-flex">
                            <div class="pricing">
                                <p class="price"><span class="price-sale">${pro.price} $ </span></p>
                            </div>
                        </div>
                        <div class="bottom-area d-flex px-3">
                            <div class="m-auto d-flex">
                                <a href="#"
                                   class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                    <span><i class="ion-ios-menu"></i></span>
                                </a>
                                <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=AddCart&&productId=${pro.productId}"
                                   class="buy-now d-flex justify-content-center align-items-center mx-1">
                                    <span><i class="ion-ios-cart"></i></span>
                                </a>
                                <a href="<%=request.getContextPath()%>/WishlistServlet?action=AddWish&&productId=${pro.productId}" class="heart d-flex justify-content-center align-items-center ">
                                    <span><i class="ion-ios-heart"></i></span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <jsp:include page="footer.jsp"/>
            <!-- loader -->
            <div id="ftco-loader" class="show fullscreen">
                <svg class="circular" width="48px" height="48px">
                    <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
                    <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                            stroke="#F96D00"/>
                </svg>
            </div>


</body>
</html>