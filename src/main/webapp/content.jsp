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

    <title>Крылатое выражение</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/jumbotron/">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script>$(document).ready(function() {
        var ajaxCall = $.ajax({
            dataType: 'json',
            url: 'rest/expression/<%=request.getParameter("id")%>'
        });

        ajaxCall.done(function(data) {
            if (data.expression != null && data.expression.trim() !== "") {
                $('#expression').text(data.expression);
                $('#expression').parent().show();
            } else {
                $('#expression').text('не указано');
            }

            if (data.translation != null && data.translation.trim() !== "") {
                $('#translation').text(data.translation);
                $('#translation').parent().show();
            }else {
                $('#translation').text('не указано');
            }

            if (data.transcription != null && data.transcription.trim() !== "") {
                $('#transcription').text(data.transcription);
                $('#transcription').parent().show();
            }else {
                $('#transcription').text('не указано');
            }

            if (data.description != null && data.description.trim() !== "") {
                $('#description').text(data.description);
                $('#description').parent().show();
            }else {
                $('#description').text('не указано');
            }

            if (data.example != null && data.example.trim() !== "") {
                $('#example').text(data.example);
                $('#example').parent().show();
            }
            else {
                $('#example').text('не указано');
            }
        });
    });</script>
</head>

<body>

<%@include file="nav.jsp"%>
<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-12" style="margin:20px; background-color: dimgray; color:white;text-align: center; display: none;">
                <h2>Крылатая фраза</h2>
                <p id="expression"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; color:black; background-color: lightsteelblue; display: none;">
                <h4>Перевод:</h4>
                <p id="translation"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; color:black; background-color: lightsteelblue; display: none;">
                <h4>Транскрипция</h4>
                <p id="transcription"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; color:black; background-color: lightsteelblue; display: none;">
                <h4>Описание</h4>
                <p id="description"></p>
            </div>
            <div class="col-sm-12" style="margin-left:20px; margin-top: 30px; color:black; background-color: lightsteelblue; display: none;">
                <h4>Пример</h4>
                <p id="example"></p>
            </div>

        </div>
    </div>
</div>
</body>
</html>