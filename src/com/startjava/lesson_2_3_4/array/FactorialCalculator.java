package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    private static final String ERROR_NULL_ARRAY = "Ошибка: передан null массив";
    private static final String ERROR_EMPTY_ARRAY = "Передан массив нулевой длины";
    private static final String ERROR_NEGATIVE = "Ошибка: факториал %d! не определен";
    private static final String ERROR_TOO_LARGE = "Ошибка: факториал %d! слишком велик (максимум 20!)";

    public static void main(String[] args) {
        System.out.println("=== ВЫЧИСЛЕНИЕ ФАКТОРИАЛОВ ===\n");

        testEmptyArray();
        testNullArray();
        testSingleNegativeNumber();
        testNumbers1();
        testNumbers2();
    }

    private static void testEmptyArray() {
        System.out.println("Тест 1: Пустой массив");
        int[] emptyArray = new int[0];
        String[] outputs = calculateFactorials(emptyArray);
        display(outputs);
    }

    private static void testNullArray() {
        System.out.println("Тест 2: Null массив");
        String[] outputs = calculateFactorials((int[]) null);
        display(outputs);
    }

    private static void testSingleNegativeNumber() {
        System.out.println("Тест 3: Отрицательное число");
        int[] singleNumber = {-5};
        String[] outputs = calculateFactorials(singleNumber);
        display(outputs);
    }

    private static void testNumbers1() {
        System.out.println("Тест 4: Числа 21, 0, 7");
        int[] numbers = {21, 0, 7};
        String[] outputs = calculateFactorials(numbers);
        display(outputs);
    }

    private static void testNumbers2() {
        System.out.println("Тест 5: Числа 1, 20, 5, -3");
        int[] numbers = {1, 20, 5, -3};
        String[] outputs = calculateFactorials(numbers);
        display(outputs);
    }

    public static String[] calculateFactorials(int... numbers) {
        if (numbers == null) {
            System.out.println("  " + ERROR_NULL_ARRAY);
            return null;
        }

        if (numbers.length == 0) {
            System.out.println("  " + ERROR_EMPTY_ARRAY);
            return new String[0];
        }

        String[] results = new String[numbers.length];
        boolean hasValidFactorial = false;

        for (int i = 0; i < numbers.length; i++) {
            results[i] = calculateFactorials(numbers[i]);
            if (results[i] != null) {
                hasValidFactorial = true;
            }
        }
        return hasValidFactorial ? results : null;
    }

    private static String calculateFactorials(int number) {
        if (number < 0) {
            System.out.println("  " + String.format(ERROR_NEGATIVE, number));
            return null;
        }

        if (number > 20) {
            System.out.println("  " + String.format(ERROR_TOO_LARGE, number));
            return null;
        }

        return formatFactorial(number, computeFactorial(number));
    }

    private static long computeFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static String formatFactorial(int number, long factorial) {
        if (number == 0) return "0! = 1";
        if (number == 1) return "1! = 1";

        return number + "! = " + buildMultiplicationSequence(number) + " = " + factorial;
    }

    private static String buildMultiplicationSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                sequence.append(" * ");
            }
            sequence.append(i);
        }
        return sequence.toString();
    }

    private static void display(String[] outputs) {
        if (outputs == null) {
            return;
        }

        for (String output : outputs) {
            if (output != null) {
                System.out.println("  " + output);
            }
        }
        System.out.println();
    }
}