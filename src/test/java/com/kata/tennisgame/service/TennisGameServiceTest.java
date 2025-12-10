package com.kata.tennisgame.service;

import com.kata.tennisgame.service.service.TennisGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TennisGameServiceTest {

    TennisGameService tennisGame;

    @BeforeEach
    void setUp() {
        tennisGame = new TennisGameService();
    }

    @Test
    void shouldReturnErrorMessage_whenScorerDifferentThatAOrB() {
        char scoringSequence = 'C';

        String actual = tennisGame.processPoint(scoringSequence);

        String expected = "There no 'C' player in this game !";

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetCorrectScore_whenAScores() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String scoringSequence = "A";

        tennisGame.startGame(scoringSequence);

        String expected = "Player A : 15 / Player B : 0";

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void shouldPlayerBWins_WhenScoresMore() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String scoringSequence = "BBBB";

        tennisGame.startGame(scoringSequence);

        String expected = "Player B wins the game";

        assertTrue(out.toString().contains(expected));
    }

    @Test
    void shouldPlayerAWins_WhenScoresMore() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String scoringSequence = "AABAA";

        tennisGame.startGame(scoringSequence);

        String expected = "Player A wins the game";

        assertTrue(out.toString().contains(expected));
    }


    @Test
    void shouldDeuce_WhenAAndBScoresAreEquals() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String scoringSequence = "AABABB";

        tennisGame.startGame(scoringSequence);

        String expected = "Player A : 40 / Player B : 40";

        assertTrue(out.toString().contains(expected));
    }

}
