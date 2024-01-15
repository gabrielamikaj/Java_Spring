<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Book API</title>
</head>
<body>
<form action='/books/process' method='POST'>
    <h3>Add a book</h3>
    <label>Title</label>
    <label>
        <input type="text" name='title'>
    </label>
    <label>Description</label>
    <label>
        <input type="text" name='description'>
    </label>
    <label>Language</label>
    <label>
        <input type="text" name='language'>
    </label>
    <label>Pages</label>
    <label>
        <input type="number" name='pages'>
    </label>
    <input type='submit' value='Add'>
</form>
</body>
</html>