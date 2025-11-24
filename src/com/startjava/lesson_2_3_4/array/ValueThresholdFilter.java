package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
    private static final int CAPACITY = 15;

    public static void main(String[] args) {
        double[] randomNums = generateRandomNumbers();

        System.out.println("Исходный массив:");
        displayNumbers(randomNums);

        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            filterByIndex(randomNums, index);
        }
    }

    private static double[] generateRandomNumbers() {
        double[] numbers = new double[CAPACITY];
        Random generator = new Random();

        for (int i = 0; i < CAPACITY; i++) {
            numbers[i] = generator.nextDouble();
        }

        return numbers;
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    private static void setNumbersAboveThresholdToZero(double[] numbers, double threshold) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > threshold) {
                numbers[i] = 0.0;
            }
        }
    }

    private static void displayNumbers(double[] numbers) {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%.3f ", numbers[i]);
        }
        System.out.println();
        
        for (int i = 8; i < numbers.length; i++) {
            System.out.printf("%.3f ", numbers[i]);
        }
        System.out.println();
    }

    private static void filterByIndex(double[] numbers, int index) {
        if (!isValidIndex(index, numbers.length)) {
            System.out.printf("\nОшибка: индекс %d недопустим. Допустимый диапазон: [0, %d]%n",
                    index, numbers.length - 1);
            return;
        }

        double threshold = numbers[index];
        System.out.printf("\nПороговое значение из ячейки [%d]: %.3f%n", index, threshold);

        System.out.println("Исходный массив:");
        displayNumbers(numbers);

        setNumbersAboveThresholdToZero(numbers, threshold);

        System.out.println("Измененный массив:");
        displayNumbers(numbers);
    }
}