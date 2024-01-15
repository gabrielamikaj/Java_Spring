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
    <title>Project Manager Dashboard</title>
</head>
<body>

<h1>Project Manager Dashboard</h1>
<p>Welcome, ${user.firstName}</p>
<p><a href="/logout">Log Out</a></p>
<p><a href="/projects/new">Add Project</a></p>

<h4>All Projects</h4>

<table>
    <thead>
    <tr>
        <th>Project</th>
        <th>Team Lead</th>
        <th>Due Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${unassignedProjects}">
        <tr>
            <c:if test = "${project.lead.id!=user.id}">
                <td><a href="/projects/${project.id}">${project.title}</a></td>
                <td><c:out value="${project.lead.firstName}"></c:out></td>
                <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
                <td><a href="/dashboard/join/${project.id}">Join Team</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr>
<h4>Your Projects</h4>
<table>
    <thead>
    <tr>
        <th>Project</th>
        <th>Team Lead</th>
        <th>Due Date</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${assignedProjects}">
        <tr>
            <td><a href="/projects/${project.id}">${project.title}</a></td>
            <td><c:out value="${project.lead.firstName}"></c:out></td>
            <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
            <c:if test = "${project.lead.id==user.id}">
                <td><a href="/projects/edit/${project.id}">Edit Project</a></td>
            </c:if>
            <c:if test = "${project.lead.id!=user.id}">
                <td><a href="/dashboard/leave/${project.id}">Leave Team</a></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>