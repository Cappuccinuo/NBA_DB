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
          { field: 'playerGame.start_position', displayName: 'Start Position', width: 120},
          { field: 'playerGame.min', displayName: 'Minutes', width: 100},
          { field: 'playerGame.fgm', displayName: 'Field Goals Made', width: 150},
          { field: 'playerGame.fga', displayName: 'Field Goals Attempted', width: 180},
          { field: 'playerGame.fg_pct', displayName: 'Field Goals Percentage', width: 180},
          { field: 'playerGame.fg3m', displayName: 'Three Point Made', width: 150},
          { field: 'playerGame.fg3a', displayName: 'Three Point Attempted', width: 180},
          { field: 'playerGame.fg3_pct', displayName: 'Three Point Percentage', width: 180},
          { field: 'playerGame.ftm', displayName: 'Free Throws Made', width: 150},
          { field: 'playerGame.fta', displayName: 'Free Throws Attempted', width: 180},
          { field: 'playerGame.ft_pct', displayName: 'Free Throws Percentage', width: 200},
          { field: 'playerGame.o_reb', displayName: 'Offensive Rebounds', width: 180},
          { field: 'playerGame.d_reb', displayName: 'Defensive Rebounds', width: 180},
          { field: 'playerGame.reb', displayName: 'Rebounds', width: 100},
          { field: 'playerGame.ast', displayName: 'Assists', width: 100},
          { field: 'playerGame.pf', displayName: 'Personal Fouls', width: 150},
          { field: 'playerGame.stl', displayName: 'Steals', width: 100},
          { field: 'playerGame.tov', displayName: 'Turnovers', width: 100},
          { field: 'playerGame.blk', displayName: 'Blocks', width: 100},
          { field: 'playerGame.pts', displayName: 'Points', width: 100},
          { field: 'playerGame.plus_minus', displayName: 'Plus Minus', width: 100}
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
