'use strict';

/* Controllers */
var crmControllers = angular.module('crmControllers',[]);

crmControllers.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    $http.get('/items').success(function (data) {
        $scope.listItems = data;
    });
}]);

/*Client Controllers*/
crmControllers.controller('CRM_ClientsController',['$scope','ClientFactory', function($scope,ClientFactory) {
    $scope.tableName = "Clients Table";
    $scope.listClients = ClientFactory.query();
}]);

crmControllers.controller('CRM_ClientController',['$scope','$routeParams','ClientFactory', function($scope, $routeParams, ClientFactory) {
   ClientFactory.get({clientId: $routeParams.id_cl}, function(data){
       $scope.client = data;
   })
}]);

/*Order Controllers*/
crmControllers.controller('CRM_OrdersController',['$scope','OrderFactory', function($scope,OrderFactory) {
    $scope.tableName = "Orders Table";
    $scope.listOrders = OrderFactory.query();
}]);

crmControllers.controller('CRM_OrderController',['$scope','$routeParams','OrderFactory', function($scope, $routeParams, OrderFactory) {
    OrderFactory.get({orderId: $routeParams.id_order},function(data){
        $scope.orderObj = data;
    });
}]);

