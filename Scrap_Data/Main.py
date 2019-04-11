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
    # self.truncate_player_game_id()
    a = players = PlayerList().info()
    a.to_csv('test.csv', index=False)

  def truncate_player_game_id(self):
    playerPD = pd.read_csv("data/game/2017-18-players.csv")
    playerPD[['GAME_ID']] = playerPD.apply(lambda row: self.apply_truncate(row), axis=1)
    playerPD.to_csv("data/game/2017-18-players.csv", index=False)

  def apply_truncate(self, row):
    game_id = row['GAME_ID']
    return str(game_id)

  def get_player_team_mapping(self):
    playerPD = pd.read_csv("data/player/players.csv")
    header = ['PERSON_ID', 'TEAM_ID']
    playerTeamPD = playerPD[header]
    playerTeamPD.to_csv("data/player/players-teams.csv", index=False)
    playerPD = playerPD.drop(columns=['TEAM_ID'])
    playerPD.to_csv("data/player/players-info.csv", index=False)

  def get_team_conference(self):
    teamPD = pd.read_csv("data/team/team-background.csv")
    teamPD = teamPD.reindex(columns = teamPD.columns.tolist() + ['conf'])
    teamPD[['conf']] = teamPD.apply(lambda row: self.label_conference(row), axis=1)
    teamPD.to_csv("data/team/team-background.csv", index=False)

  def label_conference(self, row):
    abbr = row['ABBREVIATION']
    confInfo = TEAMS[abbr]['conference']
    return confInfo

  def extract_game_info(self):
    temp = pd.read_csv("data/game/2017-18-teams.csv")
    header = ['Game_ID', 'GAME_DATE', 'Season', 'MATCHUP']
    newPD = temp[header]
    # https://stackoverflow.com/questions/16327055/how-to-add-an-empty-column-to-a-dataframe
    newPD = newPD.reindex(columns = newPD.columns.tolist() + ['away_team_id', 'home_team_id'])
    # https://stackoverflow.com/questions/26886653/pandas-create-new-column-based-on-values-from-other-columns
    # https://stackoverflow.com/questions/50410625/add-multiple-columns-to-pandas-dataframe
    newPD[['away_team_id', 'home_team_id']] = \
      newPD.apply(lambda row: self.label_column(row), axis=1)
    newPD = newPD.drop(columns=['MATCHUP']).drop_duplicates()
    newPD.to_csv("data/game/2017-18-game_info.csv", index=False)

    # temp.drop(columns=['GAME_DATE', 'MATCHUP', 'Season'])
    # temp.to_csv("data/game/2017-18-teams.csv")

  def label_column(self, row):
    matchup = row['MATCHUP']
    split = str.split(matchup, " ")
    # away_team_id, home_team_id
    if (split[1] == '@'):
      return pd.Series([TEAMS[split[0]]['id'], TEAMS[split[2]]['id']])
    else:
      return pd.Series([TEAMS[split[2]]['id'], TEAMS[split[0]]['id']])

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