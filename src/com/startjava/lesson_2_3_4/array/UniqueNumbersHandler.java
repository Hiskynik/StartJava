package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class UniqueNumbersHandler {
    public static void main(String[] args) {
        System.out.println("Тест 1: -30, -10, 23");
        handleTestData(-30, -10, 23);

        System.out.println("\nТест 2: 10, 50, 10");
        handleTestData(10, 50, 10);

        System.out.println("\nТест 3: -34, -34, 1");
        handleTestData(-34, -34, 1);

        System.out.println("\nТест 4: -1, 2, -3");
        handleTestData(-1, 2, -3);

        System.out.println("\nТест 5: 5, -8, 2");
        handleTestData(5, -8, 2);
    }

    public static void handleTestData(int leftBound, int rightBound, int numbersPerLine) {
        String validationError = verifyBoundariesAndFormat(leftBound, rightBound, numbersPerLine);

        if (validationError != null) {
            System.out.println(validationError);
            return;
        }

        int[] uniqueNumbers = createUniqueNumberSet(leftBound, rightBound);

        displayNumbers(uniqueNumbers, numbersPerLine);
    }

    public static String verifyBoundariesAndFormat(int leftBound, int rightBound, int numbersPerLine) {
        if (numbersPerLine < 1) {
            return "Ошибка: количество чисел в строке не должно быть < 1 (" + numbersPerLine + ")";
        }

        if (leftBound > rightBound) {
            return "Ошибка: левая граница (" + leftBound + ") > правой (" + rightBound + ")";
        }

        int rangeSize = rightBound - leftBound + 1;
        int requiredCount = (int) (rangeSize * 0.75);

        if (requiredCount <= 0) {
            return "Ошибка: длина массива должна быть > 0 (получается " + requiredCount + " при отрезке [" +
                    leftBound + ", " + rightBound + "])";
        }

        return null;
    }

    public static int[] createUniqueNumberSet(int leftBound, int rightBound) {
        int rangeSize = rightBound - leftBound + 1;
        int requiredCount = (int) (rangeSize * 0.75);

        boolean[] numberUsed = new boolean[rangeSize];
        int[] numberSet = new int[requiredCount];
        Random randomGenerator = new Random();
        int currentCount = 0;

        while (currentCount < requiredCount) {
            int randomIndex = randomGenerator.nextInt(rangeSize);

            if (!numberUsed[randomIndex]) {
                numberSet[currentCount] = leftBound + randomIndex;
                numberUsed[randomIndex] = true;
                currentCount++;
            }
        }

        return numberSet;
    }

    public static void displayNumbers(int[] numbers, int numbersPerLine) {
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);

        System.out.println("Сгенерировано чисел: " + sortedNumbers.length);
        System.out.println("Отсортированный массив:");

        for (int i = 0; i < sortedNumbers.length; i++) {
            System.out.printf("%5d", sortedNumbers[i]);

            if ((i + 1) % numbersPerLine == 0 || i == sortedNumbers.length - 1) {
                System.out.println();
            }
        }
    }
}