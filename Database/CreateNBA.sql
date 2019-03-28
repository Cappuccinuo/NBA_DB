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