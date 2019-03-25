import nba_py
from resources.teams import teamToIndex
from nba_py.constants import TEAMS
from nba_py import _api_scrape
from nba_py import team
import numpy as np
import pandas as pd


# from nba_py.player import PlayerList
# players = PlayerList()
# playerlist = _api_scrape(players.json, 0)

class Test(object):
  def main(self):
    team_name = 'BOS'
    team_id = TEAMS[team_name]['id']
    year = 2017
    df = team.TeamGameLogs(team_id, self.get_season(year)).info()
    # header = "Team_ID, Game_ID, GAME_DATE, MATCHUP, WL, W, L, W_PCT, MIN, FGM, FGA, FG_PCT, FG3M, FG3A, FG3_PCT, FTM, FTA, FT_PCT, OREB, DREB, REB, AST, STL, BLK, TOV, PF, PTS"
    # np.savetxt('test.csv', df, delimiter=",", fmt='%s', header=header)
    res = pd.DataFrame(df)
    res.to_csv("test.csv", index=False)


  def get_season(self, year):
    CURRENT_SEASON = str(year) + "-" + str(year + 1)[2:]
    return CURRENT_SEASON

if __name__ == '__main__':
    Test().main()