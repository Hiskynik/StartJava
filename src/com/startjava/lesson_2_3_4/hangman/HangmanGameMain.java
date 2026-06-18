package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String answer = "yes";
        while (true) {
            if (answer.equals("yes")) {
                HangmanGame game = new HangmanGame(scanner);
                game.start();
            }
            System.out.print("\nХотите сыграть еще? (yes/no): ");
            answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("no")) {
                break;
            } else if (!answer.equals("yes")) {
                System.out.println("Введите корректный ответ [yes / no]:");
            }
        }
        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }
}