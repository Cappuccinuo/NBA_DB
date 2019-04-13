SELECT * FROM player_game;
SELECT * FROM team_season;
SELECT * FROM team_game;
SELECT * FROM team_background WHERE abbreviation="BOS";
CALL get_players_of_team("1610612738");

SELECT AVG(fgm) FROM team_game WHERE team_id = "1610612738" GROUP BY team_id;
SELECT season, fgm FROM team_season WHERE team_id = "1610612738" ;

SELECT a.game_id, a.fgm1, b.fgm2 FROM 
(SELECT game_id, fgm as fgm1 FROM team_game WHERE team_id = "1610612738") a
JOIN 
(SELECT game_id, SUM(fgm) as fgm2 FROM player_game WHERE team_id = "1610612738" GROUP BY game_id) b
ON a.game_id = b.game_id;



SELECT AVG(temp.s) FROM (SELECT SUM(fgm) as s FROM player_game WHERE team_id = "1610612738" GROUP BY game_id) temp;


SELECT AVG(fgm) FROM team_game WHERE team_id = "1610612738" GROUP BY team_id;

SELECT * FROM game_info;

INSERT INTO game_info (game_id, game_date, season, away_team_id, home_team_id) VALUES ("2", "MAR 30, 2018", "2017-18", "1610612738", "1610612747");
-- INSERT INTO team_game(team_id, game_id, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, o_reb, d_reb, reb, ast, stl, blk, tov, pf, pts) 
-- 			VALUES("1610612738", "2", 240, 1, 2, 0.5, 1, 2, 0.5, 1, 2, 0.5, 1, 1, 2, 1, 1, 1, 1, 1, 100);
UPDATE team_game
SET fgm = 1, fga = 2, fg3m = 1, fg3a = 2, ftm = 1, fta = 2, o_reb = 1, d_reb = 1, ast = 1, stl = 1, blk = 1, tov = 1, pf = 1, pts = 100
WHERE team_id = "1610612738" AND game_id = "2";
UPDATE team_game
SET fgm = 1, fga = 2, fg3m = 1, fg3a = 2, ftm = 1, fta = 2, o_reb = 1, d_reb = 1, ast = 1, stl = 1, blk = 1, tov = 1, pf = 1, pts = 99
WHERE team_id = "1610612747" AND game_id = "2";

DELETE FROM game_info where game_id = "2";

SELECT * FROM game_info;
SELECT * FROM team_game WHERE team_id = "1610612738";
SELECT * FROM team_game WHERE team_id = "1610612747";
SELECT * FROM team_season WHERE team_id = "1610612738" AND season = "2017-18";
SELECT * FROM team_season WHERE team_id = "1610612747" AND season = "2017-18";

SELECT * FROM team_season WHERE season = "2017-18";

SELECT ts.team_id, RANK() OVER (partition by tb.conf order BY ts.win_percentage) my_rank
FROM team_season ts
JOIN team_background tb
ON ts.team_id = tb.team_id
WHERE ts.season = "2017-18";


SELECT * FROM player_game WHERE team_id = "1610612755";

SELECT * FROM team_background;

SELECT * FROM player;
SELECT * FROM player_team;
INSERT INTO player (person_id, first_name, last_name) VALUES ("1", "d", "w");
INSERT INTO player_team (player_id, team_id) VALUES("1", "1610612755");
DELETE FROM player where person_id = "1";