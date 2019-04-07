app.controller('teamsSeasonCtrl', ['$scope', '$stateParams', 'httpService', function($scope, $stateParams, httpService) {
    console.log("Team Season");

    $scope.season = "2017-18";
    httpService.getTeamSeason($stateParams.id, $scope.season).then(function(response) {
        console.log(response);
        $scope.data = response.data;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
