/* global app */
app.controller('navCtrl', function($scope, $rootScope, $location, $state) {

$scope.logOut = function(){
   $rootScope.loggedIn = false;
   $rootScope.logInName = "";
   $rootScope.logInId = "";
   $location.path('home');
   $state.reload();
 };

});