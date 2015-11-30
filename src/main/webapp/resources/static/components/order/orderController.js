'use strict';

var orderController = angular.module('orderController',[]);

orderController.controller('CRM_OrdersController',['$scope','OrderFactory', function($scope,OrderFactory) {
    console.log("Getorders ctr before  &&&&&&&&&&&&");
    $scope.tableName = "Orders Table";
    $scope.listOrders = OrderFactory.query();
    console.log("Getorders ctr after  &&&&&&&&&&&&&&&");
}]);

orderController.controller('CRM_OrderController',['$scope','$routeParams','OrderFactory', function($scope, $routeParams, OrderFactory) {
    OrderFactory.get({orderId: $routeParams.id_order},function(data){
        $scope.orderObj = data;
    });
}]);
orderController.controller('CRM_OrderDelController',['$scope','$routeParams','OrderFactory','$location',
    function($scope, $routeParams, OrderFactory, $location) {
        OrderFactory.delete({action:'del',orderId: $routeParams.id_order})
            .$promise.then(
            //success
            function( value ){
                $location.path('/items/Orders');
            },
            //error
            function( error ){
                alert(error);
            });
    }]);

orderController.controller('CRM_OrderCreateController',['$scope','$routeParams','OrderFactory','ClientFactory','$location',
    function($scope, $routeParams, OrderFactory,ClientFactory, $location){
        $scope.listClients = ClientFactory.query();
        $scope.saveOrder = function(){
            OrderFactory.save({action:'new'},$scope.order)
                .$promise.then(
                //success
                function( value ){
                    $location.path('/items/Orders');
                },
                //error
                function( error ){
                    alert(error);
                });
        }
    }]);
