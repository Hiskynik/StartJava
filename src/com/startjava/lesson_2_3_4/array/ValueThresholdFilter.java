package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
    private static final int MEASUREMENTS_COUNT = 15;

    public static void main(String[] args) {
        double[] sensorReadings = generateSensorReadings();

        System.out.println("Сгенерированы случайные значения:");
        displayReadings(sensorReadings, "Исходные данные");

        int[] thresholdIndexes = {-1, 15, 0, 14};

        for (int index : thresholdIndexes) {
            filterReadingsByThreshold(sensorReadings, index);
        }
    }

    private static double[] generateSensorReadings() {
        double[] readings = new double[MEASUREMENTS_COUNT];
        Random generator = new Random();

        for (int i = 0; i < MEASUREMENTS_COUNT; i++) {
            readings[i] = generator.nextDouble();
        }

        return readings;
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    private static double getThresholdReading(double[] readings, int thresholdIndex) {
        return readings[thresholdIndex];
    }

    private static void setReadingsAboveThresholdToZero(double[] readings, double threshold) {
        for (int i = 0; i < readings.length; i++) {
            if (readings[i] > threshold) {
                readings[i] = 0.0;
            }
        }
    }

    private static double[] createFilteredReadings(double[] originalReadings, double threshold) {
        double[] filteredReadings = originalReadings.clone();
        setReadingsAboveThresholdToZero(filteredReadings, threshold);
        return filteredReadings;
    }

    private static void displayReadings(double[] readings, String title) {
        System.out.print(title + ": ");

        for (int i = 0; i < 8 && i < readings.length; i++) {
            System.out.printf("%.3f ", readings[i]);
        }
        System.out.println();

        if (readings.length > 8) {
            System.out.printf("%18s", "");
            for (int i = 8; i < readings.length; i++) {
                System.out.printf("%.3f ", readings[i]);
            }
            System.out.println();
        }
    }

    private static void filterReadingsByThreshold(double[] sensorReadings, int thresholdIndex) {
        System.out.println("\n--- Обработка с индексом порога: " + thresholdIndex + " ---");

        if (!isValidIndex(thresholdIndex, sensorReadings.length)) {
            System.out.printf("Ошибка: индекс %d недопустим. Допустимый диапазон: [0, %d]%n",
                    thresholdIndex, sensorReadings.length - 1);
            return;
        }

        double thresholdValue = getThresholdReading(sensorReadings, thresholdIndex);
        System.out.printf("Пороговое значение из ячейки [%d]: %.3f%n", thresholdIndex, thresholdValue);

        double[] zeroedReadings = createFilteredReadings(sensorReadings, thresholdValue);
        displayReadings(zeroedReadings, "Отфильтрованные данные");
    }
}