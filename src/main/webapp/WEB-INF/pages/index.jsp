<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html data-ng-app = "CRM_SystemApp">
    <head>
        <base href="/"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            #footer {
                position: fixed;
                height: 100px;
                bottom: 0;
                width: 100%;
            }
        </style>
        <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" >
        <title></title>
    </head>

    <body id="CRM_System" data-ng-controller="CRM_SystemController">
        <div id="container" class="panel panel-default">
            <div id="header" class="panel-heading">
                <div class="btn-group btn-group-justified">
                    <a class="btn btn-info" data-ng-repeat="item in listItems" role="button" href="/items/{{item.name}}">{{item.name}}</a>
                </div>
            </div>
            <div id="body" class="panel-body">
                <ng-view></ng-view>
            </div>
            <div id="footer" class="panel-footer"> <h3>CRM_System</h3></div>
        </div>


        <%--JS-code--%>

        <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="resources/bower_components/angular/angular.min.js"></script>
        <script src="resources/bower_components/angular-route/angular-route.min.js"></script>

        <script src="resources/static/js/app.js"></script>
        <script src="resources/static/js/controllers.js"></script>
    </body>



</html>
