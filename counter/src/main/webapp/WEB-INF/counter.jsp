<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 13/12/2023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Counter</title>
</head>
<body>
<p>You have visited <a href="/"><i>localhost:8080/counter</i></a> <c:out value="${count}"/> times</p>
<div class="links">
    <p><a href="/">Back</a></p>
    <p><a href="/test-visit">Test another visit?</a></p>
    <p><a href="/increment">Increment Counter by 2</a></p>
    <form action="/reset" method="POST" style="display: inline;">
        <input type="submit" value="Reset Counter">
    </form>
</div>
</body>
</html>