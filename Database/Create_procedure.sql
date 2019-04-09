DROP PROCEDURE if EXISTS `get_games_on_date`;
DELIMITER //
CREATE procedure get_games_on_date(IN d varchar(255))
BEGIN
	SELECT 
			p1.abbreviation as away_team, 
			p2.abbreviation as home_team, 
            p1.pts as away_score, p2.pts as home_score, 
            p1.team_id as away_team_id, 
            p2.team_id as home_team_id, 
            p1.game_id as game_id
FROM 
			(SELECT 
					t1.*, 
                    tb1.abbreviation 
			  FROM team_game t1 
              JOIN team_background tb1 
              ON t1.team_id = tb1.team_id) p1 
JOIN 
			(SELECT 
					t2.*, 
                    tb2.abbreviation 
			  FROM team_game t2 
              JOIN team_background tb2 
              ON t2.team_id = tb2.team_id) p2 
ON p1.game_id = p2.game_id AND p1.team_id != p2.team_id AND p1.matchup LIKE '%@%'
WHERE p1.game_date = d AND p2.game_date = d;
END //

DELIMITER ;

CALL get_games_on_date("OCT 19, 2017")