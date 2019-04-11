app.service('httpService', function ($http) {
    function getTeamsInfo () {
        return $http.get("http://localhost:8080/api/teambg");
    }

    function updateTeamsInfo (id, data) {
        return $http.put("http://localhost:8080/api/teambg/" + id, data);
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

    function findPlayer(name) {
        return $http.get("http://localhost:8080/api/player/filter/" + name);
    }

    function getPlayerSeason(pid, tid, season) {
        return $http.get("http://localhost:8080/api/playerseason/" + pid + "&" + tid + "&" + season);
    }

    function getPlayerGame(id, num) {
        return $http.get("http://localhost:8080/api/playergame/" + id + "/latest" + num);
    }

    function updatePlayerInfo (id, data) {
        return $http.put("http://localhost:8080/api/player/" + id, data);
    }

    function createPlayer (data) {
        return $http.post("http://localhost:8080/api/player", data);
    }

    function deletePlayerInfo (id) {
        return $http.delete("http://localhost:8080/api/player/" + id);
    }

    function checkPlayerId(id) {
        return $http.get("http://localhost:8080/api/player/" + id);
    }

    function getGamesByDate (date) {
        return $http.get("http://localhost:8080/api/game/" + date);
    }

    return {
        getTeamsInfo: getTeamsInfo,
        getTeamSeason: getTeamSeason,
        getTeamGame: getTeamGame,
        getTeamPlayer: getTeamPlayer,
        updateTeamsInfo: updateTeamsInfo,
        findPlayer: findPlayer,
        getPlayerSeason: getPlayerSeason,
        getPlayerGame: getPlayerGame,
        updatePlayerInfo: updatePlayerInfo,
        createPlayer: createPlayer,
        deletePlayerInfo: deletePlayerInfo,
        checkPlayerId: checkPlayerId,
        getGamesByDate: getGamesByDate
    };
});
