<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 13/01/2024
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Omikuji Form</title>
</head>
<body>
<form action='/omikuji/process' method='POST'>
    <h3>Send an Omikuji</h3>
    <label>Pick any number from 5 to 25:</label>
    <label>
        <input type="number" name='number'>
    </label>

    <label>Enter the name of any city.</label>
    <label>
        <input type='text' name='city'>
    </label>

    <label>Enter the name of any real person.</label>
    <label>
        <input type='text' name='person'>
    </label>

    <label>Enter professional endeavor or hobby.</label>
    <label>
        <input type='text' name='hobby'>
    </label>

    <label>Enter any type of living thing.</label>
    <label>
        <input type='text' name='thing'>
    </label>

    <label>Say something nice to someone:</label>
    <label>
        <textarea name='say' rows='4' cols='50'></textarea>
    </label>
    <p>Send and show a friend</p>
    <input type='submit' value='Send'>
</form>
</body>
</html>