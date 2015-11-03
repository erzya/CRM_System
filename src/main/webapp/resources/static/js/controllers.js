'use strict';

/* Controllers */
var crmControllers = angular.module('crmControllers',[]);

crmControllers.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    $scope.title = 'FirstAngular';

    $http.get('/item').success(function (data) {
        $scope.listItems = data;
    });
}]);

crmControllers.controller('CRM_DetailEntityController',['$scope','$http', '$routeParams', function($scope, $http, $routeParams) {
    $scope.itemName = $routeParams.itemName;
}]);

