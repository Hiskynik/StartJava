package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
    public static void main(String[] args) {
        final int Num_size = 15;

        double[] initialValues = generateRandomValues(Num_size);

        System.out.println("Сгенерированы случайные значения:");
        displayValues(initialValues, "Исходные данные");

        int[] testCases = {-1, 15, 0, 14};

        for (int testIndex : testCases) {
            thresholdValue(initialValues, testIndex);
        }
    }

    public static double[] generateRandomValues(int count) {
        double[] values = new double[count];
        Random generator = new Random();

        for (int i = 0; i < count; i++) {
            values[i] = generator.nextDouble();
        }

        return values;
    }

    public static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    public static double getThresholdValue(double[] num, int referenceIndex) {
        if (!isValidIndex(referenceIndex, num.length)) {
            throw new IllegalArgumentException(String.format(
                    "Ошибка: индекс %d недопустим. Допустимый диапазон: [0, %d]",
                    referenceIndex, num.length - 1));
        }
        return num[referenceIndex];
    }

    public static void filterValuesAboveThreshold(double[] num, double threshold) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] > threshold) {
                num[i] = 0.0;
            }
        }
    }

    public static void displayValues(double[] values, String title) {
        System.out.println(title + ":");
        for (double value : values) {
            System.out.printf("%.3f%n", value);
        }
    }

    public static void thresholdValue(double[] originalValue, int thresholdIndex) {
        System.out.println("\n--- Обработка с индексом порога: " + thresholdIndex + " ---");

        try {
            double threshold = getThresholdValue(originalValue, thresholdIndex);
            System.out.printf("Пороговое значение из ячейки [%d]: %.3f%n", thresholdIndex, threshold);

            double[] transformedValue = originalValue.clone();

            filterValuesAboveThreshold(transformedValue, threshold);

            displayValues(transformedValue, "Отфильтрованные данные");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}