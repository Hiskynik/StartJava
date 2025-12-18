package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
    private static final int CAPACITY = 15;

    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            float[] randomNums = generateRandomNums();
            float[] filteredNums = filterAboveIndexValue(randomNums, index);

            if (filteredNums == null) {
                continue;
            }

            displayNums(randomNums, "Исходный массив");
            System.out.printf("Пороговое значение из ячейки [%d]: %.3f%n", index, randomNums[index]);
            displayNums(filteredNums, "Измененный массив");
        }
    }

    private static float[] generateRandomNums() {
        float[] nums = new float[CAPACITY];
        Random generator = new Random();
        for (int i = 0; i < CAPACITY; i++) {
            nums[i] = generator.nextFloat();
        }
        return nums;
    }

    private static float[] filterAboveIndexValue(float[] originalNums, int index) {
        if (!isValidIndex(index, originalNums.length)) {
            System.out.printf("Ошибка: индекс %d недопустим. Допустимый диапазон: [0, %d]%n",
                    index, originalNums.length - 1);
            return null;
        }

        float[] copyNums = originalNums.clone();
        float threshold = copyNums[index];

        for (int i = 0; i < copyNums.length; i++) {
            if (copyNums[i] > threshold) {
                copyNums[i] = 0.0f;
            }
        }

        return copyNums;
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    private static void displayNums(float[] nums, String msg) {
        System.out.println(msg + ":");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%.3f ", nums[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }
}