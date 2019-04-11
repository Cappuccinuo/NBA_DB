app.controller('teamsGameCtrl', ['$scope', '$stateParams', 'httpService', 'uiGridConstants', function($scope, $stateParams, httpService, uiGridConstants) {
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
          { field: 'game_date', displayName: 'Game Date', width: 110},
          { field: 'matchup', displayName: 'Matchup', width: 100},
          { field: 'wl', displayName: 'W/L', width: 50},
          { field: 'fgm', displayName: 'FGM', width: 50},
          { field: 'fga', displayName: 'FGA', width: 50},
          { field: 'fg_pct', displayName: 'FG%', width: 55},
          { field: 'fg3m', displayName: '3PM', width: 50},
          { field: 'fg3a', displayName: '3PA', width: 50},
          { field: 'fg3_pct', displayName: '3P%', width: 50},
          { field: 'ftm', displayName: 'FTM', width: 50},
          { field: 'fta', displayName: 'FTA', width: 50},
          { field: 'ft_pct', displayName: 'FT%', width: 50},
          { field: 'o_reb', displayName: 'OREB', width: 60},
          { field: 'd_reb', displayName: 'DREB', width: 60},
          { field: 'reb', displayName: 'REB', width: 50},
          { field: 'ast', displayName: 'AST', width: 50},
          { field: 'pf', displayName: 'PF', width: 50},
          { field: 'stl', displayName: 'STL', width: 50},
          { field: 'tov', displayName: 'TOV', width: 50},
          { field: 'blk', displayName: 'BLK', width: 50},
          { field: 'pts', displayName: 'PTS', width: 50},
        ]
    };

    $scope.num = "10";
    httpService.getTeamGame($stateParams.id, $scope.num).then(function(response) {
        console.log(response);
        $scope.gridOptions.data = response.data;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
