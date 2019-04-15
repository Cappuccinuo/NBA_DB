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

    function getOneTeamGame(tid, gid) {
        return $http.get("http://localhost:8080/api/teamgame/" + tid + "/" + gid);
    }

    function updateTeamGame(tid, gid, data) {
        return $http.put("http://localhost:8080/api/teamgame/" + tid + "/" + gid, data);
    }

    function getTeamPlayer(id) {
        return $http.get("http://localhost:8080/api/playerteam/players/" + id);
    }

    function findPlayer(name) {
        return $http.get("http://localhost:8080/api/player/filter/" + name);
    }

    function getPlayerSeason(pid, season) {
        return $http.get("http://localhost:8080/api/playerseason/" + pid + "/" + season);
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

    function createPlayerTeam (data) {
        return $http.post("http://localhost:8080/api/playerteam", data);
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

    function getPlayerStats(tid, gid) {
        return $http.get("http://localhost:8080/api/game/playergames/" + tid + "&" + gid);
    }

    function createGame (data) {
        return $http.post("http://localhost:8080/api/game", data);
    }

    function checkGameId(id) {
        return $http.get("http://localhost:8080/api/game/check/" + id);
    }

    function deleteGame (id) {
        return $http.delete("http://localhost:8080/api/game/" + id);
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
        getGamesByDate: getGamesByDate,
        createPlayerTeam: createPlayerTeam,
        getPlayerStats: getPlayerStats,
        getOneTeamGame: getOneTeamGame,
        createGame: createGame,
        checkGameId: checkGameId,
        updateTeamGame: updateTeamGame,
        deleteGame: deleteGame
    };
});
