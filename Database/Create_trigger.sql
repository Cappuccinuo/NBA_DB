DROP TRIGGER if EXISTS update_team_season_update;
DELIMITER //
CREATE trigger update_team_season_update
AFTER UPDATE ON team_game
FOR EACH ROW 
BEGIN
	DECLARE win_old float;
    DECLARE loss_old float;
	DECLARE win_new float;
    DECLARE loss_new float;
    
    DECLARE opponent_win_old float;
    DECLARE opponent_loss_old float;
    DECLARE opponent_win_new float;
    DECLARE opponent_loss_new float;
    
    DECLARE opponent_score float;
    DECLARE opponent_team_id varchar(255);
    
    DECLARE fgm_new float;
    DECLARE fga_new float;
    DECLARE fg3m_new float;
    DECLARE fg3a_new float;
    DECLARE ftm_new float;
    DECLARE fta_new float;
    DECLARE o_reb_new float;
    DECLARE d_reb_new float;
    DECLARE ast_new float;
    DECLARE stl_new float;
    DECLARE blk_new float;
    DECLARE tov_new float;
    DECLARE pf_new float;
    DECLARE pts_new float;
    DECLARE s varchar(255);
    
    SET s = (SELECT season FROM game_info WHERE game_id = NEW.game_id);
    
    SET opponent_team_id = (SELECT CASE WHEN away_team_id = NEW.team_id THEN home_team_id ELSE away_team_id END FROM game_info WHERE game_id = NEW.game_id);
    
    SET win_old = (SELECT win FROM team_season WHERE team_id = NEW.team_id AND season = s);
    SET loss_old = (SELECT loss FROM team_season WHERE team_id = NEW.team_id AND season = s);
    SET win_new = win_old;
    SET loss_new = loss_old;
    
    SET opponent_win_old = (SELECT win FROM team_season WHERE team_id = opponent_team_id AND season = s);
    SET opponent_loss_old = (SELECT loss FROM team_season WHERE team_id = opponent_team_id AND season = s);
    SET opponent_win_new = opponent_win_old;
    SET opponent_loss_new = opponent_loss_old;
    
    SELECT 		pts 
    INTO 			opponent_score
    FROM			team_game tg
    JOIN 			game_info gi
    ON				tg.game_id = gi.game_id
    WHERE		tg.team_id = opponent_team_id AND gi.season = s AND tg.game_id = NEW.game_id;
    
    IF (opponent_score != 0) THEN 
		IF (NEW.pts > opponent_score) THEN
			SET win_new =  win_old + 1;
            SET opponent_loss_new = opponent_loss_old + 1;
		ELSE
            SET loss_new = loss_old + 1;
            SET opponent_win_new = opponent_win_old + 1;
		END IF;
	END IF;
    
    SELECT     AVG(fgm), AVG(fga), AVG(fg3m), AVG(fg3a), AVG(ftm), AVG(fta), AVG(o_reb), AVG(d_reb), AVG(ast), AVG(stl), AVG(blk), AVG(tov), AVG(pf), AVG(pts)
    INTO 			fgm_new, fga_new, fg3m_new, fg3a_new, ftm_new, fta_new, o_reb_new, d_reb_new, ast_new, stl_new, blk_new, tov_new, pf_new, pts_new
	FROM 		team_game tg 
    JOIN 			game_info gi 
    ON 				tg.game_id = gi.game_id 
    WHERE 		tg.team_id = NEW.team_id AND gi.season = s;
    
    
	UPDATE team_season
    SET win = win_new, loss = loss_new, win_percentage = win_new / (loss_new + win_new), fgm = fgm_new, fga = fga_new, fg_pct = fgm_new / fga_new, fg3m = fg3m_new, fg3a = fg3a_new, fg3_pct = fg3m_new / fg3a_new,
			ftm = ftm_new, fta = fta_new, ft_pct = ftm / fta, o_reb = o_reb_new, d_reb = d_reb_new, reb = o_reb_new + d_reb_new, 
            ast = ast_new, stl = stl_new, blk = blk_new, tov = tov_new, pf = pf_new, pts = pts_new
    WHERE team_id = NEW.team_id AND season = s;
    
    UPDATE team_season
    SET win = opponent_win_new, loss = opponent_loss_new, win_percentage = opponent_win_new / (opponent_loss_new + opponent_win_new)
    WHERE team_id = opponent_team_id AND season = s;
    
    UPDATE team_season JOIN (SELECT ts.team_id as team_id, RANK() OVER (partition by tb.conf order BY ts.win_percentage DESC) myrank
														FROM team_season ts
														JOIN team_background tb
														ON ts.team_id = tb.team_id
														WHERE ts.season = s) i ON team_season.team_id = i.team_id
    SET conf_rank = i.myrank
    WHERE season = s;
