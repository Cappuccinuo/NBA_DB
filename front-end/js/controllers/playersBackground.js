app.controller('playersBackgroundCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    $scope.data = $stateParams.data;
    console.log("Player background");

    $scope.updatePlayerBg = function () {
        console.log("!!!");
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to update the player info?');
        dlg.result.then(function(btn){
            httpService.updatePlayerInfo($stateParams.id, $scope.data).then(function(response) {
                console.log(response);
                alert("Update successfully!");
                $state.transitionTo("pdetail", {id: $stateParams.id, data: $scope.data});
            }).catch(function (result) {
                console.log(result);
                alert(result);
            });
        }, function(btn){
            console.log("no update");
        });
        
    }
}]);
