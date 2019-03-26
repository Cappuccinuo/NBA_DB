Table:
Game(game_id, home_team_id, away_team_id, home_score, away_score)
Player(player_id, from_year..., team_id...)
Team(team_id, history, reward, social_site_id)
Team_Season(team_id, season, ranking, FGM, AST...)
Team_Social(team_id, social_site)
Team_Score_Game(game_id, team_id, score, reb, ast...)
Player_score_Game(game_id, player_id, team_id...)