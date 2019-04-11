app.controller('teamsCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
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
        $state.transitionTo("tdetail", {id: row.entity.team_id, data: row.entity});
      });
    },
  
    columnDefs: [
      { field: 'abbreviation', displayName: 'Abbreviation'},
      { field: 'nickname', displayName: 'Nick name'},
      { field: 'year_founded', displayName: 'Year Found'},
      { field: 'city', displayName: 'City'},
      { field: 'arena', displayName: 'Arena', cellTooltip: true},
      { field: 'arena_capacity', displayName: 'Arena Capacity'},
      { field: 'owner', displayName: 'owner', cellTooltip: true},
      { field: 'general_manager', displayName: 'GM', cellTooltip: true},
      { field: 'head_coach', displayName: 'Head Coach', cellTooltip: true},
      { field: 'affiliation', displayName: 'Affiliation', cellTooltip: true}
    ]
  };


  
  httpService.getTeamsInfo().then(function(response) {
    console.log(response);
    $scope.gridOptions.data = response.data;
    //$scope.gridOptions.data = $scope.testData;
  }).catch(function (result) {
      console.log(result);
      //alert(result);
  });
    
}]);

