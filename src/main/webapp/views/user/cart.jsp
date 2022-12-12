<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 22/11/2022
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<!-- END nav -->

<div class="hero-wrap hero-bread"
     style="background-image: url('<%=request.getContextPath()%>/views/images/anh_23.png');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Cart</h1>
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
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listCart}" var="cart">
                            <tr class="text-center">
                                <td class="product-remove">
                                <a href="<%=request.getContextPath()%>/ShoppingCartServlet?action=Delete&&productId=${cart.product.productId}"><span class="ion-ios-close"></span></a></td>
                                <td class="image-prod">
                                    <div class="img"
                                         style="background-image:url(<%=request.getContextPath()%>/views/images/${cart.product.productImage});">
                                    </div>
                                </td>
                                <td class="product-name">
                                    <h3>${cart.product.productName}</h3>

                                </td>
                                <td class="price">
                                        ${cart.product.price} $
                                </td>

                                <td type="number" class="quantity">
                                        <%--                                    <div class="input-group mb-3">--%>
                                        ${cart.quantity} psc
                                        <%--                                        <input   type="number" name="quantity" class="quantity form-control input-number"      min="1" max="100">--%>
                                        <%--                                    </div>--%>
                                </td>
                                <td class="total"></td>
                            </tr>
                            <!-- END TR-->
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="col-lg-4 mt-5 cart-wrap ftco-animate">
        <div class="cart-total mb-3">
            <h3>Cart Totals</h3>
            <p class="d-flex">
                <span>Name </span>
                <span>${userLogin.fullName}</span>
            </p>
            <p class="d-flex">
                <span>Ship</span>
                <span>$0.00</span>
            </p>
            <hr>
            <p class="d-flex total-price">
                <span>Total</span>
                <span>${totalAmount} $ </span>
            </p>
        </div>
        <p><a href="<%=request.getContextPath()%>/views/user/checkout.jsp" class="btn btn-primary py-3 px-4">Proceed to Checkout</a></p>
        <p><a href="<%=request.getContextPath()%>/HomeServlet?action=Shop" class="btn btn-primary py-3 px-4">Shopping......</a></p>
    </div>
    </div>
    </div>
</section>
<jsp:include page="footer.jsp"/>
<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>
<script>
    $(document).ready(function () {

        var quantitiy = 0;
        $('.quantity-right-plus').click(function (e) {

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function (e) {
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if (quantity > 0) {
                $('#quantity').val(quantity - 1);
            }
        });

    });
</script>

</body>
</html>


<%--<!-- loader -->--%>
<%--<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>--%>


<%--<script>--%>
<%--    $(document).ready(function(){--%>

<%--        var quantitiy=0;--%>
<%--        $('.quantity-right-plus').click(function(e){--%>

<%--            // Stop acting like a button--%>
<%--            e.preventDefault();--%>
<%--            // Get the field name--%>
<%--            var quantity = parseInt($('#quantity').val());--%>

<%--            // If is not undefined--%>

<%--            $('#quantity').val(quantity + 1);--%>


<%--            // Increment--%>

<%--        });--%>

<%--        $('.quantity-left-minus').click(function(e){--%>
<%--            // Stop acting like a button--%>
<%--            e.preventDefault();--%>
<%--            // Get the field name--%>
<%--            var quantity = parseInt($('#quantity').val());--%>

<%--            // If is not undefined--%>

<%--            // Increment--%>
<%--            if(quantity>0){--%>
<%--                $('#quantity').val(quantity - 1);--%>
<%--            }--%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>

<%--</body>--%>
<%--</html>--%>