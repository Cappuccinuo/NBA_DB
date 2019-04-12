app.controller('gamesStatsCtrl', ['$scope', '$stateParams', 'httpService', function($scope, $stateParams, httpService) {
    console.log($stateParams);
    $scope.data = $stateParams.data;
    $scope.ateam = {};
    $scope.hteam = {};
    
    httpService.getOneTeamGame($stateParams.data.away_team_id, $stateParams.id).then(function(response) {
        console.log(response);
        $scope.ateam = response.data;
    }).catch(function (result) {
        console.log(result);
        alert(result);
    });

    httpService.getOneTeamGame($stateParams.data.home_team_id, $stateParams.id).then(function(response) {
        console.log(response);
        $scope.hteam = response.data;
    }).catch(function (result) {
        console.log(result);
        alert(result);
    });
}]);
