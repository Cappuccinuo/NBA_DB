app.controller('playersSeasonCtrl', ['$scope', '$stateParams', 'httpService', function($scope, $stateParams, httpService) {
    console.log("Player Season");

    $scope.season = "2017-18";
    httpService.getPlayerSeason($stateParams.id, $stateParams.data.team_id, $scope.season).then(function(response) {
        console.log(response);
        $scope.data = response.data;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
