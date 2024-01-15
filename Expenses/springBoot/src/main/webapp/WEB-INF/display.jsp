<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 14/12/2023
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>ALL EXPENSES</title>
</head>
<body>

<h1>Details</h1>
<p><a href="/expenses"></p>
<table>
    <tbody>
    <tr>
        <td>Expense Name:</td>
        <td><c:out value="${expense.name}"></c:out></td>
    </tr>
    <tr>
        <td>Expense Description:</td>
        <td><c:out value="${expense.description}"></c:out></td>
    </tr>
    <tr>
        <td>Vendor:</td>
        <td><c:out value="${expense.vendor}"></c:out></td>
    </tr>
    <tr>
        <td>Amount Spent:</td>
        <td>$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}"/></td>
    </tr>

    </tbody>
</table>


</body>
</html>