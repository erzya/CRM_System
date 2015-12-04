'use strict';

var employeeController = angular.module('employeeController',[]);

employeeController.controller('CRM_EmployeesController',['$scope','EmployeeFactory', function($scope,EmployeeFactory) {
    $scope.tableName = "Employees Table";
    $scope.listEmployees = EmployeeFactory.query();
    console.log("listGet     ", $scope.listEmployees);
}]);

employeeController.controller('CRM_EmployeeController',['$scope','$routeParams','EmployeeFactory', function($scope, $routeParams, EmployeeFactory) {
    EmployeeFactory.get({employeeId: $routeParams.id_cl}, function(data){
        $scope.employee = data;
    })
}]);
employeeController.controller('CRM_EmployeeDelController',['$scope','$routeParams','$location','EmployeeFactory',
    function($scope, $routeParams,$location, EmployeeFactory) {
        EmployeeFactory.delete({employeeId: $routeParams.id_emp})
            .$promise.then(
            function( value ){
                $location.path('/items/Employees');
            },
            function( error ){
                alert(error);
            });
    }]);
employeeController.controller('CRM_EmployeeCreateController',['$scope','$routeParams','EmployeeFactory','$location',
    function($scope, $routeParams, EmployeeFactory,$location){
        $scope.saveEmployee = function(){
            EmployeeFactory.save({action:'new'},$scope.employee)
                .$promise.then(
                //success
                function( value ){
                    $location.path('/items/Employees');
                },
                //error
                function( error ){
                    alert(error);
                });
        }
    }]);