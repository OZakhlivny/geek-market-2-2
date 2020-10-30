angular.module('app').controller('orderController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.ordersListRequest = function () {
        $http({
            url: contextPath + '/api/v1/orders',
            method: 'GET'
        })
            .then(function (response) {
                console.log(response.data);
                $scope.orders = response.data;
            });
    };

        $scope.ordersListRequest();
});