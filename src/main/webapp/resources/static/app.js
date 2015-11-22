'use strict';

var CRM_SystemApp = angular.module('CRM_SystemApp', ['ngRoute','ngResource','clientApp','orderApp']);
CRM_SystemApp.config(['$routeProvider',function($routeProvider){
    $routeProvider.otherwise({redirectTo: '/'});
}]);

CRM_SystemApp.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    console.log("GetHome ctr before  !!!!!!!!!!!!");
    $http.get('/items').success(function (data) {
        $scope.listItems = data;
    });
    console.log("GetHome ctr after  !!!!!!!!!!!!!");
}]);

/*Factories*/
/*----------------Client------------------*/
CRM_SystemApp.factory('ClientFactory',['$resource',function($resource){
    console.log("Before Return    Client");
    return $resource('clients/:action/:clientId',{},{
        delete:{method:'POST',params:{action:'del',clientId:'@clientId'}},
    });
}]);

/*-----------------Order-------------------*/
CRM_SystemApp.factory('OrderFactory',['$resource',function($resource){
    console.log("Before Return    Order");
    return $resource('orders/:action/:orderId',{},{
        delete:{method:'POST',params:{action:'del',orderId:'@orderId'}}
    });
}]);