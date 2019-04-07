app.controller('teamsBackgroundCtrl', ['$scope', '$stateParams', function($scope, $stateParams) {
    $scope.data = $stateParams.data;
    console.log("Team background");

    $scope.updateTeamBg = function () {
        console.log("!!");
    }
}]);