END //
DELIMITER ;





DROP TRIGGER if EXISTS update_team_season_before_delete;
DELIMITER //
CREATE trigger update_team_season_before_delete
BEFORE DELETE ON game_info
FOR EACH ROW
BEGIN
	DECLARE away_win_old float;
    DECLARE away_loss_old float;
	DECLARE away_win_new float;
    DECLARE away_loss_new float;
    
    DECLARE home_win_old float;
    DECLARE home_loss_old float;
    DECLARE home_win_new float;
    DECLARE home_loss_new float;
    
    DECLARE away_score float;
    DECLARE home_score float;
    
    SET away_win_old = (SELECT win FROM team_season WHERE team_id = OLD.away_team_id AND season = OLD.season);
    SET away_loss_old = (SELECT loss FROM team_season WHERE team_id = OLD.away_team_id AND season = OLD.season);
    SET away_win_new = away_win_old;
    SET away_loss_new = away_loss_old;
    
    SET home_win_old = (SELECT win FROM team_season WHERE team_id = OLD.home_team_id AND season = OLD.season);
    SET home_loss_old = (SELECT loss FROM team_season WHERE team_id = OLD.home_team_id AND season = OLD.season);
    SET home_win_new = home_win_old;
    SET home_loss_new = home_loss_old;
    
    SELECT 		pts 
    INTO 			away_score
    FROM			team_game tg
    JOIN 			game_info gi
    ON				tg.game_id = gi.game_id
    WHERE		tg.team_id = OLD.away_team_id AND gi.season = OLD.season AND tg.game_id = OLD.game_id;
    
    SELECT 		pts
    INTO 			home_score
    FROM			team_game tg
    JOIN 			game_info gi
    ON				tg.game_id = gi.game_id
    WHERE		tg.team_id = OLD.home_team_id AND gi.season = OLD.season AND tg.game_id = OLD.game_id;
    
    IF (home_score > away_score) THEN
		SET away_loss_new = away_loss_old - 1;
        SET home_win_new = home_win_old - 1;
	ELSE
		SET away_win_new = away_win_old - 1;
        SET home_loss_new = home_loss_old - 1;
	END IF;
    
    UPDATE team_season
    SET win = away_win_new, loss = away_loss_new, win_percentage = away_win_new / (away_loss_new + away_win_new)
	WHERE team_id = OLD.away_team_id AND season = OLD.season;
    
    UPDATE team_season
    SET win = home_win_new, loss = home_loss_new, win_percentage = home_win_new / (home_loss_new + home_win_new)
    WHERE team_id = OLD.home_team_id AND season = OLD.season;
END  //
DELIMITER ;





