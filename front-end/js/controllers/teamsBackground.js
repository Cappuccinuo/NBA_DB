app.controller('teamsBackgroundCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    console.log($stateParams);
    $scope.data = $stateParams.data;
    console.log("Team background");
}]);
