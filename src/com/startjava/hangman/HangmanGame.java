package com.startjava.hangman;

public class HangmanGame {
    private final String secretWord;
    private final boolean[] guessed;
    private int mistakeParts;
    private final boolean[] lettersUsed;
    private final StringBuilder wrongLetters;

    private static final String[] HANGMAN_STAGES = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final int MAX_PARTS = HANGMAN_STAGES.length - 1;

    public HangmanGame(String secretWord) {
        this.secretWord = secretWord.toLowerCase();
        this.guessed = new boolean[this.secretWord.length()];
        this.mistakeParts = 0;
        this.lettersUsed = new boolean[65536];
        this.wrongLetters = new StringBuilder();
    }

    private boolean isRussianLetter(char c) {
        c = Character.toLowerCase(c);
        return (c >= 'а' && c <= 'я') || c == 'ё';
    }

    public int guess(char letter) {
        if (!isRussianLetter(letter)) {
            return -1;
        }
        letter = Character.toLowerCase(letter);
        int idx = letter;

        if (lettersUsed[idx]) {
            return secretWord.indexOf(letter) != -1 ? 3 : 2;
        }

        lettersUsed[idx] = true;

        if (secretWord.indexOf(letter) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessed[i] = true;
                }
            }
            if (mistakeParts > 0) {
                mistakeParts--;
            }
            return 1;
        } else {
            if (mistakeParts < MAX_PARTS) {
                mistakeParts++;
                wrongLetters.append(letter).append(' ');
            }
            return 0;
        }
    }

    public boolean isGameOver() {
        return isWin() || mistakeParts >= MAX_PARTS;
    }

    public boolean isWin() {
        for (boolean b : guessed) {
            if (!b) return false;
        }
        return true;
    }

    public String getDisplayWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessed[i]) {
                sb.append(Character.toUpperCase(secretWord.charAt(i)));
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }

    public String getWrongLetters() {
        return wrongLetters.isEmpty() ? "нет" : wrongLetters.toString().trim();
    }

    public int getRemainingAttempts() {
        return MAX_PARTS - mistakeParts;
    }

    public String getHangmanPicture() {
        int linesToShow = mistakeParts + 1;
        if (linesToShow > HANGMAN_STAGES.length) {
            linesToShow = HANGMAN_STAGES.length;
        }
        StringBuilder picture = new StringBuilder();
        for (int i = 0; i < linesToShow; i++) {
            picture.append(HANGMAN_STAGES[i]);
            if (i < linesToShow - 1) {
                picture.append("\n");
            }
        }
        return picture.toString();
    }

    public int getMistakeParts() {
        return mistakeParts;
    }

    public int getMaxParts() {
        return MAX_PARTS;
    }
}
