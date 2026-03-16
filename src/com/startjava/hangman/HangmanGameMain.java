package com.startjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanGameMain {
    private static final String[] WORDS = {"ява", "питон", "котлин", "свифт", "бейсик", "си"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            String secretWord = WORDS[random.nextInt(WORDS.length)];
            HangmanGame game = new HangmanGame(secretWord);

            System.out.println("Добро пожаловать в игру Виселица!");
            System.out.println("Загадано слово из " + secretWord.length() + " букв.");
            System.out.println("У вас есть " + game.getMaxParts() + " частей виселицы. Каждая правильная буква убирает одну часть, неправильная - добавляет.");
            System.out.println("Чтобы выиграть, откройте все буквы до того, как виселица будет полностью нарисована.\n");

            while (!game.isGameOver()) {
                System.out.println(game.getHangmanPicture());
                System.out.println("Слово: " + game.getDisplayWord());
                System.out.println("Ошибочные буквы: " + game.getWrongLetters());
                System.out.println("Осталось попыток: " + game.getRemainingAttempts());
                System.out.print("Введите букву: ");

                String input = scanner.nextLine().trim();

                if (input.length() != 1) {
                    System.out.println("Пожалуйста, введите одну букву.");
                    continue;
                }

                char letter = input.charAt(0);
                int result = game.guess(letter);

                switch (result) {
                    case 1:
                        System.out.println("Буква '" + letter + "' есть в слове! Часть виселицы убрана.");
                        break;
                    case 0:
                        System.out.println("Буква '" + letter + "' отсутствует. Часть виселицы добавлена.");
                        break;
                    case 2:
                        System.out.println("Буква '" + letter + "' уже была введена и отсутствует в слове. Попробуйте другую.");
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

                if (game.isWin()) {
                    System.out.println("\nПоздравляем! Вы угадали слово: " + secretWord);
                    break;
                } else if (game.getMistakeParts() >= game.getMaxParts()) {
                    System.out.println("\nВы проиграли! Виселица полностью нарисована.");
                    System.out.println("Загаданное слово было: " + secretWord);
                    break;
                }
            }

            System.out.print("\nХотите сыграть еще? (yes/no): ");
            String answer;
            while (true) {
                answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("yes") || answer.equals("no")) {
                    break;
                } else {
                    System.out.print("Введите корректный ответ [yes / no]: ");
                }
            }
            playAgain = answer.equals("yes");
        } while (playAgain);

        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }
}