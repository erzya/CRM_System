<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app = "CRM_SystemApp">
    <head>

        <title></title>
    </head>

    <body id="CRM_System" data-ng-controller="CRM_SystemController">
        <div style="display:inline-block; margin-left: 0.3em"  data-ng-repeat="item in listItems">
            <input type="button" style="cursor: pointer" value="{{item.name}}"/>
        </div>

        <script src="resources/bower_components/angular/angular.js"></script>
        <script src="resources/static/js/controllers.js"></script>
    </body>



</html>
