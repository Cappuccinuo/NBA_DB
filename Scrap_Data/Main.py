import pandas as pd
import util
from resources.teams import teamToIndex
import time
from nba_py import game
from nba_py import team
from nba_py import player
from nba_py.constants import TEAMS
from nba_py.player import PlayerList
# players = PlayerList()
# playerlist = _api_scrape(players.json, 0)

class Main(object):
  def main(self):
    # self.get_all_team_game_data_between_year(2017, 2017)
    # a = team.TeamDetails(TEAMS["BOS"]["id"]).social_sites()
    # a.to_csv("test.csv", index=False)
    a = team.TeamSeasons(TEAMS["BOS"]["id"]).info()
    a.to_csv("test.csv", index=False)



  def get_all_team_game_data_between_year(self, startYear, endYear):
    gameData = pd.DataFrame()
    playerData = pd.DataFrame()
    for teamName in teamToIndex:
      print("current team: " + teamName)
      gD, pD = util.load_team_game_data_between_years(teamName, startYear, endYear)
      gameData = gameData.append(gD)
      playerData = playerData.append(pD)
      break
      time.sleep(60)

    gameRes = pd.DataFrame(gameData)
    gameRes.to_csv("data/game/" + str(startYear) + "-" + str(endYear) + "-teams.csv", index = False)
    playerRes = pd.DataFrame(playerData)
    playerRes.to_csv("data/game/" + str(startYear) + "-" + str(endYear) + "-players.csv", index = False)


if __name__ == '__main__':
    Main().main()