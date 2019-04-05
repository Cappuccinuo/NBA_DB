app.controller('teamsDetailCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    console.log($stateParams);
    $scope.data = $stateParams.data;
}]);
