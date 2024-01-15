<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 05/12/2023
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>FruitLoops</title>

</head>
<body>
<div class="container">
    <h2>Fruit Store</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="oneFruit" items="${fruits}">
            <tr>
                <td> <c:out value="${oneFruit.getName()}"></c:out> </td>
                <td> <c:out value="${oneFruit.getPrice()}"></c:out> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>