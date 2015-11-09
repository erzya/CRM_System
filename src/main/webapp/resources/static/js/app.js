'use strict';
/**
 * Created by erzyasd on 03.11.15.
 */
var CRM_SystemApp = angular.module('CRM_SystemApp', ['ngRoute','crmControllers']);

CRM_SystemApp.config(['$routeProvider',function($routeProvider){



    $routeProvider
        .when('/items/:itemName',
            {
                templateUrl:'/resources/template/detail-table-entity.html',
                controller : 'CRM_DetailEntityController'

            })
        .otherwise({redirectTo: '/'});
}]);
