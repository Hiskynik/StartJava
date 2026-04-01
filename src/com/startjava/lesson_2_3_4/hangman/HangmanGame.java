package com.startjava.lesson_2_3_4.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"ява", "питон", "котлин", "свифт", "бейсик", "си"};
    private static final Random RANDOM = new Random();
    private static final String[] GALLOWS = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final int MAX_PARTS = GALLOWS.length - 1;

    private final String secretWord;
    private final boolean[] guessed;
    private int mistakeParts;
    private final boolean[] lettersUsed;
    private final StringBuilder wrongLetters;
    private final Scanner scanner;
    private final StringBuilder displayMask;

    public HangmanGame(String secretWord, Scanner scanner) {
        this.secretWord = secretWord.toLowerCase();
        this.guessed = new boolean[this.secretWord.length()];
        this.mistakeParts = 0;
        this.lettersUsed = new boolean[33];
        this.wrongLetters = new StringBuilder();
        this.scanner = scanner;
        this.displayMask = new StringBuilder("*".repeat(this.secretWord.length()));
    }

    public static String getRandomWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public void start() {
        printWelcome();
        while (!isGameOver()) {
            printGameState();
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim();
            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }
            char letter = input.charAt(0);
            boolean validMove = guess(letter);
            if (validMove) {
                if (isWin()) {
                    printWin();
                    break;
                } else if (mistakeParts >= MAX_PARTS) {
                    printLoss();
                    break;
                }
            }
        }
    }

    public boolean guess(char letter) {
        int idx = getRussianLetterIndex(letter);
        if (idx == -1) {
            System.out.println("Введите русскую букву.");
            return false;
        }
        letter = Character.toLowerCase(letter);
        if (lettersUsed[idx]) {
            if (secretWord.indexOf(letter) != -1) {
                System.out.println("Буква '" + letter + "' уже была угадана. Попробуйте другую.");
            } else {
                System.out.println("Буква '" + letter + "' уже была введена " +
                        "и отсутствует в слове. Попробуйте другую.");
            }
            return false;
        }
        lettersUsed[idx] = true;
        if (secretWord.indexOf(letter) != -1) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessed[i] = true;
                    displayMask.setCharAt(i, Character.toUpperCase(letter));
                }
            }
            if (mistakeParts > 0) {
                mistakeParts--;
            }
            System.out.println("Буква '" + letter + "' есть в слове! Часть виселицы убрана.");
            return true;
        } else {
            if (mistakeParts < MAX_PARTS) {
                mistakeParts++;
                wrongLetters.append(letter).append(' ');
            }
            System.out.println("Буква '" + letter + "' отсутствует. Часть виселицы добавлена.");
            return true;
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
        return displayMask.toString();
    }

    public String getWrongLetters() {
        return wrongLetters.isEmpty() ? "нет" : wrongLetters.toString().trim();
    }

    public int getRemainingAttempts() {
        return MAX_PARTS - mistakeParts;
    }

    public String getHangmanPicture() {
        int linesToShow = mistakeParts + 1;
        if (linesToShow > GALLOWS.length) {
            linesToShow = GALLOWS.length;
        }
        StringBuilder picture = new StringBuilder();
        for (int i = 0; i < linesToShow; i++) {
            picture.append(GALLOWS[i]);
            if (i < linesToShow - 1) {
                picture.append("\n");
            }
        }
        return picture.toString();
    }

    private int getRussianLetterIndex(char c) {
        c = Character.toLowerCase(c);
        if (c == 'ё') return 6;
        if (c >= 'а' && c <= 'я') {
            if (c > 'е') return c - 'а' - 1;
            else return c - 'а';
        }
        return -1;
    }

    private void printWelcome() {
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Загадано слово из " + secretWord.length() + " букв.");
        System.out.println("У вас есть " + MAX_PARTS + " частей виселицы. " +
                "Каждая правильная буква убирает одну часть, неправильная - добавляет.");
        System.out.println("Чтобы выиграть, откройте все буквы до того, " +
                "как виселица будет полностью нарисована.\n");
    }

    private void printGameState() {
        System.out.println(getHangmanPicture());
        System.out.println("Слово: " + getDisplayWord());
        System.out.println("Ошибочные буквы: " + getWrongLetters());
        System.out.println("Осталось попыток: " + getRemainingAttempts());
    }

    private void printWin() {
        System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
    }

    private void printLoss() {
        System.out.println("\nВы проиграли! Виселица полностью нарисована.");
        System.out.println("Загаданное слово было: " + secretWord);
    }
}