<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 14/01/2024
  Time: 00:43
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
    <title>Project Details</title>
</head>
<body>

<h2><a href="/dashboard">Dashboard</a></h2>

<h1>Project Details</h1>
<table>
    <tbody>
    <tr>
        <td>Project: <c:out value="${project.title}"></c:out></td>
    </tr>

    <tr>
        <td>Description: <c:out value="${project.description}"></c:out></td>
    </tr>

    <tr>
        <td>Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
    </tr>
    </tbody>
</table>

<c:if test = "${project.lead.id==userId}">
    <h2><a href="/projects/delete/${project.id}">Delete Project</a></h2>
</c:if>
</body>
</html>