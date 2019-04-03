/* global app */
/* global angular */

app.controller('teamsCtrl', ['$scope', 'httpService', function($scope, httpService) {
  $scope.testData = [{"team_id":"1610612737","abbrevation":null,"nickname":"Hawks","year_founded":"1949","city":"Atlanta","arena":"State Farm Arena","arena_capacity":"18729","owner":"Tony Ressler","general_manager":"Travis Schlenk","head_coach":"Lloyd Pierce","affiliation":"Erie Bayhawks"},{"team_id":"1610612738","abbrevation":null,"nickname":"Celtics","year_founded":"1946","city":"Boston","arena":"TD Garden","arena_capacity":"18624","owner":"Wyc Grousbeck","general_manager":"Danny Ainge","head_coach":"Brad Stevens","affiliation":"Maine Red Claws"},{"team_id":"1610612739","abbrevation":null,"nickname":"Cavaliers","year_founded":"1970","city":"Cleveland","arena":"Quicken Loans Arena","arena_capacity":"20562","owner":"Dan Gilbert","general_manager":"Koby Altman","head_coach":"Larry Drew","affiliation":"Canton Charge"},{"team_id":"1610612740","abbrevation":null,"nickname":"Pelicans","year_founded":"2002","city":"New Orleans","arena":"Smoothie King Center","arena_capacity":"","owner":"Tom Benson","general_manager":"Dell Demps","head_coach":"Alvin Gentry","affiliation":"No Affiliate"},{"team_id":"1610612741","abbrevation":null,"nickname":"Bulls","year_founded":"1966","city":"Chicago","arena":"United Center","arena_capacity":"21711","owner":"Jerry Reinsdorf","general_manager":"Gar Forman","head_coach":"Jim Boylen","affiliation":"Windy City Bulls"},{"team_id":"1610612742","abbrevation":null,"nickname":"Mavericks","year_founded":"1980","city":"Dallas","arena":"American Airlines Center","arena_capacity":"19200","owner":"Mark Cuban","general_manager":"Donnie Nelson","head_coach":"Rick Carlisle","affiliation":"Texas Legends"},{"team_id":"1610612743","abbrevation":null,"nickname":"Nuggets","year_founded":"1976","city":"Denver","arena":"Pepsi Center","arena_capacity":"19099","owner":"Stan Kroenke","general_manager":"Tim Connelly","head_coach":"Michael Malone","affiliation":"No Affiliate"},{"team_id":"1610612744","abbrevation":null,"nickname":"Warriors","year_founded":"1946","city":"Golden State","arena":"ORACLE Arena","arena_capacity":"19596","owner":"Joe Lacob","general_manager":"Bob Myers","head_coach":"Steve Kerr","affiliation":"Santa Cruz Warriors"},{"team_id":"1610612745","abbrevation":null,"nickname":"Rockets","year_founded":"1967","city":"Houston","arena":"Toyota Center","arena_capacity":"18104","owner":"Tilman Fertitta","general_manager":"Daryl Morey","head_coach":"Mike D'Antoni","affiliation":"Rio Grande Valley Vipers"},{"team_id":"1610612746","abbrevation":null,"nickname":"Clippers","year_founded":"1970","city":"Los Angeles","arena":"Staples Center","arena_capacity":"19060","owner":"Steve Ballmer","general_manager":"Michael Winger","head_coach":"Doc Rivers","affiliation":"Agua Caliente Clippers of Ontario"},{"team_id":"1610612747","abbrevation":null,"nickname":"Lakers","year_founded":"1948","city":"Los Angeles","arena":"Staples Center","arena_capacity":"19060","owner":"Jerry Buss Family Trust","general_manager":"Rob Pelinka","head_coach":"Luke Walton","affiliation":"South Bay Lakers"},{"team_id":"1610612748","abbrevation":null,"nickname":"Heat","year_founded":"1988","city":"Miami","arena":"AmericanAirlines Arena","arena_capacity":"19600","owner":"Micky Arison","general_manager":"Pat Riley","head_coach":"Erik Spoelstra","affiliation":"Sioux Falls Skyforce"},{"team_id":"1610612749","abbrevation":null,"nickname":"Bucks","year_founded":"1968","city":"Milwaukee","arena":"Fiserv Forum","arena_capacity":"17500","owner":"Wesley Edens & Marc Lasry","general_manager":"Jon Horst","head_coach":"Mike Budenholzer","affiliation":"Wisconsin Herd"},{"team_id":"1610612750","abbrevation":null,"nickname":"Timberwolves","year_founded":"1989","city":"Minnesota","arena":"Target Center","arena_capacity":"19356","owner":"Glen Taylor","general_manager":"Scott Layden","head_coach":"Ryan Saunders","affiliation":"Iowa Wolves"},{"team_id":"1610612751","abbrevation":null,"nickname":"Nets","year_founded":"1976","city":"Brooklyn","arena":"Barclays Center","arena_capacity":"","owner":"Mikhail Prokhorov","general_manager":"Sean Marks","head_coach":"Kenny Atkinson","affiliation":"Long Island Nets"},{"team_id":"1610612752","abbrevation":null,"nickname":"Knicks","year_founded":"1946","city":"New York","arena":"Madison Square Garden","arena_capacity":"19763","owner":"Cablevision (James Dolan)","general_manager":"Steve Mills","head_coach":"David Fizdale","affiliation":"Westchester Knicks"},{"team_id":"1610612753","abbrevation":null,"nickname":"Magic","year_founded":"1989","city":"Orlando","arena":"Amway Center","arena_capacity":"0","owner":"Rick DeVos","general_manager":"John Hammond","head_coach":"Steve Clifford","affiliation":"Lakeland Magic"},{"team_id":"1610612754","abbrevation":null,"nickname":"Pacers","year_founded":"1976","city":"Indiana","arena":"Bankers Life Fieldhouse","arena_capacity":"18345","owner":"Herb Simon","general_manager":"Kevin Pritchard","head_coach":"Nate McMillan","affiliation":"Fort Wayne Mad Ants"},{"team_id":"1610612755","abbrevation":null,"nickname":"76ers","year_founded":"1949","city":"Philadelphia","arena":"Wells Fargo Center","arena_capacity":"","owner":"Joshua Harris","general_manager":" ","head_coach":"Brett Brown","affiliation":"Delaware Blue Coats"},{"team_id":"1610612756","abbrevation":null,"nickname":"Suns","year_founded":"1968","city":"Phoenix","arena":"Talking Stick Resort Arena","arena_capacity":"","owner":"Robert Sarver","general_manager":"Ryan McDonough","head_coach":"Igor Kokoskov","affiliation":"Northern Arizona Suns"},{"team_id":"1610612757","abbrevation":null,"nickname":"Trail Blazers","year_founded":"1970","city":"Portland","arena":"Moda Center","arena_capacity":"19980","owner":"Paul Allen","general_manager":"Neil Olshey","head_coach":"Terry Stotts","affiliation":"No Affiliate"},{"team_id":"1610612758","abbrevation":null,"nickname":"Kings","year_founded":"1948","city":"Sacramento","arena":"Golden 1 Center","arena_capacity":"17500","owner":"Vivek Ranadive","general_manager":"Vlade Divac","head_coach":"David Joerger","affiliation":"Stockton Kings"},{"team_id":"1610612759","abbrevation":null,"nickname":"Spurs","year_founded":"1976","city":"San Antonio","arena":"AT&T Center","arena_capacity":"18694","owner":"Peter Holt","general_manager":"R. C. Buford","head_coach":"Gregg Popovich","affiliation":"Austin Spurs"},{"team_id":"1610612760","abbrevation":null,"nickname":"Thunder","year_founded":"1967","city":"Oklahoma City","arena":"Chesapeake Energy Arena","arena_capacity":"19163","owner":"Clay Bennett","general_manager":"Sam Presti","head_coach":"Billy Donovan","affiliation":"Oklahoma City Blue"},{"team_id":"1610612761","abbrevation":null,"nickname":"Raptors","year_founded":"1995","city":"Toronto","arena":"Scotiabank Arena","arena_capacity":"19800","owner":"Maple Leaf Sports and Entertainment","general_manager":"Masai Ujiri","head_coach":"Nick Nurse","affiliation":"Raptors 905"},{"team_id":"1610612762","abbrevation":null,"nickname":"Jazz","year_founded":"1974","city":"Utah","arena":"Vivint Smart Home Arena","arena_capacity":"20148","owner":"Greg Miller","general_manager":"Dennis Lindsey","head_coach":"Quin Snyder","affiliation":"Salt Lake City Stars"},{"team_id":"1610612763","abbrevation":null,"nickname":"Grizzlies","year_founded":"1995","city":"Memphis","arena":"FedExForum","arena_capacity":"18119","owner":"Robert Pera","general_manager":"Chris Wallace","head_coach":"JB Bickerstaff","affiliation":"Memphis Hustle"},{"team_id":"1610612764","abbrevation":null,"nickname":"Wizards","year_founded":"1961","city":"Washington","arena":"Capital One Arena","arena_capacity":"20647","owner":"Ted Leonsis","general_manager":"Ernie Grunfeld","head_coach":"Scott Brooks","affiliation":"Capital City Go-Go"},{"team_id":"1610612765","abbrevation":null,"nickname":"Pistons","year_founded":"1948","city":"Detroit","arena":"Little Caesars Arena","arena_capacity":"21000","owner":"Tom Gores","general_manager":"Jeff Bower","head_coach":"Dwane Casey","affiliation":"Grand Rapids Drive"},{"team_id":"1610612766","abbrevation":null,"nickname":"Hornets","year_founded":"1988","city":"Charlotte","arena":"Spectrum Center","arena_capacity":"19026","owner":"Michael Jordan","general_manager":"Mitch Kupchak","head_coach":"James Borrego","affiliation":"Greensboro Swarm"}];

  //team grid setup
  $scope.gridOptions = {

    enableCellSelection: true,
    enableColumnMenus: false,
    enableSorting: true,
    enableFiltering: true,
    saveScroll: true,
    enableRowSelection: true,
    enableRowHeaderSelection: true,
    onRegisterApi: function (gridApi) {
      $scope.gridApi = gridApi;
      gridApi.selection.on.rowSelectionChanged($scope, function (row) {
        $state.go("team.details", {id: row.entity.team_id});
      });
    },
  
    columnDefs: [
      { field: 'abbreviation', displayName: 'Abbreviation'},
      { field: 'nickname', displayName: 'Team Nick name'},
      { field: 'year_found', displayName: 'Year Found'},
      { field: 'city', displayName: 'City'},
      { field: 'arena', displayName: 'Arena'},
      { field: 'arena_capacity', displayName: 'Arena Capacity '},
      { field: 'owner', displayName: 'owner'},
      { field: 'general_manager', displayName: 'GM'},
      { field: 'head_coach', displayName: 'Head Coach'},
      { field: 'affiliation', displayName: 'Affiliation'}
    ]
  };


  
  httpService.getTeamsInfo().then(function(response) {
    console.log(response);
    //$scope.gridOptions.data = response.data;
    $scope.gridOptions.data = $scope.testData;
  }).catch(function (result) {
      console.log(result);
      alert(result);
  });
  
  //saving in the new author modal
  $scope.addNewItem = function() {
    var n = $scope.authorData.length + 1;
    $scope.authorData.push( { id: n, name: $scope.newAuthorName, age: $scope.newAuthorAge});
    modal.css('display', 'none');
    };
    
   // get the modal
    var modal = angular.element( document.querySelector( '#authorModalBody' ) );

    // when the user clicks on the create new author button, open the modal 
    $scope.openModal = function() {
        modal.css('display', 'block');
    };
    
    //clicking cancel once modal is open, or closing the modal after saving
    $scope.closeModal = function() {
        modal.css('display', 'none');
    };
    
}]);

