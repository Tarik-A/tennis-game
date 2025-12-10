package com.kata.tennisgame.service.record;

import static com.kata.tennisgame.service.record.ScoreEnum.*;

public record Player(int score, boolean advantage) {
    public String getScore() {
        return switch (score) {
            case 0 -> ZERO.getScore();
            case 1 -> FIFTEEN.getScore();
            case 2 -> THIRTY.getScore();
            default -> FORTY.getScore();
        };
    }
}
