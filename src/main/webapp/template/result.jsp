<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Результаты голосования</title>
</head>
<body>

<h1>Результаты голосования</h1>
<h2>Лучшие исполнители:</h2>
    <ul>
        <c:forEach items="${singerList}" var="item">
            <li>${item.key}: ${item.value}</li>
        </c:forEach>
    </ul>

<h2>Любимые жанры:</h2>
    <ul>
        <c:forEach items="${genreList}" var="item">
            <li>${item.key}: ${item.value}</li>
        </c:forEach>
    </ul>

<h2>Тексты пользователей:</h2>

     <c:forEach items="${textAbout}" var="text">
        <p>${text}</li>
     </c:forEach>

</body>
</html>