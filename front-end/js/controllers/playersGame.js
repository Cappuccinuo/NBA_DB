app.controller('playersGameCtrl', ['$scope', '$stateParams', 'httpService', 'uiGridConstants', function($scope, $stateParams, httpService, uiGridConstants) {
    console.log("Team Game");

    $scope.gridOptions = {
        enableHorizontalScrollbar: uiGridConstants.scrollbars.WHEN_NEEDED,
        enableCellSelection: true,
        enableColumnMenus: false,
        enableSorting: true,
        enableFiltering: true,
        saveScroll: true,
        onRegisterApi: function (gridApi) {
          $scope.gridApi = gridApi;
        },
      
        columnDefs: [
          { field: 'date', displayName: 'Game Date', width: 120},
          { field: 'matchup', displayName: 'Matchup', width: 100},
          { field: 'playerGame.start_position', displayName: 'P', width: 40},
          { field: 'playerGame.min', displayName: 'MIN', width: 50},
          { field: 'playerGame.fgm', displayName: 'FGM', width: 50},
          { field: 'playerGame.fga', displayName: 'FGA', width: 50},
          { field: 'playerGame.fg_pct', displayName: 'FG%', width: 55},
          { field: 'playerGame.fg3m', displayName: '3PM', width: 50},
          { field: 'playerGame.fg3a', displayName: '3PA', width: 50},
          { field: 'playerGame.fg3_pct', displayName: '3P%', width: 50},
          { field: 'playerGame.ftm', displayName: 'FTM', width: 50},
          { field: 'playerGame.fta', displayName: 'FTA', width: 50},
          { field: 'playerGame.ft_pct', displayName: 'FT%', width: 50},
          { field: 'playerGame.o_reb', displayName: 'OREB', width: 60},
          { field: 'playerGame.d_reb', displayName: 'DREB', width: 60},
          { field: 'playerGame.reb', displayName: 'REB', width: 50},
          { field: 'playerGame.ast', displayName: 'AST', width: 50},
          { field: 'playerGame.pf', displayName: 'PF', width: 50},
          { field: 'playerGame.stl', displayName: 'STL', width: 50},
          { field: 'playerGame.tov', displayName: 'TOV', width: 50},
          { field: 'playerGame.blk', displayName: 'BLK', width: 50},
          { field: 'playerGame.pts', displayName: 'PTS', width: 50},
          { field: 'playerGame.plus_minus', displayName: '+/-', width: 50}
        ]
    };

    $scope.num = "10";
    httpService.getPlayerGame($stateParams.id, $scope.num).then(function(response) {
        console.log(response);
        $scope.gridOptions.data = response.data;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
