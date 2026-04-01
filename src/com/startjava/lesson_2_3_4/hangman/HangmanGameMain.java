package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            String secretWord = HangmanGame.getRandomWord();
            HangmanGame game = new HangmanGame(secretWord, scanner);
            game.start();

            System.out.print("\nХотите сыграть еще? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("no")) {
                break;
            }
        } while (true);

        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }
}