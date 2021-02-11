<%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 11-Feb-21
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title></title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/jumbotron/">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script>$(document).ready(function() {
        var ajaxCall = $.ajax({
            dataType: 'json',
            url: 'rest/expression/<%=request.getParameter("id")%>'
        });

        ajaxCall.done(function(data) {
            if (data.expression != null) {
                $('#expression').text(data.expression);
            } else {
                $('#expression').text('не указано');
            }

            if (data.translation != null) {
                $('#translation').text(data.translation);
            }else {
                $('#translation').text('не указано');
            }

            if (data.transcription != null) {
                $('#transcription').text(data.transcription);
            }else {
                $('#transcription').text('не указано');
            }

            if (data.description != null) {
                $('#description').text(data.description);
            }else {
                $('#description').text('не указано');
            }

            if (data.example != null) {
                $('#example').text(data.example);
            }
            else {
                $('#example').text('не указано');
            }
        });
    });</script>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Главная <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Статья</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Категории</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Дропчик</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Что то </a>
                    <a class="dropdown-item" href="#">Еще что то</a>
                    <a class="dropdown-item" href="#">Еще что то </a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2 selectpicker" type="text" placeholder="Поиск" aria-label="Search" data-live-search="true">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>


        </form>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-12" style="margin:20px; height:200px; background-color: dimgray; color:white;text-align: center;">
                <h2>Крылатая фраза</h2>
                <p id="expression"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; height:150px; color:black; background-color: lightsteelblue">
                <h4>Перевод:</h4>
                <p id="translation"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; height:150px; color:black; background-color: lightsteelblue">
                <h4>Транскрипция</h4>
                <p id="transcription"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; height:150px; color:black; background-color: lightsteelblue">
                <h4>Описание</h4>
                <p id="description"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; height:150px; color:black; background-color: lightsteelblue">
                <h4>Пример</h4>
                <p id="example"></p>
            </div>

        </div>
    </div>
</div>
</body>
</html>