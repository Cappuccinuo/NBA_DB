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
    .state("teams.detail", {
        url : "/detail",
        templateUrl : "views/teams_detail.html",
        controller : "teamsDetailCtrl"
    })
    .state("nav", {
        templateUrl : "views/nav.html",
        controller : "navCtrl"
    });
})
//kicks user back to homepage if they log out, prevents them from navigating unless they log in
.run(['$rootScope', '$state', function($rootScope, $state) {

 }]);

