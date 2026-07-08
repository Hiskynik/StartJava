package com.startjava.lesson_2_3_4.hangman;

import java.util.Scanner;

public class HangmanGameMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "yes";
        while (answer.equals("yes")) {
            HangmanGame game = new HangmanGame(scanner);
            game.start();
            answer = getAnswer(scanner);
        }
        System.out.println("Спасибо за игру! До свидания.");
        scanner.close();
    }

    private static String getAnswer(Scanner scanner) {
        System.out.print("\nХотите сыграть еще? (yes/no): ");
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes") || input.equals("no")) {
                return input;
            }
            System.out.print("Введите корректный ответ [yes / no]: ");
        }
    }
}