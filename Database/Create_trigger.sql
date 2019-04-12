DROP TRIGGER if EXISTS update_team_season_insert;
DELIMITER //
CREATE trigger update_team_season_insert
AFTER INSERT ON team_game
FOR EACH ROW 
BEGIN
    DECLARE fgm_new float;
    DECLARE s varchar(255);
    
    SET s = (SELECT season FROM game_info WHERE game_id = NEW.game_id);
    SET fgm_new = (SELECT AVG(tg.fgm) FROM team_game tg JOIN game_info gi ON tg.game_id = gi.game_id WHERE tg.team_id = NEW.team_id AND gi.season = s);
    
	UPDATE team_season
    SET fgm = fgm_new
    WHERE team_id = NEW.team_id AND season = s;
END //
DELIMITER ;

DROP TRIGGER if EXISTS update_team_season_delete;
DELIMITER //
CREATE trigger update_team_season_delete
AFTER DELETE ON game_info
FOR EACH ROW 
BEGIN
    DECLARE away_fgm_new float;
    DECLARE home_fgm_new float;
    
    SET away_fgm_new = (SELECT AVG(tg.fgm) FROM team_game tg JOIN game_info gi ON tg.game_id = gi.game_id WHERE tg.team_id = OLD.away_team_id AND gi.season = OLD.season);
    SET home_fgm_new = (SELECT AVG(tg.fgm) FROM team_game tg JOIN game_info gi ON tg.game_id = gi.game_id WHERE tg.team_id = OLD.home_team_id AND gi.season = OLD.season);
    
	UPDATE team_season
    SET fgm = away_fgm_new
    WHERE team_id = OLD.away_team_id AND season = OLD.season;
    
    UPDATE team_season
    SET fgm = home_fgm_new
    WHERE team_id = OLD.home_team_id AND season = OLD.season;
END //
DELIMITER ;
