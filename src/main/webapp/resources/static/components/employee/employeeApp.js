'use strict';

angular.module('employeeApp',['ngRoute','employeeController'])
    .config(['$routeProvider',function($routeProvider){
        $routeProvider
            .when('/items/Employees',
            {
                templateUrl:'/resources/static/components/employee/employeeList.jsp',
                controller : 'CRM_EmployeesController'
            })
            .when('/items/Employees/new',
            {
                templateUrl:'/resources/static/components/employee/createEmployee.jsp',
                controller : 'CRM_EmployeeCreateController'
            })
            .when('/items/Employees/:id_emp',
            {
                templateUrl:'/resources/static/components/employee/employee.jsp',
                controller : 'CRM_EmployeeController'
            })
            .when('/items/Employees/del/:id_emp',
            {
                templateUrl:'/resources/static/components/employee/employeeList.jsp',
                controller : 'CRM_EmployeeListDelController'
            })
    }
    ]);

