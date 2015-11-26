'use strict';

var CRM_SystemApp = angular.module('CRM_SystemApp', ['ngRoute','ngResource','clientApp','orderApp']);
CRM_SystemApp.config(['$routeProvider',function($routeProvider){
    $routeProvider.otherwise({redirectTo: '/'});
}]);

CRM_SystemApp.controller('CRM_SystemController',['$scope','$http', function($scope, $http) {
    console.log("GetHome ctr before  !!!!!!!!!!!!");
    $http.get('/items').success(function (data) {
        $scope.items =[];
        angular.forEach(data, function(value) {
            var parseValue = value.split(/^\S+\./)[1]+'s';
            var obj = {name: parseValue};
            this.push( obj);
        }, $scope.items);
    });
    console.log("GetHome ctr after  !!!!!!!!!!!!!");
}]);

/*Plugin for Update fields*/
CRM_SystemApp.directive('jsEdit', function() {
    return {
        restrict: "A",
        scope:true,
        link: link2
    };
    function link2(scope, $elem, attrs) {
        var $this = $elem;
        var $wrapText = $this.find(".js-editable-wrap-text");
        var $divForm =  $this.find(".js-editable-form");
        var $input = $this.find(".js-editable-input");
        var $icon = $this.find(".js-editable-icon");

        scope.$watch(attrs.ngModel, function(newValue, oldValue) {
            function saveData() {
                $wrapText.text($input.val());
            }
            $icon.on('mousedown', function () {
                saveData();
            });

            $wrapText.on('click', function (e) {
                switchMode(editable);
            });

            var editable = true;

            function switchMode(editable) {
                if (editable) {
                    $wrapText.hide();
                    $divForm.show();
                    $input.focus();
                } else {
                    $wrapText.show();
                    $divForm.hide();
                }
            }
            $divForm.on('focusout', function (e) {
                setTimeout(switchMode(), 1);
            });
            $input.on('keyup keydown', function (e) {
                e.stopPropagation();
                switch (e.keyCode) {
                    case 13:
                        saveData();
                        switchMode();
                        break;
                    case 27:
                        switchMode();
                        break;
                    case 9:                                         //press TAB for focusin next editable field
                        var $nextEditable = $this.next('.js-editable');
                        var $nextWrapText = $nextEditable.find('.js-editable-wrap-text').hide();
                        var $nextDivForm = $nextEditable.find('.js-editable-form').show();
                        var $nextInput = $nextDivForm.find('.js-editable-input').val($nextWrapText.text());     //saveData from wrapText in input
                }
            });
        });
    }
});

/*Factories*/
/*----------------Client------------------*/
CRM_SystemApp.factory('ClientFactory',['$resource',function($resource){
    console.log("Before Return    Client");
    return $resource('clients/:action/:clientId',{},{
        delete:{method:'POST',params:{action:'del',clientId:'@clientId'}},
    });
}]);

/*-----------------Order-------------------*/
CRM_SystemApp.factory('OrderFactory',['$resource',function($resource){
    console.log("Before Return    Order");
    return $resource('orders/:action/:orderId',{},{
        delete:{method:'POST',params:{action:'del',orderId:'@orderId'}}
    });
}]);
