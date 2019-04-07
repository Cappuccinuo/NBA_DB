app.controller('teamsPlayerCtrl', ['$scope', '$stateParams', 'httpService', 'uiGridConstants', function($scope, $stateParams, httpService, uiGridConstants) {
    console.log("Team player");

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
          { field: 'first_name', displayName: 'First Name', width: 100, cellTooltip: true},
          { field: 'last_name', displayName: 'Last Name', width: 100, cellTooltip: true},
          { field: 'school', displayName: 'School', width: 100, cellTooltip: true},
          { field: 'country', displayName: 'Country', width: 100, cellTooltip: true},
          { field: 'height', displayName: 'Height (ft-in)', width: 110},
          { field: 'weight', displayName: 'Weight (lb)', width: 100},
          { field: 'position', displayName: 'Position', width: 100, cellTooltip: true},
          { field: 'rosterstatus', displayName: 'Status', width: 100},
          { field: 'from_year', displayName: 'From Year', width: 100},
          { field: 'to_year', displayName: 'To Year', width: 100},
          { field: 'draft_year', displayName: 'Draft Year', width: 100},
          { field: 'draft_round', displayName: 'Draft Round', width: 110},
          { field: 'draft_number', displayName: 'Draft Number', width: 120}
        ]
    };

    $scope.num = "10";
    httpService.getTeamPlayer($stateParams.id).then(function(response) {
        console.log(response);
        $scope.gridOptions.data = response.data;
    }).catch(function (result) {
      console.log(result);
      //alert(result);
    });
}]);
