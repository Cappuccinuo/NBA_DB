app.controller('gamesDetailCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    console.log($stateParams);
    $scope.data = $stateParams.data;
}]);
