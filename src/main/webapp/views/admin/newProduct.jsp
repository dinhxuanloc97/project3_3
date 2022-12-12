<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 25/11/2022
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
    <title>Create New Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post" enctype="multipart/form-data">
    <table border="1">
        <tr>
            <td>Product Id</td>
            <td><input type="text" name="productId"></td>
        </tr>
        <tr>
            <td>Product Name</td>
            <td><input type="text" name="productName"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity"></td>
        </tr>
        <tr>
            <td>Product Image</td>
            <td><input type="file" name="image" /></td>
        </tr>
        <tr>
            <td>Discription</td>
            <td><textarea name="description" id="description"></textarea></td>
<%--            <td><input type="text" name="description"></td>--%>
        </tr>
        <tr>
        <tr>
            <td>Catalog</td>
            <td>
                <select id="productId" name="catalogId">
                    <option value="0" selected>Choose...</option>
                    <c:forEach items="${listCat}" var="pro">
                        <option value="${pro.catalogId}">${pro.catalogName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        </tr>
        <tr>
            <td> Status</td>
            <td>
                <input type="radio" name="status" id="active" value="true"/><label for="active">Active</label>
                <input type="radio" name="status" id="inactive" value="false"/><label for="inactive">Inactive</label>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Create" name="action"/>
            </td>
        </tr>
    </table>
</form>
<script>
    CKEDITOR.replace("description");
</script>
</body>
</html>
