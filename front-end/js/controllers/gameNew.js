app.filter('propsFilter', function() {
    return function(items, props) {
      var out = [];
  
      if (angular.isArray(items)) {
        var keys = Object.keys(props);
  
        items.forEach(function(item) {
          var itemMatches = false;
  
          for (var i = 0; i < keys.length; i++) {
            var prop = keys[i];
            var text = props[prop].toLowerCase();
            if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
              itemMatches = true;
              break;
            }
          }
  
          if (itemMatches) {
            out.push(item);
          }
        });
      } else {
        // Let the output be the input untouched
        out = items;
      }
  
      return out;
    };
  });

app.controller('gameNewCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    $scope.data = $stateParams.data;
    console.log("Game new");

    $scope.teams = [];
    $scope.data = {
        "game_id": "",
        "game_date": "",
        "season": "2017-18",
        "away_team_id": "",
        "home_team_id": ""
      };
    $scope.tmp = {};

    $scope.createNewGame = function () {
        console.log($scope.tmp.selectedAwayTeam);
        console.log($scope.tmp.selectedHomeTeam);
        $scope.data.away_team_id = $scope.tmp.selectedAwayTeam.team_id;
        $scope.data.home_team_id = $scope.tmp.selectedHomeTeam.team_id;
        
        var d = $scope.tmp.game_date.toString();
        var d_arr = d.split(" ");
        $scope.data.game_date = d_arr[1] + " " + d_arr[2] + ", " + d_arr[3];
        console.log($scope.data);
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to create a new game?');
        dlg.result.then(function(btn){
            httpService.checkGameId($scope.data.game_id).then(function(response) {
                console.log(response);
                alert("Game ID existed! Please enter a different Game ID.");
            }).catch(function (result) {
                console.log(result);
                httpService.createGame($scope.data).then(function(response) {
                    console.log("Create game successfully");
                    $state.transitionTo("games");
                }).catch(function (result) {
                    console.log("Create game wrongly");
                    console.log(result);
                    alert(result);
                });
            });
        }, function(btn){
            console.log("no update");
        });
    }

    httpService.getTeamsInfo().then(function(response) {
        console.log(response);
        $scope.teams = response.data;
        //$scope.gridOptions.data = $scope.testData;
    }).catch(function (result) {
        console.log(result);
        //alert(result);
    });
}]);
