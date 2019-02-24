import nba_py
from nba_py.player import PlayerList
players = PlayerList()
for player in players.info():
  print(player)

