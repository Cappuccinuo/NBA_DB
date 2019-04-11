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
    `from_year` varchar(255),
    `to_year` varchar(255),
    `draft_year` varchar(255),
    `draft_round` varchar(255),
    `draft_number` varchar(255),
	PRIMARY KEY (`person_id`)
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
    `conf` varchar(255),
    PRIMARY KEY (`team_id`)
);

DROP TABLE IF EXISTS `game_info`;
CREATE TABLE `game_info` (
	`game_id` varchar(255) NOT NULL, 
    `game_date` varchar(255),
    `season` varchar(255),
    `away_team_id` varchar(255),
    `home_team_id` varchar(255),
    PRIMARY KEY (`game_id`)
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
    PRIMARY KEY (`team_id`, `season`),
    CONSTRAINT `team_id_constraint_1` FOREIGN KEY (`team_id`) REFERENCES `team_background` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
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
    PRIMARY KEY (`player_id`, `season`,`team_id`),
    CONSTRAINT `player_id_constraint_1` FOREIGN KEY (`player_id`) REFERENCES `player` (`person_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `team_id_constraint_2` FOREIGN KEY (`team_id`) REFERENCES `team_background` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `team_game`;
CREATE TABLE `team_game` (
	`team_id` varchar(255) NOT NULL,
    `game_id` varchar(255) NOT NULL,
    `min` int default 240,
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
    PRIMARY KEY (`team_id`, `game_id`),
    CONSTRAINT `team_id_constraint_3` FOREIGN KEY (`team_id`) REFERENCES `team_background` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `game_id_constraint_1` FOREIGN KEY (`game_id`) REFERENCES `game_info` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `player_game`;
CREATE TABLE `player_game` (
	`game_id` varchar(255) NOT NULL,
	`team_id` varchar(255) NOT NULL,
    `player_id` varchar(255) NOT NULL,
    `start_position` varchar(255),
    `min` varchar(255),
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
    `plus_minus` float,
    PRIMARY KEY (`team_id`, `game_id`, `player_id`),
    CONSTRAINT `player_id_constraint_2` FOREIGN KEY (`player_id`) REFERENCES `player` (`person_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `team_id_constraint_4` FOREIGN KEY (`team_id`) REFERENCES `team_background` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `game_id_constraint_2` FOREIGN KEY (`game_id`) REFERENCES `game_info` (`game_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `player_team`;
CREATE TABLE `player_team` (
	`player_id` varchar(255) NOT NULL,
    `team_id` varchar(255),
    PRIMARY KEY (`player_id`),
    CONSTRAINT `player_id_constraint_3` FOREIGN KEY (`player_id`) REFERENCES `player` (`person_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `team_id_constraint_5` FOREIGN KEY (`team_id`) REFERENCES `team_background` (`team_id`) ON DELETE SET NULL ON UPDATE CASCADE
);