DROP TRIGGER if EXISTS update_team_season_delete;
DELIMITER //
CREATE trigger update_team_season_delete
AFTER DELETE ON game_info
FOR EACH ROW 
BEGIN
	DECLARE away_fgm_new float;
    DECLARE away_fga_new float;
    DECLARE away_fg3m_new float;
    DECLARE away_fg3a_new float;
    DECLARE away_ftm_new float;
    DECLARE away_fta_new float;
    DECLARE away_o_reb_new float;
    DECLARE away_d_reb_new float;
    DECLARE away_ast_new float;
    DECLARE away_stl_new float;
    DECLARE away_blk_new float;
    DECLARE away_tov_new float;
    DECLARE away_pf_new float;
    DECLARE away_pts_new float;
    
    DECLARE home_fgm_new float;
    DECLARE home_fga_new float;
    DECLARE home_fg3m_new float;
    DECLARE home_fg3a_new float;
    DECLARE home_ftm_new float;
    DECLARE home_fta_new float;
    DECLARE home_o_reb_new float;
    DECLARE home_d_reb_new float;
    DECLARE home_ast_new float;
    DECLARE home_stl_new float;
    DECLARE home_blk_new float;
    DECLARE home_tov_new float;
    DECLARE home_pf_new float;
    DECLARE home_pts_new float;
    
	SELECT     AVG(fgm), AVG(fga), AVG(fg3m), AVG(fg3a), AVG(ftm), AVG(fta), AVG(o_reb), AVG(d_reb), AVG(ast), AVG(stl), AVG(blk), AVG(tov), AVG(pf), AVG(pts)
    INTO 			away_fgm_new, away_fga_new, away_fg3m_new, away_fg3a_new, away_ftm_new, away_fta_new, away_o_reb_new, away_d_reb_new, away_ast_new, away_stl_new, away_blk_new, away_tov_new, away_pf_new, away_pts_new
	FROM 		team_game tg 
    JOIN 			game_info gi 
    ON 				tg.game_id = gi.game_id 
    WHERE 		tg.team_id = OLD.away_team_id AND gi.season = OLD.season;
    
    SELECT     AVG(fgm), AVG(fga), AVG(fg3m), AVG(fg3a), AVG(ftm), AVG(fta), AVG(o_reb), AVG(d_reb), AVG(ast), AVG(stl), AVG(blk), AVG(tov), AVG(pf), AVG(pts)
    INTO 			home_fgm_new, home_fga_new, home_fg3m_new, home_fg3a_new, home_ftm_new, home_fta_new, home_o_reb_new, home_d_reb_new, home_ast_new, home_stl_new, home_blk_new, home_tov_new, home_pf_new, home_pts_new
	FROM 		team_game tg 
    JOIN 			game_info gi 
    ON 				tg.game_id = gi.game_id 
    WHERE 		tg.team_id = OLD.home_team_id AND gi.season = OLD.season;
    
    
	UPDATE team_season
    SET fgm = away_fgm_new, fga = away_fga_new, fg_pct = away_fgm_new / away_fga_new, fg3m = away_fg3m_new, fg3a = away_fg3a_new, fg3_pct = away_fg3m_new / away_fg3a_new,
			ftm = away_ftm_new, fta = away_fta_new, ft_pct = away_ftm_new / away_fta_new, o_reb = away_o_reb_new, d_reb = away_d_reb_new, reb = away_o_reb_new + away_d_reb_new, 
            ast = away_ast_new, stl = away_stl_new, blk = away_blk_new, tov = away_tov_new, pf = away_pf_new, pts = away_pts_new
    WHERE team_id = OLD.away_team_id AND season = OLD.season;
    
    UPDATE team_season
    SET fgm = home_fgm_new, fga = home_fga_new, fg_pct = home_fgm_new / home_fga_new, fg3m = home_fg3m_new, fg3a = home_fg3a_new, fg3_pct = home_fg3m_new / home_fg3a_new,
			ftm = home_ftm_new, fta = home_fta_new, ft_pct = home_ftm_new / home_fta_new, o_reb = home_o_reb_new, d_reb = home_d_reb_new, reb = home_o_reb_new + home_d_reb_new, 
            ast = home_ast_new, stl = home_stl_new, blk = home_blk_new, tov = home_tov_new, pf = home_pf_new, pts = home_pts_new
    WHERE team_id = OLD.home_team_id AND season = OLD.season;
    
    UPDATE team_season JOIN (SELECT ts.team_id as team_id, RANK() OVER (partition by tb.conf order BY ts.win_percentage DESC) myrank
														FROM team_season ts
														JOIN team_background tb
														ON ts.team_id = tb.team_id
														WHERE ts.season = OLD.season) i ON team_season.team_id = i.team_id
    SET conf_rank = i.myrank
    WHERE season = OLD.season;
END //
DELIMITER ;



DROP TRIGGER if EXISTS update_team_game_insert;
DELIMITER //
CREATE trigger update_team_game_insert
AFTER insert ON game_info
FOR EACH ROW
BEGIN
    INSERT INTO team_game(team_id, game_id, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, o_reb, d_reb, reb, ast, stl, blk, tov, pf, pts) 
			VALUES(NEW.away_team_id, NEW.game_id, 240, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	INSERT INTO team_game(team_id, game_id, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, o_reb, d_reb, reb, ast, stl, blk, tov, pf, pts) 
			VALUES(NEW.home_team_id, NEW.game_id, 240, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
END //
DELIMITER ;




