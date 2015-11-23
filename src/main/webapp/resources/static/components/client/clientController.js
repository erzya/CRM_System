'use strict';

var clientController = angular.module('clientController',[]);

clientController.controller('CRM_ClientsController',['$scope','ClientFactory', function($scope,ClientFactory) {
    $scope.tableName = "Clients Table";
    $scope.listClients = ClientFactory.query();
    console.log("listGet     ", $scope.listClients);
}]);

clientController.controller('CRM_ClientController',['$scope','$routeParams','ClientFactory', function($scope, $routeParams, ClientFactory) {
    ClientFactory.get({clientId: $routeParams.id_cl}, function(data){
        $scope.client = data;
    })
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
            $scope.client.telephone = $scope.client.telephone.replace(/[^\d]/g,''); /*only digits*/
            ClientFactory.save({action:'new'},$scope.client)
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