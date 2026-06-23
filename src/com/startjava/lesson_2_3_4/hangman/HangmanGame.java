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
    private int mistakeParts;
    private final StringBuilder wrongLetters;
    private final StringBuilder usedLetters;
    private final Scanner scanner;
    private final StringBuilder mask;

    public HangmanGame(Scanner scanner) {
        this.secretWord = WORDS[RANDOM.nextInt(WORDS.length)];
        this.mistakeParts = 0;
        this.wrongLetters = new StringBuilder();
        this.usedLetters = new StringBuilder();
        this.scanner = scanner;
        this.mask = new StringBuilder("*".repeat(secretWord.length()));
    }

    public void start() {
        printWelcome();
        while (true) {
            printGameState();
            char letter = readLetter();
            guess(letter);

            if (isWin()) {
                printWin();
                break;
            }
            if (mistakeParts >= MAX_PARTS) {
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

    private boolean isWin() {
        return mask.indexOf("*") == -1;
    }

    private void printGameState() {
        System.out.println(getHangmanPicture());
        System.out.println("Слово: " + mask);
        System.out.println("Ошибочные буквы: " + getWrongLetters());
        System.out.println("Осталось попыток: " + getRemainingAttempts());
    }

    private String getHangmanPicture() {
        int linesToShow = mistakeParts + 1;
        if (linesToShow > GALLOWS.length) {
            linesToShow = GALLOWS.length;
        }
        StringBuilder gallows = new StringBuilder();
        for (int i = 0; i < linesToShow; i++) {
            gallows.append(GALLOWS[i]).append("\n");
        }
        return gallows.toString();
    }

    private String getWrongLetters() {
        return wrongLetters.isEmpty() ? "нет" : wrongLetters.toString();
    }

    private int getRemainingAttempts() {
        return MAX_PARTS - mistakeParts;
    }

    private char readLetter() {
        while (true) {
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }

            char letter = Character.toLowerCase(input.charAt(0));

            if ("абвгдеёжзийклмнопрстуфхцчшщъыьэюя".indexOf(letter) == -1) {
                System.out.println("Введите кириллическую букву.");
                continue;
            }

            if (usedLetters.indexOf(String.valueOf(letter)) != -1) {
                if (mask.indexOf(String.valueOf(Character.toUpperCase(letter))) != -1) {
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
        if (secretWord.indexOf(letter) != -1) {
            markLetterAsCorrect(letter);
        } else {
            markLetterAsWrong(letter);
        }
        usedLetters.append(letter);
    }

    private void markLetterAsCorrect(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                mask.setCharAt(i, Character.toUpperCase(letter));
            }
        }
        if (mistakeParts > 0) {
            mistakeParts--;
            System.out.println("Буква '" + letter + "' есть в слове! Часть виселицы убрана.");
        } else {
            System.out.println("Буква '" + letter + "' есть в слове!");
        }
    }

    private void markLetterAsWrong(char letter) {
        if (mistakeParts < MAX_PARTS) {
            mistakeParts++;
            if (!wrongLetters.isEmpty()) {
                wrongLetters.append(' ');
            }
            wrongLetters.append(letter);
        }
        System.out.println("Буква '" + letter + "' отсутствует. Часть виселицы добавлена.");
    }

    private void printWin() {
        System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
    }

    private void printLoss() {
        System.out.println("\nВы проиграли! Виселица полностью нарисована.");
        System.out.println("Загаданное слово было: " + secretWord);
    }
}