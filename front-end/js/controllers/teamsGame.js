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
          { field: 'gameInfo.date', displayName: 'Game Date', width: 110},
          { field: 'gameInfo.match_up', displayName: 'Matchup', width: 100},
          { field: 'gameInfo.score', displayName: 'Score', width: 90},
          { field: 'teamGame.fgm', displayName: 'FGM', width: 50},
          { field: 'teamGame.fga', displayName: 'FGA', width: 50},
          { field: 'teamGame.fg_pct', displayName: 'FG%', width: 55},
          { field: 'teamGame.fg3m', displayName: '3PM', width: 50},
          { field: 'teamGame.fg3a', displayName: '3PA', width: 50},
          { field: 'teamGame.fg3_pct', displayName: '3P%', width: 50},
          { field: 'teamGame.ftm', displayName: 'FTM', width: 50},
          { field: 'teamGame.fta', displayName: 'FTA', width: 50},
          { field: 'teamGame.ft_pct', displayName: 'FT%', width: 50},
          { field: 'teamGame.o_reb', displayName: 'OREB', width: 60},
          { field: 'teamGame.d_reb', displayName: 'DREB', width: 60},
          { field: 'teamGame.reb', displayName: 'REB', width: 50},
          { field: 'teamGame.ast', displayName: 'AST', width: 50},
          { field: 'teamGame.pf', displayName: 'PF', width: 50},
          { field: 'teamGame.stl', displayName: 'STL', width: 50},
          { field: 'teamGame.tov', displayName: 'TOV', width: 50},
          { field: 'teamGame.blk', displayName: 'BLK', width: 50}
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
