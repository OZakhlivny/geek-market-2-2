angular.module('app').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.submitCreateNewOrder = function () {
        $http.post(contextPath + '/api/v1/orders', $scope.newOrder)
            .then(function (response) {
                $scope.newOrder = null;
                alert('Заказ оформлен');
                $scope.cartContentRequest();
            });
    };

    $scope.cartContentRequest = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        })
            .then(function (response) {
                console.log(response.data);
                $scope.cart = response.data;
            });
    };

    $scope.decrementItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/dec/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };

    $scope.removeItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/remove/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };

    $scope.incrementItem = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/add/' + productId,
            method: 'GET'
        })
            .then(function (response) {
                $scope.cartContentRequest();
            });
    };

    $scope.cartContentRequest();
});