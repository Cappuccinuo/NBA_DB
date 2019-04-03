app.service('httpService', function ($http) {
    function getTeamsInfo () {
        return $http.get("http://localhost:8080/api/teambg");
    }

    return {

        getTeamsInfo : getTeamsInfo

    };
});
