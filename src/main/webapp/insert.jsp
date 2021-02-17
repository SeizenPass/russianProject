<%@ page import="dao.CategoryDao" %>
<%@ page import="model.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Amiran
  Date: 16-Feb-21
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CategoryDao categoryDao = new CategoryDao();
    List<Category> list = categoryDao.fetch();
%>
<html>
<head>
    <title>Insertion</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#submit').click(function () {
                $('#submit').text("Chaned");
                var someData = {
                    id: 0,
                    expression: $('#expression').val(),
                    translation: $('#translation').val(),
                    transcription: $('#transcription').val(),
                    description: $('#description').val(),
                    example: $('#example').val(),
                    categoryId: $('#categoryId').val()
                }
                var ajaxCall = $.ajax({
                    contentType: "application/json",
                    data: JSON.stringify(someData),
                    method: 'POST',
                    url: 'rest/expression'
                });
            })
        });
    </script>
</head>
<body>
<form>
    Выражение:<input type="text" name="expression" id="expression" style="width: 100%"><br>
    Перевод:<input type="text" name="translation" id="translation" style="width: 100%"><br>
    Транскрипция:<input type="text" name="transcription" id="transcription" style="width: 100%"><br>
    Описание:<textarea type="text" name="description" id="description" cols="50" rows="20"></textarea><br>
    Пример:<textarea type="text" name="example" id="example" cols="50" rows="20"></textarea><br>
    <select name="categoryId" id="categoryId">
        <% for (Category c:
                list) {
            %>
        <option value="<%=c.getId()%>"><%=c.getName()%></option>
        <%
        } %>
    </select>
    <input type="reset" value="Reset"/>
    <div id="submit" style="margin-top: 30px; background: #1c7430; color: white; padding: 5px">Submit</div>
</form>
</body>
</html>
