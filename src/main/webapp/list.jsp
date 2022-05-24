<%--
  Created by IntelliJ IDEA.
  User: S
  Date: 5/23/2022
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <h1>Danh sach item</h1>
    <a href="/products?action=create">Tạo mới sản phẩm </a>
    <c:forEach items='${danhSach}' var="sanPham">
        <h3>${sanPham.id} , ${sanPham.name} , ${sanPham.price}, <a href="/products?action=edit&id=${sanPham.id}">Fix</a></h3>
    </c:forEach>

</body>
</html>
