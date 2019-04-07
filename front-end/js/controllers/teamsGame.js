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
          { field: 'game_date', displayName: 'Game Date', width: 120},
          { field: 'matchup', displayName: 'Matchup', width: 100},
          { field: 'wl', displayName: 'Result', width: 100},
          { field: 'min', displayName: 'Minutes', width: 100},
          { field: 'fgm', displayName: 'Field Goals Made', width: 150},
          { field: 'fga', displayName: 'Field Goals Attempted', width: 180},
          { field: 'fg_pct', displayName: 'Field Goals Percentage', width: 180},
          { field: 'fg3m', displayName: 'Three Point Made', width: 150},
          { field: 'fg3a', displayName: 'Three Point Attempted', width: 180},
          { field: 'fg3_pct', displayName: 'Three Point Percentage', width: 180},
          { field: 'ftm', displayName: 'Free Throws Made', width: 150},
          { field: 'fta', displayName: 'Free Throws Attempted', width: 180},
          { field: 'ft_pct', displayName: 'Free Throws Percentage', width: 200},
          { field: 'o_reb', displayName: 'Offensive Rebounds', width: 180},
          { field: 'd_reb', displayName: 'Defensive Rebounds', width: 180},
          { field: 'reb', displayName: 'Rebounds', width: 100},
          { field: 'ast', displayName: 'Assists', width: 100},
          { field: 'pf', displayName: 'Personal Fouls', width: 150},
          { field: 'stl', displayName: 'Steals', width: 100},
          { field: 'tov', displayName: 'Turnovers', width: 100},
          { field: 'blk', displayName: 'Blocks', width: 100},
          { field: 'pts', displayName: 'Points', width: 100},
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
