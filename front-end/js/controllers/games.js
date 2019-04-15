app.controller('gamesCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
    $scope.data = { isSubmitted: false };
    
    
    //team grid setup
    $scope.gridOptions = {
  
      enableCellSelection: true,
      enableColumnMenus: false,
      enableSorting: true,
      enableFiltering: true,
      saveScroll: true,
      enableRowSelection: true,
      enableRowHeaderSelection: true,
      multiSelect: false,
      onRegisterApi: function (gridApi) {
        $scope.gridApi = gridApi;
        gridApi.selection.on.rowSelectionChanged($scope, function (row) {
          $state.transitionTo("gdetail", {id: row.entity.game_id, data: row.entity});
        });
      },
    
      columnDefs: [
        { field: 'away_team', displayName: 'Away Team'},
        { field: 'home_team', displayName: 'Home Team'},
        { field: 'away_score', displayName: 'Away Score'},
        { field: 'home_score', displayName: 'Home Score'},
        { name: 'Update',
          cellTemplate : '<div class="ui-grid-cell-contents"><button type="button" class="btn btn-primary btn-sm" ui-sref= "gupdate({id: row.entity.game_id, data: row.entity})">Update</button></div>'
        }
      ]
    };


    $scope.searchGames = function () {
        var d = $scope.data.date.toString();
        var d_arr = d.split(" ");
        $scope.data.parsedDate = d_arr[1] + " " + d_arr[2] + ", " + d_arr[3];
        console.log($scope.data);
        httpService.getGamesByDate($scope.data.parsedDate).then(function(response) {
            console.log(response);
            if (response.data.length == 0) {
                alert("There is no game on " + $scope.data.parsedDate + "!");
                $state.reload();
            }
            $scope.gridOptions.data = response.data;
            $scope.data.isSubmitted = true;
        }).catch(function (result) {
            console.log(result);
        });
    }      
  }]);
  
  