'use strict';

var clientController = angular.module('clientController',[]);

clientController.controller('CRM_ClientsController',['$scope','ClientFactory', function($scope,ClientFactory) {
    $scope.tableName = "Clients Table";
    $scope.listClients = ClientFactory.query();
}]);

clientController.controller('CRM_ClientController',['$scope','$routeParams','$location','ClientFactory', function($scope, $routeParams,$location, ClientFactory) {
    $scope.getObj = function(){
        return $scope.client
    }
    $scope.saveItem = function(){
        //$scope.editing = !$scope.editing;
        console.log('/items/Clients/'+$routeParams.id_cl);
        ClientFactory.save({action:'save'},$scope.client)
            .$promise.then(
            //success
            function( value ){
                $location.path('/items/Clients/'+$routeParams.id_cl);
            },
            //error
            function( error ){
                alert(error);
            });
    }
    ClientFactory.get({clientId: $routeParams.id_cl}, function(data){
        $scope.client = data;
    });
}]);
clientController.controller('CRM_ClientDelController',['$scope','$routeParams','$location','ClientFactory',
    function($scope, $routeParams,$location, ClientFactory) {
        ClientFactory.delete({clientId: $routeParams.id_cl})
            .$promise.then(
            function( value ){
                $location.path('/items/Clients');
            },
            function( error ){
                alert(error);
            });
    }]);
clientController.controller('CRM_ClientCreateController',['$scope','$routeParams','ClientFactory','$location',
    function($scope, $routeParams, ClientFactory,$location){
        $scope.saveClient = function(){
            ClientFactory.save({action:'save'},$scope.client)
                .$promise.then(
                //success
                function( value ){
                    $location.path('/items/Clients');
                },
                //error
                function( error ){
                    alert(error);
                });
        }
    }]);