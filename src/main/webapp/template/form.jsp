<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Vote</title>
</head>
<body>

<form action="vote" method="POST">
    <p><b>Выберите любимого исполнителя?</b></p>
    <c:forEach items="${singerList}" var="item">
        <p><input type="radio" name="singer" value="${item.getName()}">${item.getName()}</p>
    </c:forEach>

    <p><b>Ваши любимые жанры?</b></p>
    <c:forEach items="${genreList}" var="item">
        <p><input type="checkbox" name="genre" value="${item.getName()}">${item.getName()}</p>
    </c:forEach>

    <p><b>Расскажите о себе?</b></p>
    <textarea name="about"></textarea>

    <p><input type="submit"></p>
</form>

</body>
</html>