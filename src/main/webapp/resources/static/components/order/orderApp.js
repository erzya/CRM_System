'use strict';

angular.module('orderApp',['ngRoute','orderController'])
    .config(['$routeProvider',function($routeProvider){
        $routeProvider
            .when('/items/Orders',
            {
                templateUrl:'/resources/static/components/order/orders.jsp',
                controller : 'CRM_OrdersController'
            })
                .when('/items/Orders/new',
            {
                templateUrl:'/resources/static/components/order/createOrder.jsp',
                controller : 'CRM_OrderCreateController'
            })
            .when('/items/Orders/:id_order',
            {
                templateUrl:'/resources/static/components/order/order.jsp',
                controller : 'CRM_OrderController'
            })
            .when('/items/Orders/del/:id_order',
            {
                templateUrl:'/resources/static/components/order/orders.jsp',
                controller : 'CRM_OrderDelController'
            })

    }]);
