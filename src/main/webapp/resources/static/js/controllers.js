'use strict';

/* Controllers */
var crmControllers = angular.module('crmControllers',[]);

crmControllers.controller('CRM_SystemController',['$scope','$http','$location', function($scope, $http,$location) {



    $http.get('/item').success(function (data) {
        $scope.listItems = data;
    });
}]);

crmControllers.controller('CRM_DetailEntityController',['$scope','$http','$location','$window', '$routeParams', function($scope, $http,$location,$window, $routeParams) {
    $scope.title = 'FirstAngular';
    console.log($location.search());
    console.log($location.path());
    console.log($location.url());



    $scope.itemName = $routeParams.itemName;

}]);

