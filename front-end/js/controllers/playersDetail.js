app.controller('playersDetailCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    console.log($stateParams);
    $scope.data = $stateParams.data;

    $scope.deletePlayer = function () {
        console.log("!!!");
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to delete this player?');
        dlg.result.then(function(btn){
            httpService.deletePlayerInfo($stateParams.id).then(function(response) {
                console.log(response);
                alert("Delete successfully!");
                $state.transitionTo("players");
            }).catch(function (result) {
                console.log(result);
                alert(result);
            });
        }, function(btn){
            console.log("no delete");
        });
    }
}]);
