app.service('httpService', function ($http) {
    function getTeamsInfo () {
        return $http.get("http://localhost:8080/api/teambg");
    }

    function getTeamSeason(id, season) {
        return $http.get("http://localhost:8080/api/teamseason/" + id + "&" + season);
    }

    function getTeamGame(id, num) {
        return $http.get("http://localhost:8080/api/teamgame/" + id + "/latest" + num);
    }

    function getTeamPlayer(id) {
        return $http.get("http://localhost:8080/api/teambg/" + id + "/players");
    }

    return {
        getTeamsInfo: getTeamsInfo,
        getTeamSeason: getTeamSeason,
        getTeamGame: getTeamGame,
        getTeamPlayer: getTeamPlayer
    };
});
