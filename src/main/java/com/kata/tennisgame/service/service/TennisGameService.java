package com.kata.tennisgame.service.service;

import com.kata.tennisgame.service.record.Player;

import static com.kata.tennisgame.service.record.ScoreEnum.ADVANTAGE;
import static com.kata.tennisgame.service.record.ScoreEnum.FORTY;

public class TennisGameService {

    public static final String PLAYER_WINS_THE_GAME = "Player %s wins the game";
    
    private String winnerMessage = null;
    private Player playerOne;
    private Player playerTwo;
    private boolean deuce;
    private boolean gameEnd = false;

    public TennisGameService() {
        playerOne = new Player(0, false);
        playerTwo = new Player(0, false);
    }

    public void startGame(String scoringSequence) {
        for (char scorer : scoringSequence.toCharArray()) {
            processPoint(scorer);
            if (gameEnd) {
                System.out.println(winnerMessage);
            } else
                System.out.println(buildScoreDisplay());
        }
    }

    private String buildScoreDisplay() {

        if (!deuce) {
            return String.format("Player A : %s / Player B : %s", playerOne.getScore(), playerTwo.getScore());
        }

        if (playerOne.advantage()) {
            return String.format("Player A : %s / Player B : %s", ADVANTAGE.getScore(), playerTwo.getScore());
        } else if (playerTwo.advantage()) {
            return String.format("Player A : %s / Player B : %s", playerOne.getScore(), ADVANTAGE.getScore());
        }

        return String.format("Player A : %s / Player B : %s", FORTY.getScore(), FORTY.getScore());
    }

    public String processPoint(char scorer) {

        if (scorer != 'A' && scorer != 'B') {
            return String.format("There no '%s' player in this game !", scorer);
        }

        if (gameEnd) return null;

        if (scorer == 'A') {
            return handlePointScoringPlayerA();
        } else {
            return handlePointScoringPlayerB();
        }
    }

    private String handlePointScoringPlayerA() {
        if (deuce) {
            if (playerOne.advantage()) {
                gameEnd = true;
                winnerMessage = String.format(PLAYER_WINS_THE_GAME, "A");
                return winnerMessage;
            }

            playerOne = new Player(playerOne.score(), true);
            playerTwo = new Player(playerTwo.score(), false);
            return null;
        }

        if (playerOne.score() == 3 && playerTwo.score() == 3) {
            deuce = true;
            return null;
        }

        if (playerOne.score() == 3) {
            gameEnd = true;
            winnerMessage = String.format(PLAYER_WINS_THE_GAME, "A");
            return winnerMessage;
        }

        playerOne = new Player(playerOne.score() + 1, false);
        return null;
    }

    private String handlePointScoringPlayerB() {
        if (deuce) {
            if (playerTwo.advantage()) {
                gameEnd = true;
                winnerMessage = String.format(PLAYER_WINS_THE_GAME, "B");
                return winnerMessage;
            }

            playerTwo = new Player(playerTwo.score(), true);
            playerOne = new Player(playerOne.score(), false);
            return null;
        }

        if (playerOne.score() == 3 && playerTwo.score() == 3) {
            deuce = true;
            return null;
        }

        if (playerTwo.score() == 3) {
            gameEnd = true;
            winnerMessage = String.format(PLAYER_WINS_THE_GAME, "B");
            return winnerMessage;
        }

        playerTwo = new Player(playerTwo.score() + 1, false);
        return null;
    }
}
