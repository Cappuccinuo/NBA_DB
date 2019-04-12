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

app.controller('playerNewCtrl', ['$scope', '$stateParams', '$state', 'httpService', '$dialogs', function($scope, $stateParams, $state, httpService, $dialogs) {
    $scope.data = $stateParams.data;
    console.log("Player new");

    $scope.teams = [];
    $scope.data = {
        "birthdate": "",
        "country": "",
        "draft_number": "",
        "draft_round": "",
        "draft_year": "",
        "first_name": "",
        "from_year": "",
        "height": "",
        "last_name": "",
        "name": "",
        "person_id": "",
        "position": "",
        "rosterstatus": "",
        "school": "",
        "to_year": "",
        "weight": ""
      };
    $scope.tmp = {};

    $scope.playerTeam = { "team_id": "", "player_id": ""};

    $scope.createNewPlayer = function () {
        console.log($scope.tmp.selectedTeam);
        $scope.playerTeam.team_id = $scope.tmp.selectedTeam.team_id;
        $scope.playerTeam.player_id = $scope.data.person_id;
        var d = $scope.tmp.birthdate;
        $scope.data.birthdate = d.toISOString().substring(0, 10);
        $scope.data.name = $scope.data.first_name + " " + $scope.data.last_name;
        console.log($scope.data);
        var dlg = null;
        dlg = $dialogs.confirm('Please Confirm','Are you sure that you want to create a new player?');
        /*
        dlg.result.then(function(btn){
            httpService.createPlayer($scope.data).then(function(response) {
                console.log(response);
                alert("Create successfully!");
                //$state.transitionTo("pdetail", {id: $stateParams.id, data: $scope.data});
            }).catch(function (result) {
                console.log(result);
                alert(result);
            });
        }, function(btn){
            console.log("no update");
        });
        */
       dlg.result.then(function(btn){
            httpService.checkPlayerId($scope.data.person_id).then(function(response) {
                console.log(response);
                alert("Player ID existed! Please enter a different Player ID.");
            }).catch(function (result) {
                console.log(result);
                httpService.createPlayer($scope.data).then(function(response) {
                    console.log("Create player successfully");
                    httpService.createPlayerTeam($scope.playerTeam).then(function(response) {
                      console.log("Create player-team successfully");
                        alert("Create successfully!");
                        $state.transitionTo("pdetail", {id: $scope.data.person_id, data: $scope.data});
                    }).catch(function (result) {
                        console.log("Create player-team wrongly");
                        console.log(result);
                        alert(result);
                    });
                }).catch(function (result) {
                    console.log("Create player wrongly");
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
