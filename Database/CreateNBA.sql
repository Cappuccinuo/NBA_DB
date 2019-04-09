CREATE DATABASE IF NOT EXISTS `NBA`;
USE `NBA`;

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player` (
	`person_id` varchar(255) NOT NULL,
    `first_name` varchar(255),
    `last_name` varchar(255),
    `name` varchar(255),
    `birthdate` DATE,
    `school` varchar(255),
    `country` varchar(255),
    `height` varchar(255),
    `weight` varchar(255),
    `position` varchar(255),
    `rosterstatus` varchar(255),
    `team_id` varchar(255) NOT NULL,
    `from_year` varchar(255),
    `to_year` varchar(255),
    `draft_year` varchar(255),
    `draft_round` varchar(255),
    `draft_number` varchar(255),
	PRIMARY KEY (`person_id`, `team_id`)
);

DROP TABLE IF EXISTS `team_background`;
CREATE TABLE `team_background` (
	`team_id` varchar(255) NOT NULL,
    `abbreviation` varchar(255),
    `nickname` varchar(255),
    `year_founded` varchar(255),
    `city` varchar(255),
    `arena` varchar(255),
    `arena_capacity` varchar(255),
    `owner` varchar(255),
    `general_manager` varchar(255),
    `head_coach` varchar(255),
    `affiliation` varchar(255),
    `facebook` varchar(255),
    `instagram` varchar(255),
    `twitter` varchar(255),
    PRIMARY KEY (`team_id`)
);

DROP TABLE IF EXISTS `team_season`;
CREATE TABLE `team_season` (
	`team_id` varchar(255) NOT NULL, 
    `season` varchar(255) NOT NULL,
    `win` int,
    `loss` int,
    `win_percentage` float,
    `conf_rank` int,
    `fgm` float,
    `fga` float,
    `fg_pct` float,
    `fg3m` float,
    `fg3a` float,
    `fg3_pct` float,
    `ftm` float,
    `fta` float,
    `ft_pct` float,
    `o_reb` float,
    `d_reb` float,
    `reb` float,
    `ast` float,
    `pf` float,
    `stl` float,
    `tov` float,
    `blk` float,
    `pts` float,
    PRIMARY KEY (`team_id`, `season`)
);



DROP TABLE IF EXISTS `player_season`;
CREATE TABLE `player_season` (
	`player_id` varchar(255) NOT NULL, 
    `season` varchar(255) NOT NULL,
    `team_id` varchar(255) NOT NULL,
    `min` float,
    `fgm` float,
    `fga` float,
    `fg_pct` float,
    `fg3m` float,
    `fg3a` float,
    `fg3_pct` float,
    `ftm` float,
    `fta` float,
    `ft_pct` float,
    `o_reb` float,
    `d_reb` float,
    `reb` float,
    `ast` float,
    `stl` float,
    `blk` float,
    `tov` float,
    `pf` float,
    `pts` float,
    PRIMARY KEY (`player_id`, `season`,`team_id`)
);


DROP TABLE IF EXISTS `team_game`;
CREATE TABLE `team_game` (
	`team_id` varchar(255) NOT NULL,
    `game_id` varchar(255) NOT NULL,
	`game_date` varchar(255),
    `matchup` varchar(255),
    `wl` varchar(255),
    `min` int,
    `fgm` float,
    `fga` float,
    `fg_pct` float,
    `fg3m` float,
    `fg3a` float,
    `fg3_pct` float,
    `ftm` float,
    `fta` float,
    `ft_pct` float,
    `o_reb` float,
    `d_reb` float,
    `reb` float,
    `ast` float,
    `stl` float,
    `blk` float,
    `tov` float,
    `pf` float,
    `pts` float,
    `season` varchar(255),
    PRIMARY KEY (`team_id`, `game_id`)
);

DROP TABLE IF EXISTS `player_game`;
CREATE TABLE `player_game` (
	`game_id` varchar(255) NOT NULL,
	`team_id` varchar(255) NOT NULL,
    `player_id` varchar(255) NOT NULL,
    `start_position` varchar(255) default null,
    `min` varchar(255)  default null,
    `fgm` float  default null,
    `fga` float  default null,
    `fg_pct` float default null,
    `fg3m` float default null,
    `fg3a` float default null,
    `fg3_pct` float default null,
    `ftm` float default null,
    `fta` float default null,
    `ft_pct` float default null,
    `o_reb` float default null,
    `d_reb` float default null,
    `reb` float default null,
    `ast` float default null,
    `stl` float default null,
    `blk` float default null,
    `tov` float default null,
    `pf` float default null,
    `pts` float default null,
    `plus_minus` float default null,
    PRIMARY KEY (`team_id`, `game_id`, `player_id`)
);
SELECT * FROM team_game WHERE game_id = '0021700146';
SELECT * FROM team_game t WHERE t.team_id = '1610612738' ORDER BY STR_TO_DATE(t.game_date, "%b %d, %Y")  DESC LIMIT 2;

SELECT STR_TO_DATE(t.game_date, "%b %d, %Y") FROM team_game t;
SELECT * from team_game WHERE game_date = "OCT 18, 2017";
SELECT * from player_season;

SELECT p1.abbreviation as away_team, p2.abbreviation as home_team, p1.pts as away_score, p2.pts as home_score, p1.team_id as away_team_id, p2.team_id as home_team_id, p1.game_id as game_id
FROM 
(SELECT t1.*, tb1.abbreviation FROM team_game t1 JOIN team_background tb1 ON t1.team_id = tb1.team_id) p1 
JOIN 
(SELECT t2.*, tb2.abbreviation FROM team_game t2 JOIN team_background tb2 ON t2.team_id = tb2.team_id) p2 
ON p1.game_id = p2.game_id AND p1.team_id != p2.team_id AND p1.matchup LIKE '%@%'
WHERE p1.game_date = "OCT 19, 2017" AND p2.game_date = "OCT 19, 2017";


SELECT p.* FROM ((SELECT * FROM player_game WHERE player_id = '1627098') p JOIN team_game t ON p.game_id = t.game_id AND p.team_id = t.team_id) ORDER BY STR_TO_DATE(t.game_date, "%b %d, %Y")  DESC;
SELECT * FROM player_game WHERE player_id = '1627098';


SELECT * FROM player p WHERE p.team_id = "1610612738";
SELECT * FROM player p WHERE p.name LIKE 'Ja%'