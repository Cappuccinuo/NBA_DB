-- Get the game number the team has played during the season
-- Update team_season by trigger, avg of team_game
-- delete game_id, team_game corresponding delete.

SELECT away_team_id, COUNT(*) FROM game_info WHERE season = "2017-18" GROUP BY away_team_id;

DROP FUNCTION IF EXISTS get_games_played_by_team_in_season;
DELIMITER //
CREATE function get_games_played_by_team_in_season(team_id varchar(255), season varchar(255)) RETURNS int
DETERMINISTIC
BEGIN
	DECLARE team varchar(255);
    DECLARE cnt int default 0;
    SELECT 		
						tb.team_id INTO team
	FROM 		
						team_background tb
	WHERE 		
						tb.team_id = team_id;
                        
	IF isnull(team) THEN return 0;
    END IF;
    
	
    SELECT 	
						COUNT(*) INTO cnt
	FROM			
						game_info
	WHERE		
						away_team_id = team_id OR home_team_id = team_id;
	return cnt;
    
END //
DELIMITER ;
