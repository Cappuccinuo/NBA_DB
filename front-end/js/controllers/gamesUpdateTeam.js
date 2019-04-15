app.controller('gamesUpdateTeamCtrl', ['$scope', '$stateParams', 'httpService', '$dialogs', '$state', function($scope, $stateParams, httpService, $dialogs, $state) {
    console.log($stateParams);
    $scope.tmp = {};
    $scope.tmp.name = $stateParams.data.home_team_nickname;
    if ($stateParams.tid == $stateParams.data.away_team_id)
        $scope.tmp.name = $stateParams.data.away_team_nickname;

    httpService.getOneTeamGame($stateParams.tid, $stateParams.id).then(function(response) {
        console.log(response);
        $scope.data = response.data;
    }).catch(function (result) {
        console.log(result);
        alert(result);
    });

    $scope.updateTeamGame = function () {
        console.log($scope.data);
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to update the game information of this team?');
        dlg.result.then(function(btn){
            httpService.updateTeamGame($stateParams.tid, $stateParams.id, $scope.data).then(function(response) {
                console.log(response);
                alert("Update successfully!");
                $state.transitionTo("games");
            }).catch(function (result) {
                console.log(result);
                alert(result);
            });
           console.log("aaa");
        }, function(btn){
            console.log("no update");
        });
    }
}]);
