/* global app */
app.controller('loginCtrl', function($scope, $rootScope, $location, $state, enableEditService) {

$scope.users=[
    {
        id: 1, 
        username: "librarian", 
        password: "librarian", 
        name: "Librarian", 
        active: true,
        permission: 1
    },
    {
        id: 2, 
        username: "visitor", 
        password: "visitor", 
        name: "Wally West", 
        active: true,
        permission: 2
    },
    {
        id: 3, 
        username: "member", 
        password: "member", 
        name: "Clark Kent", 
        active: true,
        permission: 2
    },
    {
        id: 4, 
        username: "banned", 
        password: "banned", 
        name: "Evil Doer", 
        active: false,
        permission: 2
    },
    {
        id: 5, 
        username: "admin", 
        password: "admin", 
        name: "administrator", 
        active: true,
        permission: 1
    },
    {
        id: 6, 
        username: "borrower", 
        password: "borrower", 
        name: "Bella Borrower", 
        active: true,
        permission: 2
    }
];

$scope.logInMessage = "";
$scope.errorMessage = "";
$rootScope.logInId = "";
$rootScope.logInPermission = "";
$rootScope.logInActive = "";

//main log in function: loops through the users array and compares it with whatever the user typed into the login inputs
$scope.loginMatch = function() {
    for(var i = 0; i < $scope.users.length; i++) {
        
         if ($scope.usernameinput == $scope.users[i].username) {
          if ($scope.passwordinput == $scope.users[i].password) {
           if ($scope.users[i].active == true) {
            //if username and password input is a match and the user is active, do all these things  
            $rootScope.logInId = $scope.users[i].id;
            $rootScope.logInName = $scope.users[i].name;
            $rootScope.logInPermission = $scope.users[i].permission;
            $rootScope.logInActive = $scope.users[i].active;
            $scope.errorMessage = "";
            $rootScope.loggedIn = true;
            
            //permissions
            if($rootScope.logInPermission == 1){ //librarian and admin - permission: 1 is edit privileges
                 enableEditService.edit = true;
             }
             else { //everyone else
                 enableEditService.edit = false;
             }
            }
            //banned user, active = false
            $scope.errorMessage = "Sorry, this user is no longer active.";
            $scope.loginForm.$setUntouched();
            $scope.loginForm.$setPristine();
            return;
         
          } else { //password doesn't match
            $scope.errorMessage = "Login attempt not successful. Please try again.";
            $scope.loginForm.$setUntouched();
            $scope.loginForm.$setPristine();
            return;
          }
        } 
        
        if ($scope.usernameinput != $scope.users[i].username) { //if the username input doesn't match any of our users
            $scope.errorMessage = "User does not exist.";
            $scope.loginForm.$setUntouched();
            $scope.loginForm.$setPristine();
            }
  
    } 
    //if the fields are blank and submitted
    if(!$scope.usernameinput){ 
        if(!$scope.passwordinput){
            $scope.errorMessage = "Please provide login details."; 
        }
        else { //if the username field is empty when submitted
             $scope.errorMessage = "Please enter a username.";
        }
    } else if(!$scope.passwordinput){  //if the password field is empty when submitted
        $scope.errorMessage = "Please enter a password.";
    }
  
}; 

}); 
