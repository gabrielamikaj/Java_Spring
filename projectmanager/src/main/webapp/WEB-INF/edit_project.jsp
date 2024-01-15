<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 14/01/2024
  Time: 00:41
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
    <title>Edit Project</title>
</head>
<body>

<h2><a href="/dashboard">Dashboard</a></h2>

<h1>Edit Project</h1>

<%--@elvariable id="project" type=""--%>
<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project">

    <table>
        <thead>
        <tr>
            <td class="float-left">Project Title:</td>
            <td class="float-left">
                <form:errors path="title" class="text-danger"/>
                <form:input class="input" path="title" value="${project.title}"/>
            </td>
        </tr>
        <tr>
            <td class="float-left">Project Description:</td>
            <td class="float-left">
                <form:errors path="description" class="text-danger"/>
                <form:textarea rows="4" class="input" path="description" value="${project.description}"/>
            </td>
        </tr>
        <tr>
            <td class="float-left">Due Date:</td>
            <td class="float-left">
                <form:errors path="dueDate" class="text-danger"/>
                <form:input path="dueDate" type="date" value="${project.dueDate}"/>
            </td>
        </tr>
        <tr>
            <td><a class="linkBtn" href="/dashboard">Cancel</a></td>
            <td><input class="input" type="submit" value="Submit"/></td>
        </tr>
        </thead>
    </table>
</form:form>
</body>
</html>