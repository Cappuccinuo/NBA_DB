app.controller('playersCtrl', ['$scope', 'httpService', '$state', function($scope, httpService, $state) {
    $scope.searchPlayer = function () {
        httpService.findPlayer($scope.name).then(function(response) {
            console.log(response);
            if (response.data.length == 0) {
                alert("No such player! Please search again.");
                $state.reload();
            }
            else {
                console.log(response.data[0]);
                $state.transitionTo("pdetail", {id: response.data[0].person_id, data: response.data[0]});
            }
            //$state.transitionTo("teams");
        }).catch(function (result) {
            console.log(result);
            alert(result);
        });
    }    
}]);