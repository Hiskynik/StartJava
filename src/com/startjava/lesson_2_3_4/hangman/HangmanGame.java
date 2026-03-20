package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGame {
    private final String secretWord;
    private final boolean[] guessed;
    private int mistakeParts;
    private final boolean[] lettersUsed;
    private final StringBuilder wrongLetters;
    private final Scanner scanner;

    private static final String[] HANGMAN_STAGES = {
            "_______",
            "|     |",
            "|     @",
            "|    /|\\",
            "|    / \\",
            "| GAME OVER!"
    };
    private static final int MAX_PARTS = HANGMAN_STAGES.length - 1;

    public HangmanGame(String secretWord, Scanner scanner) {
        this.secretWord = secretWord.toLowerCase();
        this.guessed = new boolean[this.secretWord.length()];
        this.mistakeParts = 0;
        this.lettersUsed = new boolean[65536];
        this.wrongLetters = new StringBuilder();
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Загадано слово из " + secretWord.length() + " букв.");
        System.out.println("У вас есть " + MAX_PARTS + " частей виселицы. " +
                "Каждая правильная буква убирает одну часть, неправильная - добавляет.");
        System.out.println("Чтобы выиграть, откройте все буквы до того, " +
                "как виселица будет полностью нарисована.\n");

        while (!isGameOver()) {
            System.out.println(getHangmanPicture());
            System.out.println("Слово: " + getDisplayWord());
            System.out.println("Ошибочные буквы: " + getWrongLetters());
            System.out.println("Осталось попыток: " + getRemainingAttempts());
            System.out.print("Введите букву: ");

            String input = scanner.nextLine().trim();

            if (input.length() != 1) {
                System.out.println("Пожалуйста, введите одну букву.");
                continue;
            }

            char letter = input.charAt(0);
            int result = guess(letter);

            switch (result) {
                case 1:
                    System.out.println("Буква '" + letter + "' есть в слове! Часть виселицы убрана.");
                    break;
                case 0:
                    System.out.println("Буква '" + letter + "' отсутствует. Часть виселицы добавлена.");
                    break;
                case 2:
                    System.out.println("Буква '" + letter + "' уже была введена " +
                            "и отсутствует в слове. Попробуйте другую.");
                    continue;
                case 3:
                    System.out.println("Буква '" + letter + "' уже была угадана. Попробуйте другую.");
                    continue;
                case -1:
                    System.out.println("Введите русскую букву.");
                    continue;
                default:
                    System.out.println("Некорректный ввод.");
                    continue;
            }

            if (isWin()) {
                System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
                break;
            } else if (mistakeParts >= MAX_PARTS) {
                System.out.println("\nВы проиграли! Виселица полностью нарисована.");
                System.out.println("Загаданное слово было: " + secretWord);
                break;
            }
        }
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
}
