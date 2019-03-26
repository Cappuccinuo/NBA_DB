import pandas as pd
from nba_py.constants import TEAMS
from nba_py import team
from nba_py import game
import time
from nba_py.player import PlayerList

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
  players = PlayerList().info()
  players.to_csv("data/player/players.csv", index=False)

def get_season(year):
  CURRENT_SEASON = str(year) + "-" + str(year + 1)[2:]
  return CURRENT_SEASON

