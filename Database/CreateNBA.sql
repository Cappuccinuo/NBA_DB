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

DROP TABLE IF EXISTS `team_social_sites`;
CREATE TABLE `team_social_sites` (
	`account_type` varchar(255),
    `website` varchar(255),
    `team_id` varchar(255) NOT NULL,
	PRIMARY KEY (`team_id`, `account_type`)
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


