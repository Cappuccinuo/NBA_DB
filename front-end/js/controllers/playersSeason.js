app.controller('playersSeasonCtrl', ['$scope', '$stateParams', 'httpService', function($scope, $stateParams, httpService) {
    console.log("Player Season");

    $scope.season = "2017-18";
    $scope.data = {};
    httpService.getPlayerSeason($stateParams.id, $scope.season).then(function(response) {
        console.log(response);
        if (response.data.length != 0)  
          $scope.data = response.data[0].playerSeason;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
