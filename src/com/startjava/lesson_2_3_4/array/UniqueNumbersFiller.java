package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersFiller {
    public static void main(String[] args) {
        System.out.println("Тест 1: -30, -10, 23");
        fillTestData(-30, -10, 23);

        System.out.println("\nТест 2: 10, 50, 10");
        fillTestData(10, 50, 10);

        System.out.println("\nТест 3: -34, -34, 1");
        fillTestData(-34, -34, 1);

        System.out.println("\nТест 4: -1, 2, -3");
        fillTestData(-1, 2, -3);

        System.out.println("\nТест 5: 5, -8, 2");
        fillTestData(5, -8, 2);
    }

    private static void fillTestData(int leftBound, int rightBound, int numbersPerLine) {
        if (!verifyBoundariesAndFormat(leftBound, rightBound, numbersPerLine)) {
            return;
        }

        int[] uniqueNumbers = generateSortedUniqueNumbers(leftBound, rightBound);
        displayNumbers(uniqueNumbers, numbersPerLine);
    }

    private static boolean verifyBoundariesAndFormat(int leftBound, int rightBound, int numbersPerLine) {
        if (numbersPerLine < 1) {
            System.out.println("Ошибка: количество чисел в строке не должно быть < 1 (" +
                    numbersPerLine + ")");
            return false;
        }

        if (leftBound > rightBound) {
            System.out.println("Ошибка: левая граница (" + leftBound + ") > правой (" +
                    rightBound + ")");
            return false;
        }

        int rangeSize = rightBound - leftBound + 1;
        int length = (int) (rangeSize * 0.75);

        if (length <= 0) {
            System.out.println("Ошибка: длина массива должна быть > 0 (получается " +
                    length + " при отрезке [" + leftBound + ", " + rightBound + "])");
            return false;
        }

        return true;
    }

    private static int[] generateSortedUniqueNumbers(int leftBound, int rightBound) {
        int rangeSize = rightBound - leftBound + 1;
        int length = (int) (rangeSize * 0.75);

        boolean[] numberUsed = new boolean[rangeSize];
        int[] uniqueNumbers = new int[length];
        Random randomGenerator = new Random();
        int index = 0;

        while (index < length) {
            int randomIndex = randomGenerator.nextInt(rangeSize);

            if (!numberUsed[randomIndex]) {
                uniqueNumbers[index] = leftBound + randomIndex;
                numberUsed[randomIndex] = true;
                index++;
            }
        }

        Arrays.sort(uniqueNumbers);
        return uniqueNumbers;
    }

    private static void displayNumbers(int[] numbers, int numbersPerLine) {
        System.out.println("Сгенерировано чисел: " + numbers.length);
        System.out.println("Отсортированный массив:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%5d", numbers[i]);

            if ((i + 1) % numbersPerLine == 0 || i == numbers.length - 1) {
                System.out.println();
            }
        }
    }
}