app.controller('teamsBackgroundCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    $scope.data = $stateParams.data;
    console.log("Team background");

    $scope.updateTeamBg = function () {
        console.log("!!");
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to update the team background?');
        dlg.result.then(function(btn){
            httpService.updateTeamsInfo($stateParams.id, $scope.data).then(function(response) {
                console.log(response);
                alert("Update successfully!");
                $state.transitionTo("teams");
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
