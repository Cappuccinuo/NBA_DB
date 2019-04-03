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
    # util.load_player_game_data_at_year("BOS", 2017)
    # teamId = TEAMS["BOS"]["id"]
    # socialDF = team.TeamDetails(teamId).social_sites()
    # backgroundDF = team.TeamDetails(teamId).background()
    # resDF = pd.DataFrame()
    # resDF = resDF.append(backgroundDF, sort=False)
    # resDF.ix[0, 'facebook'] = "haha"
    # teamId = TEAMS["ATL"]["id"]
    # socialDF = team.TeamDetails(teamId).social_sites()
    # backgroundDF = team.TeamDetails(teamId).background()
    # resDF = pd.concat([resDF, backgroundDF], ignore_index=True, sort=False)
    # resDF.ix[1, 'facebook'] = "hahaha"
    # # resDF.append(backgroundDF)
    # # f = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Facebook']['WEBSITE_LINK'][0]
    # # i = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Instagram']['WEBSITE_LINK']
    # # t = socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Twitter']['WEBSITE_LINK']
    # # print(i.iloc[0])
    # print(resDF)

    util.load_team_background()



    # resDF['Facebook'] = \
    #   socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Facebook']['WEBSITE_LINK']
    # resDF['Instagram'] = \
    #   socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Instagram']['WEBSITE_LINK']
    # resDF['Twitter'] = \
    #   socialDF.loc[socialDF['ACCOUNTTYPE'] == 'Twitter']['WEBSITE_LINK']
    # print(resDF)
    # print(backgroundDF)


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