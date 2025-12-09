package com.startjava.lesson_2_3_4.array;

import java.util.Random;

public class ValueThresholdFilter {
    private static final int CAPACITY = 15;

    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            System.out.println();

            float[] randomNums = generateRandomNums();

            float[] originalNums = randomNums.clone();

            float threshold = filterAboveIndexValue(randomNums, index);

            if (threshold < 0) {
                continue;
            }

            displayNums(originalNums, "Исходный массив");
            System.out.printf("Пороговое значение из ячейки [%d]: %.3f%n", index, threshold);
            displayNums(randomNums, "Измененный массив");
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

    private static float filterAboveIndexValue(float[] nums, int index) {
        if (!isValidIndex(index, nums.length)) {
            System.out.printf("Ошибка: индекс %d недопустим. Допустимый диапазон: [0, %d]%n",
                    index, nums.length - 1);
            return -1;
        }

        float threshold = nums[index];
        setNumsAboveThresholdToZero(nums, threshold);
        return threshold;
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    private static void displayNums(float[] nums, String label) {
        System.out.println(label + ":");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%.3f ", nums[i]);
            if (i == 7) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void setNumsAboveThresholdToZero(float[] nums, float threshold) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                nums[i] = 0.0f;
            }
        }
    }
}