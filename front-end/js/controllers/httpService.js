app.service('httpService', function ($http) {
    function getTeamsInfo () {
        return $http.get("http://localhost:8080/api/teambg");
    }

    function getTeamSeason(id, season) {
        return $http.get("http://localhost:8080/api/teamseason/" + id + "&" + season);
    }

    return {
        getTeamsInfo: getTeamsInfo,
        getTeamSeason: getTeamSeason
    };
});
