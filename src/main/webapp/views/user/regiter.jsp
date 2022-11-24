<%--
  Created by IntelliJ IDEA.
  User: dinhxuanloc
  Date: 22/11/2022
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet App</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.8.1/font/bootstrap-icons.min.css"
          integrity="sha512-Oy+sz5W86PK0ZIkawrG0iv7XwWhYecM3exvUtMKNJMekGFJtVAhibhRPTpmyTj8+lJCkmWfnpxKgT2OopquBHA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link rel="stylesheet" href="<%=request.getContextPath()%>/views/css/css/regiter.css">

</head>

<body>
<div class="login-box">
    <h2> Regiter</h2>
    <form>
        <div class="user-box">
            <input type="text" name="" required="">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="" required="">
            <label>Password</label>
        </div>
        <div class="user-box">
            <input type="password" name="" required="">
            <label> Enter the password</label>
        </div>
        <div class="user-box">
            <input type="password" name="" required="">
            <label> Number phone</label>
        </div>
        <a href="login.jsp">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            enter
        </a>
        <a  style="margin-left :90px"  href="index.jsp">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Home
        </a>
    </form>

</div>
</body>
</html>