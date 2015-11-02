<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html data-ng-app = "CRM_SystemApp">
    <head>
        <base href="/"/>
        <title></title>
    </head>

    <body id="CRM_System" data-ng-controller="CRM_SystemController">
        <div class="" style="display:inline-block; margin-left: 0.3em"  data-ng-repeat="item in listItems">
            <a style="cursor: pointer" href="/items/{{item.name}}">{{item.name}}</a>
        </div>

        <ng-view></ng-view>

        <script src="resources/bower_components/angular/angular.min.js"></script>
        <script src="resources/bower_components/angular-route/angular-route.min.js"></script>
        <script src="resources/static/js/controllers.js"></script>
    </body>



</html>
