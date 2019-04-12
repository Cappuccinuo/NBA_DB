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
INSERT INTO team_game(team_id, game_id, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, o_reb, d_reb, reb, ast, stl, blk, tov, pf, pts) 
			VALUES("1610612738", "2", 240, 1, 2, 0.5, 1, 2, 0.5, 1, 2, 0.5, 1, 1, 2, 1, 1, 1, 1, 1, 100);
DELETE FROM game_info where game_id = "2";

SELECT * FROM game_info;
SELECT * FROM team_game WHERE team_id = "1610612738";
SELECT * FROM team_season WHERE team_id = "1610612738" AND season = "2017-18";