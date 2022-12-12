<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 22/11/2022
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<body class="goto-here">
<jsp:include page="header.jsp"/>
<!-- END nav -->

<section id="home-section" class="hero">
    <div class="home-slider owl-carousel">
        <div class="slider-item" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_16.jpeg);">
            <div class="overlay"></div>
            <div class="container">
                <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                    <div class="col-md-12 ftco-animate text-center">

                        <h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
                        <p><a href="#" class="btn btn-primary">View Details</a></p>
                    </div>

                </div>
            </div>
        </div>

        <div class="slider-item" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_7.jpeg);">
            <div class="overlay"></div>
            <div class="container">
                <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

                    <div class="col-sm-12 ftco-animate text-center">

                        <h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
                        <p><a href="#" class="btn btn-primary">View Details</a></p>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row no-gutters ftco-services">
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-shipped"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">MIễn Phí vận Chuyển </h3>
                        <span>0$</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-diet"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Giản giá ưu đãi</h3>
                        <span>Sale 50%</span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-award"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Sản Phẩm ưu chuộng  </h3>
                        <span> nổi bật tính  </span>
                    </div>
                </div>
            </div>
            <div class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
                <div class="media block-6 services mb-md-0 mb-4">
                    <div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
                        <span class="flaticon-customer-service"></span>
                    </div>
                    <div class="media-body">
                        <h3 class="heading">Tư vấn miễn phí </h3>
                        <span>　Nhiệt tình ,tận tâm  </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /////////////////////////new PRODUCT ///////////////////////////////////////// -->
<section class="ftco-section ftco-category ftco-no-pt">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-6 order-md-last align-items-stretch d-flex">
                        <div class="category-wrap-2 ftco-animate img align-self-stretch d-flex" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_15.jpeg);">
                            <div class="text text-center">
                                <h2>New Product</h2>
                                <p>愛好家を満足させる</p>
                                <p><a href="#" class="btn btn-primary">Shop now</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_1.jpeg);">
                            <div class="text px-3 py-1">
                                <h2 class="mb-0"><a href="href="<%=request.getContextPath()%>/HomeServlet?action=Shop">　Cộng Tác </a></h2>
                            </div>
                        </div>
                        <div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_2.jpeg);">
                            <div class="text px-3 py-1">
                                <h2 class="mb-0"><a href="href="<%=request.getContextPath()%>/HomeServlet?action=Shop"> Bứt Phá </a></h2>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_9.jpeg);">
                    <div class="text px-3 py-1">
                        <h2 class="mb-0"><a href="href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Vượt Trội </a></h2>
                    </div>
                </div>
                <div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_11.jpeg);">
                    <div class="text px-3 py-1">
                        <h2 class="mb-0"><a href="href="<%=request.getContextPath()%>/HomeServlet?action=Shop">Cải Tiến </a></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center mb-3 pb-3">
            <div class="col-md-12 heading-section text-center ftco-animate">
                <span class="subheading">Our Products</span>
                <h2 class="mb-4"> Sản Phẩm Nổi Bật </h2>
                <p>Apple Watch là sản phẩm nổi tiếng thế giới và cũng rất được ưa chuộng tại Việt Nam. </p>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <c:forEach items="${listPro}" var="pro">
                <div class="col-md-6 col-lg-3 ftco-animate">
                    <div class="product">
                        <a href="<%=request.getContextPath()%>/HomeServlet?action=proDetail&&productId=${pro.productId}" class="img-prod"><img class="img-fluid" src="<%=request.getContextPath()%>/views/images/${pro.productImage}" alt="${pro.productName}">
                        </a>
                        <div class="text py-3 pb-4 px-3 text-center">
                            <h3><a href="#">${pro.productName}</a></h3>
                            <div class="d-flex">
                                <div class="pricing">
                                    <p class="price"><span class="price-sale">${pro.price} $</span></p>
                                </div>
                            </div>
                            <div class="bottom-area d-flex px-3">
                                <div class="m-auto d-flex">
                                    <a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                        <span><i class="ion-ios-menu"></i></span>
                                    </a>
                                    <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=AddCart&&productId=${pro.productId}" class="buy-now d-flex justify-content-center align-items-center mx-1">
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
        </div>
    </div>
</section>

<section class="ftco-section img" style="background-image: url(<%=request.getContextPath()%>/views/images/anh_19.jpeg); padding-left: 555px; ">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-md-6 heading-section ftco-animate deal-of-the-day ftco-animate">
                <span class="subheading">Best Price For You</span>
                <h2 class="mb-4">Deal of the day</h2>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
                <h3><a href="#">Spinach</a></h3>
                <span class="price">$10 <a href="#">now $5 only</a></span>
                <div id="timer" class="d-flex mt-5">
<%--                    <div class="time" id="days"></div>--%>
                    <div class="time pl-3" id="hours"></div>
                    <div class="time pl-3" id="minutes"></div>
                    <div class="time pl-3" id="seconds"></div>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section testimony-section">
    <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
            <div class="col-md-7 heading-section ftco-animate text-center">
                <span class="subheading">Testimony</span>
                <h2 class="mb-4">Phản Hồi khách hàng đã trải nghiệm Apple Watch</h2>
                <!-- <p> Apple Watch mang lại cho mình một trải nghiệm vô cùng tuyệt vời </p> -->
            </div>
        </div>
        <div class="row ftco-animate">
            <div class="col-md-12">
                <div class="carousel-testimony owl-carousel">
                    <div class="item">
                        <div class="testimony-wrap p-4 pb-5">
                            <div class="user-img mb-5" style="background-image: url(<%=request.getContextPath()%>/views/images/khvan.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                            </div>
                            <div class="text text-center">
                                <p class="mb-5 pl-4 line"> Apple wacth mang lại cho mình 1 trải nghiệm vô cùng tuyệt vời .</p>
                                <p class="name">Chu Minh </p>
                                <span class="position">Marketing Manager</span>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testimony-wrap p-4 pb-5">
                            <div class="user-img mb-5" style="background-image: url(<%=request.getContextPath()%>/views/images/khTiep.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                            </div>
                            <div class="text text-center">
                                <p class="mb-5 pl-4 line">App Wacth thực sự đột phá trong cách thiết kế cùng tính năng  .</p>
                                <p class="name">Bé Tiệp </p>
                                <span class="position">Interface Designer</span>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="testimony-wrap p-4 pb-5">
                            <div class="user-img mb-5" style="background-image: url(<%=request.getContextPath()%>/views/images/kh1.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                            </div>
                            <div class="text text-center">
                                <p class="mb-5 pl-4 line">1 chiếc đồng hồ của thế kỷ ,I love Apple Wacth.</p>
                                <p class="name">Trần Tín </p>
                                <span class="position">UI Designer</span>
                            </div>
                        </div>
                    </div>

                    <div class="item">
                        <div class="testimony-wrap p-4 pb-5">
                            <div class="user-img mb-5" style="background-image: url(<%=request.getContextPath()%>/views/images/khtuan.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                            </div>
                            <div class="text text-center">
                                <p class="mb-5 pl-4 line">Đó không còn là 1 chiếc đồng hồ đơn thuần ,quá tuyệt vời .</p>
                                <p class="name">Tuấn Đào </p>
                                <span class="position">System Analyst</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- //heet than// -->
<jsp:include page="footer.jsp"/>
<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

</body>
</html>