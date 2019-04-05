/* global angular */
/* global permissions */
/*global $scope*/


var app = angular.module('myApp', ['ui.router', 'ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.cellNav', 'ui.grid.saveState']);


app.config(function($stateProvider, $urlRouterProvider) {
   $urlRouterProvider.otherwise('/home');

    $stateProvider
    .state("home", {
        url : "/home",
        templateUrl : "views/home.html",
        controller : "homeCtrl"
    })
    .state("books", {
        url : "/books",
        templateUrl : "views/books.html",
        controller : "booksCtrl"
    })
    .state("teams", {
        url : "/teams",
        templateUrl : "views/teams.html",
        controller : "teamsCtrl"
    })
    .state("tdetail", {
        url : "/teams/:id",
        templateUrl : "views/teams_detail.html",
        controller : "teamsDetailCtrl",
        params: {data: null}
    })
    .state("tdetail.tseason", {
        url : "/season",
        templateUrl : "views/teams_season.html",
        controller : "teamsSeasonCtrl"
    })
    .state("tdetail.tgame", {
        url : "/game",
        templateUrl : "views/teams_game.html",
        controller : "teamsGameCtrl"
    })
    .state("tdetail.tplayer", {
        url : "/player",
        templateUrl : "views/teams_player.html",
        controller : "teamsPlayerCtrl"
    })
    .state("tdetail.tbackground", {
        url : "/background",
        templateUrl : "views/teams_background.html",
        controller : "teamsBackgroundCtrl"
    })
    .state("nav", {
        templateUrl : "views/nav.html",
        controller : "navCtrl"
    });
})
//kicks user back to homepage if they log out, prevents them from navigating unless they log in
.run(['$rootScope', '$state', function($rootScope, $state) {
    $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams, options){ 
        console.log("stateChangeStart");
    });
    $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
        console.log("stateChangeSuccess");
    });
 }]);

