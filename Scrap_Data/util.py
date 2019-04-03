import pandas as pd
from nba_py.constants import TEAMS
from nba_py import team
from nba_py import game
from nba_py import player
import time
from nba_py.player import PlayerList
from resources.teams import teamToIndex

def load_team_game_data_between_years(teamName, startYear, endYear):
  gameData = pd.DataFrame()

  for i in range(startYear, endYear + 1):
    print("current year: " + str(i))
    gD = load_team_game_data_at_year(teamName, i)
    gameData = gameData.append(gD)
    time.sleep(3)
  return gameData

def load_team_game_data_at_year(teamName, year):
  teamId = TEAMS[teamName]['id']
  season = get_season(year)
  header = ['Team_ID', 'Game_ID', 'GAME_DATE', 'MATCHUP', 'WL', 'MIN', 'FGM',
            'FGA', 'FG_PCT', 'FG3M',
            'FG3A', 'FG3_PCT', 'FTM', 'FTA', 'FT_PCT',
            'OREB', 'DREB', 'REB', 'AST', 'STL', 'BLK', 'TOV', 'PF', 'PTS']
  gameData = team.TeamGameLogs(teamId, season).info()
  gameData = gameData[header]
  gameData['Season'] = season

  return gameData

def load_player_game_data_at_year(teamName, year):
  teamId = TEAMS[teamName]['id']
  season = get_season(year)
  gameData = team.TeamGameLogs(teamId, season).info()
  playerData = pd.DataFrame()
  header = ['GAME_ID', 'TEAM_ID', 'PLAYER_ID', 'START_POSITION',
            'MIN', 'FGM', 'FGA', 'FG_PCT', 'FG3M', 'FG3A', 'FG3_PCT',
            'FTM', 'FTA', 'FT_PCT', 'OREB', 'DREB', 'REB', 'AST', 'STL',
            'BLK', 'TO', 'PF', 'PTS', 'PLUS_MINUS']
  visited = set()
  i = 1
  for g in gameData["Game_ID"]:
    print(i)
    i += 1
    if (g in visited):
      continue
    visited.add(g)
    temp = game.Boxscore(g).player_stats()
    temp = temp[header]
    playerData = playerData.append(temp)

    time.sleep(5)

  playerData.to_csv("data/game/" + season + "-players.csv", index=False)

def load_all_team_season(year):
  resDF = pd.DataFrame()
  season = get_season(year)
  for teamName in teamToIndex:
    print(teamName)
    temp = load_team_game_data_at_year(teamName, year)
    resDF = resDF.append(temp)
    time.sleep(3)
  resDF.to_csv("data/game/" + season + "-teams.csv", index=False)

def load_all_player():
  header = ['PERSON_ID', 'FIRST_NAME', 'LAST_NAME', 'DISPLAY_FIRST_LAST',
            'BIRTHDATE', 'SCHOOL', 'COUNTRY', 'HEIGHT', 'WEIGHT',
            'POSITION', 'ROSTERSTATUS', 'TEAM_ID', 'FROM_YEAR',
            'TO_YEAR', 'DRAFT_YEAR', 'DRAFT_ROUND', 'DRAFT_NUMBER']
  resDF = pd.DataFrame()
  players = PlayerList().info()
  person_id_list = players['PERSON_ID']
  for id in person_id_list:
    print(id)
    player_info = player.PlayerSummary(id).info()
    player_info = player_info[header]
    resDF = resDF.append(player_info)
    time.sleep(1)
  resDF = resDF[resDF.TEAM_ID != 0]
  resDF.to_csv("data/player/players.csv", index=False)

def get_season(year):
  CURRENT_SEASON = str(year) + "-" + str(year + 1)[2:]
  return CURRENT_SEASON

def load_team_background():
  resDF = pd.DataFrame()
  i = 0
  for teamName in teamToIndex:
    print(teamName)
    teamId = TEAMS[teamName]["id"]
    backgroundDF = team.TeamDetails(teamId).background()
    socialDF = team.TeamDetails(teamId).social_sites()
    print(socialDF)
    resDF = pd.concat([resDF, backgroundDF], ignore_index=True, sort=False)
    facebook = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Facebook']['WEBSITE_LINK'].iloc[0]
    instagram = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Instagram']['WEBSITE_LINK'].iloc[0]
    twitter = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Twitter']['WEBSITE_LINK'].iloc[0]
    resDF.at[i, 'Facebook'] = facebook
    resDF.at[i, 'Instagram'] = instagram
    resDF.at[i, 'Twitter'] = twitter
    i = i + 1

    # resDF['Instagram'] = \
    #
    # resDF['Twitter'] = \
    #   socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Twitter']['WEBSITE_LINK'].iloc[0]
    time.sleep(2)

  resDF.to_csv("data/team/team-background.csv", index=False)

def load_team_season():
  header = ['TEAM_ID', 'YEAR', 'WINS', 'LOSSES', 'WIN_PCT', 'CONF_RANK',
            'FGM', 'FGA', 'FG_PCT', 'FG3M', 'FG3A', 'FG3_PCT',
            'FTM', 'FTA', 'FT_PCT', 'OREB', 'DREB', 'REB',
            'AST', 'PF', 'STL', 'TOV', 'BLK', 'PTS']

  resDF = pd.DataFrame()
  for teamName in teamToIndex:
    print(teamName)
    teamId = TEAMS[teamName]["id"]
    seasonInfo = team.TeamSeasons(teamId).info()
    seasonInfo = seasonInfo[header]
    resDF = resDF.append(seasonInfo)
    time.sleep(2)
  resDF.to_csv("data/team/team-season.csv", index=False)

def load_player_season():
  header = ['PLAYER_ID', 'SEASON_ID', 'TEAM_ID', 'MIN', 'FGM', 'FGA', 'FG_PCT', 'FG3M',
  'FG3A', 'FG3_PCT', 'FTM', 'FTA', 'FT_PCT', 'OREB', 'DREB', 'REB', 'AST',
  'STL', 'BLK', 'TOV', 'PF', 'PTS']
  resDF = pd.DataFrame()
  players = PlayerList().info()
  person_id_list = players['PERSON_ID']

  for id in person_id_list:
    print(id)
    player_info = player.PlayerProfile(id).regular_season_totals()
    player_info = player_info[header]
    resDF = resDF.append(player_info)
    time.sleep(3)

  resDF.to_csv("data/player/players-season.csv", index=False)