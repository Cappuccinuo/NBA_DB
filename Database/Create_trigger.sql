DROP TRIGGER if EXISTS update_team_season_insert;
DELIMITER //
CREATE trigger update_team_season_insert
AFTER INSERT ON team_game
FOR EACH ROW 
BEGIN
	DECLARE fgm float;
    DECLARE fgm_previous float;
    DECLARE fgm_new float;
    DECLARE s varchar(255);
    DECLARE game_cnt int;
    
    
    SET s = (SELECT season FROM game_info WHERE game_id = NEW.game_id);
    SET fgm = (SELECT fgm FROM team_game WHERE game_id = NEW.game_id);
    SET fgm_previous = (SELECT fgm FROM team_season WHERE team_id = NEW.team_id AND season = s);
    SET game_cnt = (SELECT get_games_played_by_team_in_season(NEW.team_id, s));
    SET fgm_new = (fgm_previous * game_cnt + fgm) / (game_cnt + 1);
    
	UPDATE team_season
    SET fgm = fgm_new
    WHERE team_id = NEW.team_id AND season = s;
END //
DELIMITER ;

DROP TRIGGER if EXISTS update_team_season_delete;
DELIMITER //
CREATE trigger update_team_season_delete
AFTER DELETE ON team_game
FOR EACH ROW 
BEGIN
	DECLARE fgm float;
    DECLARE fgm_previous float;
    DECLARE fgm_new float;
    DECLARE s varchar(255);
    DECLARE game_cnt int;
    
    
    SET s = (SELECT season FROM game_info WHERE game_id = NEW.game_id);
    SET fgm = (SELECT fgm FROM team_game WHERE game_id = NEW.game_id);
    SET fgm_previous = (SELECT fgm FROM team_season WHERE team_id = NEW.team_id AND season = s);
    SET game_cnt = (SELECT get_games_played_by_team_in_season(NEW.team_id, s));
    SET fgm_new = (fgm_previous * game_cnt - fgm) / (game_cnt - 1);
    
	UPDATE team_season
    SET fgm = fgm_new
    WHERE team_id = NEW.team_id AND season = s;
END //
DELIMITER ;