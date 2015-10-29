'use strict';

/* Controllers */
var CRM_SystemApp = angular.module('CRM_SystemApp', []);

CRM_SystemApp.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    $scope.title = 'FirstAngular';

    $http.get('/item').success(function (data, status, headers, config) {
        $scope.listItems = data;
    });
}]);