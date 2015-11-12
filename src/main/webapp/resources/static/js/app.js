'use strict';

/**
 * Created by erzyasd on 03.11.15.
 */
var CRM_SystemApp = angular.module('CRM_SystemApp', ['ngRoute','ngResource','crmControllers']);
CRM_SystemApp.config(['$routeProvider',function($routeProvider){
    $routeProvider
        .when('/items/Clients',
        {
            templateUrl:'/resources/template/client/clients.jsp',
            controller : 'CRM_ClientsController'
        })
        .when('/items/Clients/:id_cl',
        {
            templateUrl:'/resources/template/client/client.jsp',
            controller : 'CRM_ClientController'
        })
        .when('/items/Orders',
        {
            templateUrl:'/resources/template/order/orders.jsp',
            controller : 'CRM_OrdersController'
        })
        .when('/items/Orders/:id_order',
        {
            templateUrl:'/resources/template/order/order.jsp',
            controller : 'CRM_OrderController'
        })
        .otherwise({redirectTo: '/'});
}]);

/*Factory*/
CRM_SystemApp.factory('ClientFactory',['$resource',function($resource){
    console.log("Before Return    Client");
    return $resource('clients/:clientId',{
        clientId: 'list'
    },{
      get:{method:'GET',params:{clientId:'@clientId'}}
    });
}]);

CRM_SystemApp.factory('OrderFactory',['$resource',function($resource){
    console.log("Before Return    Order");
    return $resource('orders/:orderId',{
        orderId: 'list'
    },{
        get:{method:'GET',params:{orderId:'@orderId'}}
    });
}]);