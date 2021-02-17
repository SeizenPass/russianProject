<%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 11-Feb-21
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Search</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="bootstrap.min.css" rel="stylesheet">


    <link href="jumbotron.css" rel="stylesheet">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/jumbotron/">
    <script>$(document).ready(function() {

    });</script>
</head>

<body>
<%@include file="nav.jsp"%>


<div class="row">
    <div class="col-sm-4" style="margin-left:50px;margin-right:100px;margin-top:70px;">
        <div class="input-group">
            <form action="search" method="get">
                <input type="search" class="form-control rounded" placeholder="Поиск" aria-label="Search"
                       aria-describedby="search-addon" name="word" value="${param.word}" />
                <select name="categoryId">
                    <c:forEach items="${requestScope.categoryList}" var="cat">
                    <c:choose>
                        <c:when test="${param.categoryId == cat.id}">
                            <option selected value="${cat.id}">${cat.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${cat.id}">${cat.name}</option>
                        </c:otherwise>
                    </c:choose>
                    </c:forEach>
                </select>
                Страница:
                <select name="page">
                    <c:forEach varStatus="loop" begin="1" end="${requestScope.expressions.total}">
                        <c:choose>
                            <c:when test="${not empty param.page && param.page == loop.index}">
                                <option selected value="${loop.index}">${loop.index}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${loop.index}">${loop.index}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-outline-primary">Поиск</button>
            </form>
        </div>
    </div>
</div>
<div class="container" id="results">
    <c:forEach items="${requestScope.expressions.expressionList}" var="obj">
        <div class="row nav-link active" style="margin-top: 30px; background-color: #007bff; color: white; border-radius: 12px">
            <div class="col-sm-12">
            <h2>${obj.expression}</h2>
                <i>${obj.translation}</i><br>
            <a href="content.jsp?id=${obj.id}" style="text-decoration: none; color: white">Открыть</a>
            </div>
        </div>
    </c:forEach>
    </div>
</div>



</body>
</html>