app.controller('gamesUpdateCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    console.log($stateParams);
    $scope.data = $stateParams.data;

    $scope.deleteGame = function () {
        var dlg = null;
        console.log($stateParams.id);
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to delete this game?');
        dlg.result.then(function(btn){
            httpService.deleteGame($stateParams.id).then(function(response) {
                console.log(response);
                alert("Delete successfully!");
                $state.transitionTo("games");
            }).catch(function (result) {
                console.log(result);
                alert(result);
            });
        }, function(btn){
            console.log("no delete");
        });
    }
}]);
