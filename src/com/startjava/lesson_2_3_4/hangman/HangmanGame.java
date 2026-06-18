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
    private final StringBuilder mask;

    public HangmanGame(Scanner scanner) {
        this.secretWord = WORDS[RANDOM.nextInt(WORDS.length)];
        this.guessed = new boolean[secretWord.length()];
        this.mistakeParts = 0;
        this.lettersUsed = new boolean[33];
        this.wrongLetters = new StringBuilder();
        this.scanner = scanner;
        this.mask = new StringBuilder("*".repeat(secretWord.length()));
    }

    public void start() {
        printWelcome();
        while (!isGameOver()) {
            printGameState();
            char letter = readLetter();
            guess(letter);
            if (isWin()) {
                printWin();
                break;
            }
            if (isGameOver()) {
                printLoss();
                break;
            }
        }
    }

    private void printWelcome() {
        System.out.printf("""
                Добро пожаловать в игру Виселица!
                Загадано слово из %d букв.
                У вас есть %d частей виселицы. Каждая правильная буква убирает одну часть, неправильная -
                добавляет.
                Чтобы выиграть, откройте все буквы до того, как виселица будет полностью нарисована.
                %n""", secretWord.length(), MAX_PARTS);
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

    public String getWrongLetters() {
        return wrongLetters.isEmpty() ? "нет" : wrongLetters.toString().trim();
    }

    public int getRemainingAttempts() {
        return MAX_PARTS - mistakeParts;
    }

    private void printGameState() {
        System.out.println(getHangmanPicture());
        System.out.println("Слово: " + mask.toString());
        System.out.println("Ошибочные буквы: " + getWrongLetters());
        System.out.println("Осталось попыток: " + getRemainingAttempts());
    }

    private char readLetter() {
        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }

            char letter = input.charAt(0);
            int idx = getRussianLetterIndex(letter);

            if (idx == -1) {
                System.out.println("Введите кириллическую букву.");
                continue;
            }

            letter = Character.toLowerCase(letter);
            if (lettersUsed[idx]) {
                if (secretWord.indexOf(letter) != -1) {
                    System.out.println("Буква '" + letter + "' уже была угадана. Попробуйте другую.");
                } else {
                    System.out.println("Буква '" + letter + "' уже была введена " +
                            "и отсутствует в слове. Попробуйте другую.");
                }
                continue;
            }

            return letter;
        }
    }

    private void guess(char letter) {
        markLetterUsed(letter);
        if (secretWord.indexOf(letter) != -1) {
            markLetterAsCorrect(letter);
        } else {
            markLetterAsWrong(letter);
        }
    }

    private void markLetterUsed(char letter) {
        lettersUsed[getRussianLetterIndex(letter)] = true;
    }

    private void markLetterAsCorrect(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessed[i] = true;
                mask.setCharAt(i, Character.toUpperCase(letter));
            }
        }
        if (mistakeParts > 0) {
            mistakeParts--;
        }
        System.out.println("Буква '" + letter + "' есть в слове! Часть виселицы убрана.");
    }

    private void markLetterAsWrong(char letter) {
        if (mistakeParts < MAX_PARTS) {
            mistakeParts++;
            wrongLetters.append(letter).append(' ');
        }
        System.out.println("Буква '" + letter + "' отсутствует. Часть виселицы добавлена.");
    }

    private int getRussianLetterIndex(char c) {
        c = Character.toLowerCase(c);
        if (!String.valueOf(c).matches("[а-яё]")) {
            return -1;
        }
        if (c == 'ё') return 6;
        if (c > 'е') return c - 'а' - 1;
        return c - 'а';
    }

    private void printWin() {
        System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
    }

    private void printLoss() {
        System.out.println("\nВы проиграли! Виселица полностью нарисована.");
        System.out.println("Загаданное слово было: " + secretWord);
    }
}