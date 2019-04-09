1. Player ~~(Search by name)~~
a. We can deactivate(delete) a player, but the game played by that player will not disappear. (Backend)
b. Display the information just like team page. e.g. height, weight, birthdate. Can Update.
c. Average statistic in given season. (Backend playerseason/season)
~~d. Recent n game statistic. (Backend playergame/id/recent{n})~~
e. Create a player

2. Scores
~~Search by date. Just like NBA.com~~
~~For given date, backend will give all games played on that day or will played on that day.~~
~~Otherwise, print No games are scheduled on this day.~~

~~json format {awayName: {}, awayScore: {}...}
Awayteam 100
Hometeam 98~~
box score    team details
This two fields are related to team_id, backend will return corresponding information.

3. Update (Database trigger)
a. Can insert future game arrangement.
b. Update game box score.

4. delete
delete a game -> trigger update player_season, team_season, team_rank, win_loss

select the form
away_team  home_team
upload_away_player
upload_home_player
Game_id will be returned by backend.
