package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
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

    public static double getThresholdValue(double[] data, int referenceIndex) {
        if (!isValidIndex(referenceIndex, data.length)) {
            throw new IllegalArgumentException(String.format(
                    "Ошибка: индекс %d недопустим. Допустимый диапазон: [0, %d]",
                    referenceIndex, data.length - 1));
        }
        return data[referenceIndex];
    }

    public static void filterValuesAboveThreshold(double[] data, double threshold) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] > threshold) {
                data[i] = 0.0;
            }
        }
    }

    public static void displayValues(double[] values, String title) {
        System.out.print(title + ": ");

        for (int i = 0; i < 8 && i < values.length; i++) {
            System.out.printf("%.3f ", values[i]);
        }
        System.out.println();

        if (values.length > 8) {
            System.out.print("                  ");
            for (int i = 8; i < values.length; i++) {
                System.out.printf("%.3f ", values[i]);
            }
            System.out.println();
        }
    }

    public static void processWithThreshold(double[] originalData, int thresholdIndex) {
        System.out.println("\n--- Обработка с индексом порога: " + thresholdIndex + " ---");

        try {
            double threshold = getThresholdValue(originalData, thresholdIndex);
            System.out.printf("Пороговое значение из ячейки [%d]: %.3f%n", thresholdIndex, threshold);

            double[] processedData = originalData.clone();

            filterValuesAboveThreshold(processedData, threshold);

            displayValues(processedData, "Отфильтрованные данные");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        final int Data_size = 15;

        double[] initialValues = generateRandomValues(Data_size);

        System.out.println("Сгенерированы случайные значения:");
        displayValues(initialValues, "Исходные данные");

        int[] testCases = {-1, 15, 0, 14};

        for (int testIndex : testCases) {
            processWithThreshold(initialValues, testIndex);
        }
    }
}