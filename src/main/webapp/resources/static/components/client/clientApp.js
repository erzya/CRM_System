'use strict';

angular.module('clientApp',['ngRoute','clientController'])
    .config(['$routeProvider',function($routeProvider){
        $routeProvider
            .when('/items/Clients',
            {
                templateUrl:'/resources/static/components/client/clientList.jsp',
                controller : 'CRM_ClientsController'
            })
            .when('/items/Clients/new',
            {
                templateUrl:'/resources/static/components/client/createClient.jsp',
                controller : 'CRM_ClientCreateController'
            })
            .when('/items/Clients/:id_cl',
            {
                templateUrl:'/resources/static/components/client/client.jsp',
                controller : 'CRM_ClientController'
            })
            .when('/items/Clients/del/:id_cl',
            {
                templateUrl:'/resources/static/components/client/clientList.jsp',
                controller : 'CRM_ClientDelController'
            })
        }
    ]);
