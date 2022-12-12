<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 22/11/2022
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<!-- END nav -->

<div class="hero-wrap hero-bread" style="background-image: url('<%=request.getContextPath()%>/views/images/anh_cuoi.jpeg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Wishlist</span></p>
                <h1 class="mb-0 bread">My Wishlist</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th>
                            <th>Images</th>
                            <th>Product Name</th>
                            <th>Price</th>
<%--                            <th>Add To Cart </th>--%>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listWish}" var="wish">
                        <tr class="text-center">
                            <td class="product-remove">
                                <a href="<%=request.getContextPath()%>/WishlistServlet?action=Delete&&productId=${wish.product.productId}"><span class="ion-ios-close"></span></a>
                            </td>
                            <td class="image-prod">
                                <div class="img" style="background-image:url(<%=request.getContextPath()%>/views/images/${wish.product.productImage});"></div>
                            </td>

                            <td class="product-name">
                                <h3>${wish.product.productName}</h3>
                            </td>

                            <td class="price">${wish.product.price} $ </td>
<%--                            <td class="quantity">--%>
<%--                                <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=AddCart&&productId=${pro.productId}" class="btn btn-primary py-3 px-4">Go cart</a>--%>
<%--                            </td>--%>
                        </tr><!-- END TR-->
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
    <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
            <div class="col-md-6">
                <h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
                <span>Get e-mail updates about our latest shops and special offers</span>
            </div>
            <div class="col-md-6 d-flex align-items-center">

                    <div class="form-group d-flex">
<%--                        <input type="text" class="form-control" placeholder="Enter email address">--%>
                       <a href="<%=request.getContextPath()%>/HomeServlet?action=Shop" class="btn btn-primary py-3 px-4">Shopping......</a>
                    </div>

            </div>
        </div>
    </div>
</section>



<jsp:include page="footer.jsp"/>
<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>



<script>
    $(document).ready(function(){

        var quantitiy=0;
        $('.quantity-right-plus').click(function(e){

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function(e){
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if(quantity>0){
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>

</body>
</html>