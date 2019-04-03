app.service('httpService', function ($http) {
    function getTeamsInfo () {
        return $http.get("https://jsonplaceholder.typicode.com/todos");
    }

    return {
    
        getTeamsInfo : getTeamsInfo
        
    };
});