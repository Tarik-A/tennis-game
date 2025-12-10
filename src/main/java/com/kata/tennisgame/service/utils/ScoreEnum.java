package com.kata.tennisgame.service.record;

public enum ScoreEnum {
    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("Advantage");

    private final String score;

    ScoreEnum(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

}
