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
  playerData = pd.DataFrame()
  visited = set()
  for i in range(startYear, endYear + 1):
    print("current year: " + str(i))
    gD, pD = load_team_game_data_at_year(teamName, i, visited)
    gameData = gameData.append(gD)
    playerData = playerData.append(pD)
    time.sleep(30)
  return gameData, playerData

def load_team_game_data_at_year(teamName, year, visited):
  teamId = TEAMS[teamName]['id']
  season = get_season(year)
  gameData = team.TeamGameLogs(teamId, season).info()

  playerData = pd.DataFrame()
  i = 1
  for g in gameData["Game_ID"]:
    print(i)
    i += 1
    if (g in visited):
      continue
    playerData = playerData.append(game.Boxscore(g).player_stats())
    time.sleep(5)

  return gameData, playerData

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

def load_team_social_sites():
  resDF = pd.DataFrame()

  for teamName in teamToIndex:
    print(teamName)
    teamId = TEAMS[teamName]["id"]
    socialDF = team.TeamDetails(teamId).social_sites()
    socialDF['team_id'] = teamId
    resDF = resDF.append(socialDF)
    time.sleep(2)

  resDF.to_csv("data/team/team-social-sites.csv", index=False)

def load_team_background():
  resDF = pd.DataFrame()

  for teamName in teamToIndex:
    print(teamName)
    teamId = TEAMS[teamName]["id"]
    backgroundDF = team.TeamDetails(teamId).background()
    resDF = resDF.append(backgroundDF)
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