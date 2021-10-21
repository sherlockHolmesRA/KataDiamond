package com.katadiamondtdd.katadiamond;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

public class Letter {

	static final int CODE_A = "A".codePointAt(0);
    private final String letter;
    private int matchingFirstCode;

    Letter(String letter) {
        this.letter = letter;
        validate();
        matchingFirstCode = CODE_A;
    }

    private void validate() {
        if (letter == null) {
            throw new IllegalArgumentException("Letter missing!");
        } else if (letter.isEmpty()) {
            throw new IllegalArgumentException("A letter is expected!");
        } else if (otherThanLetters()) {
            throw new IllegalArgumentException("Only letters are expected!");
        } else if (moreThanOneLetter()) {
            throw new IllegalArgumentException("Only one letter is expected!");
        }
    }

    private boolean otherThanLetters() {
        return !letter.matches("^[A-Za-z]*$");
    }

    private boolean moreThanOneLetter() {
        return letter.length() > 1;
    }

    IntStream streamOfCodes() {
        return rangeClosed(matchingFirstCode, getCode());
    }

    int getMatchingFirstCode() {
        return matchingFirstCode;
    }

    int getCode() {
        return letter.codePointAt(0);
    }

}