package com.startjava.lesson_2_3_4.hangman;

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
            HangmanGame game = new HangmanGame(secretWord, scanner);

            game.start();

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