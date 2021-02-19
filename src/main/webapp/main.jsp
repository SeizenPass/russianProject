<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <%@ page contentType="text/html;charset=UTF-8"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <title>Главная страница</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/jumbotron/">


    <link href="bootstrap.min.css" rel="stylesheet">


    <link href="jumbotron.css" rel="stylesheet">
    <script>$(document).ready(function() {

    });</script>
</head>

<body>

<%@include file="nav.jsp"%>

<main role="main">




    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Латинские крылатые фразы, как они появились и их история</h1>
            <p>В данной статье мы расскажем вам о происхождении...</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Узнать больше  &raquo;</a></p>
        </div>
    </div>

    <div class="container">

        <div class="row">
            <div class="col-sm-4">

                <ul class="nav nav-pills flex-column">
                    <c:forEach items="${requestScope.categoryList}" var="obj">
                        <li class="nav-item">
                        <h2></h2>
                            <a class="nav-link active" style="margin-left: -100px;margin-bottom: 5px;" href="search?categoryId=${obj.id}"><c:out value="${obj.name}"/> (${obj.count})</a>
                        </li>
                    </c:forEach>


                </ul>
                <hr class="d-sm-none">
            </div>
            <div class="col-md-8" style="border-left: 5px solid black;">


            </div>

        </div>

        <hr>

    </div>

</main>

<footer class="container">

</footer>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="jquery-slim.min.js"><\/script>')</script>
<script src="popper.min.js"></script>
<script src="bootstrap.min.js"></script>


</body>
</html>
