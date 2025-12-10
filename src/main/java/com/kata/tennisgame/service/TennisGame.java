package com.kata.tennisgame.service;

import com.kata.tennisgame.service.service.TennisGameService;

public class TennisGame {

    public static void main(String[] args) {
        String scoringSequance = "ABABAA";
        TennisGameService tennisGame = new TennisGameService();
        tennisGame.startGame(scoringSequance);
    }
}
