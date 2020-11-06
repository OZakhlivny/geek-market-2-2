angular.module('app').controller('userController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

        $scope.userDataRequest = function () {
            $http({
                url: contextPath + '/api/v1/cabinet',
                method: 'GET'
            })
                .then(function (response) {
                    console.log(response.data);
                    $scope.user = response.data;
                });
        };

    $scope.updateUserData = function () {
        $http.post(contextPath + '/api/v1/cabinet', $scope.user)
            .then(function (response) {
                alert('Данные сохранены.');
            });
    };

    $scope.userDataRequest();

});