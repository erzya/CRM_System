<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-ng-app = "CRM_SystemApp">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" >
    <link rel="stylesheet" href="resources/static/css/custom.css" >
    <title></title>
</head>

<body id="CRM_System" data-ng-controller="CRM_SystemController">
<div id="container" class="panel panel-default">
    <div id="header" class="panel-heading">
        <div class="btn-group btn-group-justified">
            <a class="btn btn-info" data-ng-repeat="item in listItems" role="button" href="#/items/{{item.name}}">{{item.name}}</a>
        </div>
    </div>
    <div id="body" class="panel-body">
        <ng-view></ng-view>
    </div>
    <%-- <div id="footer" class="panel-footer"> <h3>CRM_System</h3></div>--%>
</div>

<%--JS-code--%>

<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="resources/bower_components/angular/angular.min.js"></script>
<script src="resources/bower_components/angular-route/angular-route.min.js"></script>
<script src="resources/bower_components/angular-resource/angular-resource.min.js"></script>

<script src="resources/static/app.js"></script>
<script src="resources/static/components/client/clientController.js"></script>
<script src="resources/static/components/client/clientApp.js"></script>
<script src="resources/static/components/order/orderController.js"></script>
<script src="resources/static/components/order/orderApp.js"></script>
</body>



</html>
