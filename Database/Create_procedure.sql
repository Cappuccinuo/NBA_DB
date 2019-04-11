DROP PROCEDURE if EXISTS `get_games_on_date`;
DELIMITER //
CREATE procedure get_games_on_date(IN d varchar(255))
BEGIN
	SELECT 		tb1.abbreviation as away_team, 
						tb2.abbreviation as home_team, 
                        tg1.pts as away_score, 
                        tg2.pts as home_score, 
                        tb1.team_id as away_team_id, 
                        tb2.team_id as home_team_id, 
                        tb1.city as away_team_city,
                        tb2.city as home_team_city,
                        tb1.nickname as away_team_nickname,
                        tb2.nickname as home_team_nickname,
                        g.game_date as date,
                        g.game_id as game_id 
	FROM 		game_info g
	JOIN 			team_background tb1 ON g.away_team_id = tb1.team_id
	JOIN 			team_background tb2 ON g.home_team_id = tb2.team_id
	JOIN 			team_game tg1 ON g.game_id = tg1.game_id AND tg1.team_id = tb1.team_id
	JOIN 			team_game tg2 ON g.game_id = tg2.game_id AND tg2.team_id = tb2.team_id
    WHERE 		g.game_date = d;
END //

DELIMITER ;

DROP PROCEDURE if EXISTS `get_players_of_team`;
DELIMITER //
CREATE procedure get_players_of_team(IN team_id varchar(255))
BEGIN
SELECT 		p.*
FROM 		player p 
JOIN 			player_team pt 
ON 				p.person_id = pt.player_id
WHERE 		pt.team_id = team_id;
END //
DELIMITER ;

DROP PROCEDURE if EXISTS `get_team_of_player`;
DELIMITER //
CREATE procedure get_team_of_player(IN player_id varchar(255))
BEGIN
SELECT 		t.*
FROM 		team_background t 
JOIN 			player_team pt 
ON 				t.team_id = pt.team_id
WHERE 		pt.player_id = player_id;
END //
DELIMITER ;

DROP PROCEDURE if EXISTS `get_players_given_name`;
DELIMITER //
CREATE procedure get_players_given_name(IN player_name varchar(255))
BEGIN
SELECT 		* 
FROM 		player p 
WHERE 		p.name LIKE concat(player_name, '%');
END //
DELIMITER ;

DROP PROCEDURE if EXISTS `get_team_game_desc`;
DELIMITER //
CREATE procedure get_team_game_desc(IN team_id varchar(255))
BEGIN
SELECT 		t.*
FROM 		team_game t
JOIN			game_info g
ON 				t.team_id = g.away_team_id
OR				t.team_id = g.home_team_id
WHERE		t.team_id = team_id
ORDER BY str_to_date(g.game_date, "%b %d, %Y") DESC;
END //
DELIMITER ;

DROP PROCEDURE if EXISTS `get_player_games_given_team_and_game`;
DELIMITER //
CREATE procedure get_player_games_given_team_and_game(IN team_id varchar(255), IN game_id varchar(255))
BEGIN
SELECT 		p.*
FROM 		player_game p
WHERE		p.team_id = team_id AND p.game_id = game_id;
END //
DELIMITER ;

