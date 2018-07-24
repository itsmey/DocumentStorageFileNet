<%@ page import="ru.bikert.fileNet.DocumentFileNet" %><%--
  Created by IntelliJ IDEA.
  User: ebikert
  Date: 24.07.2018
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">FileNet App</a>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                 ${folder}
                </div>
                <div class="panel-body">
                    <div>
                       <%

                       %>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading">FolderName</div>
                <div class="panel-body">Panel Content</div>
            </div>
        </div>
    </div>
</div>
<%--Table--%>
<%--<div class="container">--%>
    <%--<h2>Отчет по документам</h2>--%>
    <%--<table class="table table-striped">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Номер</th>--%>
            <%--<th>Tип</th>--%>
            <%--<th>Имя</th>--%>
            <%--<th>Статус</th>--%>
            <%--<th>Ответственный</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<tbody id = "table">--%>

        <%--</tbody>--%>
    <%--</table>--%>
<%--</div>--%>

<%--<script>--%>
    <%--$(document).ready(function() {--%>
            <%--$.post('/test1').done(function(data) {--%>
                <%--alert(data);--%>
            <%--});--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
