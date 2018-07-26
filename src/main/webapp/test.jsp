<%@ page import="ru.bikert.fileNet.DocumentFileNet" %>
<%@ page import="ru.bikert.fileNet.Operation" %>
<%@ page import="ru.bikert.fileNet.operations.PrintCurrentOperation" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.filenet.api.core.Folder" %>
<%@ page import="com.filenet.api.core.Document" %>
<%@ page import="ru.bikert.fileNet.operations.PrintHierarchyOperation" %>
<%@ page import="ru.bikert.fileNet.Printer" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.bikert.fileNet.operationUI.OperationUI" %>
<%@ page import="ru.bikert.fileNet.MainWebApp" %><%--
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/myJs.js"></script>

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
                <%
                    final JspWriter fOut = out;
                    PrintHierarchyOperation.printHierarchy(new Printer() {
                        @Override
                        public void printString(String s) {
                            try {
                                fOut.print(s);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void printOpenLiTag() {
                            printString("<li>");
                        }

                        @Override
                        public void printOpenUlTag() {
                            printString("<ul>");
                        }

                        @Override
                        public void printCloseLiTag() {
                            printString("</li>");
                        }

                        @Override
                        public void printCloseUlTag() {
                            printString("</ul>");
                        }
                    });
                %>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="panel panel-default">
                <div class="panel-heading"><%=DocumentFileNet.getCurrentFolder().get_FolderName()%></div>
                <div class="panel-body">
                    <div>
                        <ul id="printDocument">

                        </ul>
                    </div>
                    <div class="container" id = "buttonOperation">
                        <%List<OperationUI> operations = MainWebApp.getOperationUI();
                            for (OperationUI op : operations) {
                                %><button type="button" class="btn btn-success" date-operation="<%=op.getKey()%>"><%=op.getTitle()%></button><%
                            }
                        %>
                    </div>
                </div>
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
