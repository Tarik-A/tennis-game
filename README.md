# Tennis Game
This is an application to implement a simple tennis score computer.

The scoring system consist in one game, divided by points :

Each player starts a game with 0 point.

If the player wins the 1st ball, he will have 15 points. 2nd balls won : 30 points. 3rd ball won : 40points.

If a player have 40 points and wins the ball, he wins the game, however there are special rules.

If both players have 40 points the players are “deuce”.

If the game is in deuce, the winner of the ball will have advantage

If the player with advantage wins the ball he wins the game

If the player without advantage wins the ball they are back at “deuce”.


****For example the following input “ABABAA” should print :****

Player A : 15 / Player B : 0

Player A : 15 / Player B : 15

Player A : 30 / Player B : 15

Player A : 30 / Player B : 30

Player A : 40 / Player B : 30

Player A wins the game
