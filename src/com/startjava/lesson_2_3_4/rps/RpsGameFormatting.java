package com.startjava.lesson_2_3_4.rps;

import java.util.Random;
import java.util.Scanner;

// Игра Камень-Ножницы-Бумага
public class RpsGameFormatting {
    private static final String ROCK = "R";
    private static final String SCISSORS = "S";
    private static final String PAPER = "P";

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        String name1 = inputName(scanner);
        String name2 = inputName(scanner);

        // Ход первого игрока
        int position1 = generatePosition(name1, random);
        String sign1 = determineSign(position1);
        showSigns(sign1);

        // Ход второго игрока
        int position2 = generatePosition(name2, random);
        String sign2 = determineSign(position2);
        showSigns(sign2);

        determineWinner(name1, sign1, name2, sign2);
        scanner.close();
    }

    private static String inputName(Scanner scanner) {
        System.out.print("Введите имя игрока: ");
        return scanner.nextLine();
    }

    private static int generatePosition(String name, Random random) {
        System.out.println("Ход " + name + ": ");
        return random.nextInt(1, 100);
    }

    private static String determineSign(int position) {
        if (position > 66) {
            return ROCK;
        } else if (position > 33) {
            return SCISSORS;
        } else {
            return PAPER;
        }
    }

    private static void showSigns(String sign) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.print(ROCK + "\r");
            Thread.sleep(100);
            System.out.print(SCISSORS + "\r");
            Thread.sleep(100);
            System.out.print(PAPER + "\r");
            Thread.sleep(100);
        }
        System.out.println(sign);
    }

    private static void determineWinner(String name1, String sign1, String name2, String sign2) {
        if (sign1.equals(sign2)) {
            System.out.println("\nПобедила дружба!");
            return;
        }

        boolean isName1Winner = (sign1.equals(ROCK) && sign2.equals(SCISSORS)) ||
                (sign1.equals(SCISSORS) && sign2.equals(PAPER)) ||
                (sign1.equals(PAPER) && sign2.equals(ROCK));

        if (isName1Winner) {
            System.out.println("\nПобедил - " + name1);
        } else {
            System.out.println("\nПобедил - " + name2);
        }
    }
}