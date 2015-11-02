'use strict';

/* Controllers */
var CRM_SystemApp = angular.module('CRM_SystemApp', ['ngRoute']);

CRM_SystemApp.config(['$routeProvider','$locationProvider',function($routeProvider,$locationProvider){
    $locationProvider.html5Mode({
        enabled:true,
        requireBase:false
    })
    $routeProvider.when('/items/:itemName',
        {
            templateUrl:'/resources/template/detail-table-entity.html',
            controller : 'CRM_DetailEntityController'

        }).otherwise({redirectTo: '/'});
}]);

CRM_SystemApp.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    $scope.title = 'FirstAngular';

    $http.get('/item').success(function (data) {
        $scope.listItems = data;
    });
}]);

CRM_SystemApp.controller('CRM_DetailEntityController',['$scope','$http', '$routeParams', function($scope, $http, $routeParams) {
    $scope.itemName = $routeParams.itemName;
}]);

