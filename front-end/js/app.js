/* global angular */
/* global permissions */
/*global $scope*/


var app = angular.module('myApp', ['ui.router', 'ui.grid', 'ui.grid.edit', 'ui.grid.rowEdit', 'ui.grid.cellNav', 'ui.grid.saveState', 'ui.bootstrap','dialogs', 'ngSanitize', 'ui.select']);


app.config(function($stateProvider, $urlRouterProvider) {
   $urlRouterProvider.otherwise('/home');

    $stateProvider
    .state("home", {
        url : "/home",
        templateUrl : "views/home.html",
        controller : "homeCtrl"
    })
    .state("players", {
        url : "/players",
        templateUrl : "views/players.html",
        controller : "playersCtrl"
    })
    .state("pdetail", {
        url : "/players/:id",
        templateUrl : "views/players_detail.html",
        controller : "playersDetailCtrl",
        params: {data: null}
    })
    .state("pdetail.pseason", {
        url : "/pseason",
        templateUrl : "views/players_season.html",
        controller : "playersSeasonCtrl"
    })
    .state("pdetail.pgame", {
        url : "/pgame",
        templateUrl : "views/players_game.html",
        controller : "playersGameCtrl"
    })
    .state("pdetail.pbackground", {
        url : "/pbackground",
        templateUrl : "views/players_background.html",
        controller : "playersBackgroundCtrl"
    })
    .state("pcreate", {
        url : "/pcreate",
        templateUrl : "views/player_new.html",
        controller : "playerNewCtrl"
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
        url : "/tseason",
        templateUrl : "views/teams_season.html",
        controller : "teamsSeasonCtrl"
    })
    .state("tdetail.tgame", {
        url : "/tgame",
        templateUrl : "views/teams_game.html",
        controller : "teamsGameCtrl"
    })
    .state("tdetail.tplayer", {
        url : "/tplayer",
        templateUrl : "views/teams_player.html",
        controller : "teamsPlayerCtrl"
    })
    .state("tdetail.tbackground", {
        url : "/tbackground",
        templateUrl : "views/teams_background.html",
        controller : "teamsBackgroundCtrl"
    })
    .state("games", {
        url : "/games",
        templateUrl : "views/games.html",
        controller : "gamesCtrl"
    })
    .state("gdetail", {
        url : "/games/:id",
        templateUrl : "views/games_detail.html",
        controller : "gamesDetailCtrl",
        params: {data: null}
    })
    .state("gdetail.gteam", {
        url : "/gteam/:tid",
        templateUrl : "views/games_team.html",
        controller : "gamesTeamCtrl"
    })
    .state("gdetail.gstats", {
        url : "/gstats",
        templateUrl : "views/games_stats.html",
        controller : "gamesStatsCtrl"
    })
    .state("gcreate", {
        url : "/gcreate",
        templateUrl : "views/game_new.html",
        controller : "gameNewCtrl"
    })
    .state("gupdate", {
        url : "/gupdate/:id",
        templateUrl : "views/games_update.html",
        controller : "gamesUpdateCtrl",
        params: {data: null}
    })
    .state("gupdate.uteam", {
        url : "/uteam/:tid",
        templateUrl : "views/games_update_team.html",
        controller : "gamesUpdateTeamCtrl"
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

