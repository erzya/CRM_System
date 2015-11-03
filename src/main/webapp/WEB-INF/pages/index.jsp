<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html data-ng-app = "CRM_SystemApp">
    <head>
        <base href="/"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" >
        <title></title>
    </head>

    <body id="CRM_System" data-ng-controller="CRM_SystemController">
        <div class="" style="display:inline-block; margin-left: 0.3em"  data-ng-repeat="item in listItems">
            <a class="btn btn-info" role="button" href="/items/{{item.name}}">{{item.name}}</a>
        </div>

        <ng-view></ng-view>

        <%--JS-code--%>

        <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
        <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="resources/bower_components/angular/angular.min.js"></script>
        <script src="resources/bower_components/angular-route/angular-route.min.js"></script>

        <script src="resources/static/js/app.js"></script>
        <script src="resources/static/js/controllers.js"></script>
    </body>



</html>
