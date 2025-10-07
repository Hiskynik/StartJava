package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    private static final String ERROR_NULL_ARRAY = "Ошибка: передан null массив";
    private static final String ERROR_EMPTY_ARRAY = "Передан массив нулевой длины";
    private static final String ERROR_NEGATIVE = "Ошибка: факториал %d! не определен";
    private static final String ERROR_TOO_LARGE = "Ошибка: факториал %d! слишком велик (максимум 20!)";

    public static void main(String[] args) {
        System.out.println("=== ВЫЧИСЛЕНИЕ ФАКТОРИАЛОВ ===");
        System.out.println();

        testEmptyArray();
        testNullArray();
        testSingleNegativeNumber();
        testMixedNumbers();
        testAnotherMixedNumbers();
    }

    private static void testEmptyArray() {
        System.out.println("Тест 1: Пустой массив");
        int[] emptyArray = new int[0];
        String[] outputs = processFactorialArray(emptyArray);
        displayOutputs(outputs);
    }

    private static void testNullArray() {
        System.out.println("Тест 2: Null массив");
        String[] outputs = processFactorialArray((int[]) null);
        displayOutputs(outputs);
    }

    private static void testSingleNegativeNumber() {
        System.out.println("Тест 3: Отрицательное число");
        int[] singleNumber = {-5};
        String[] outputs = processFactorialArray(singleNumber);
        displayOutputs(outputs);
    }

    private static void testMixedNumbers() {
        System.out.println("Тест 4: Числа 21, 0, 7");
        int[] numbers = {21, 0, 7};
        String[] outputs = processFactorialArray(numbers);
        displayOutputs(outputs);
    }

    private static void testAnotherMixedNumbers() {
        System.out.println("Тест 5: Числа 1, 20, 5, -3");
        int[] numbers = {1, 20, 5, -3};
        String[] outputs = processFactorialArray(numbers);
        displayOutputs(outputs);
    }

    public static String[] processFactorialArray(int... numbers) {
        if (numbers == null) {
            return new String[]{ERROR_NULL_ARRAY};
        }

        if (numbers.length == 0) {
            return new String[]{ERROR_EMPTY_ARRAY};
        }

        String[] factorialOutputs = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            factorialOutputs[i] = calculateSingleFactorial(numbers[i]);
        }

        return factorialOutputs;
    }

    private static String calculateSingleFactorial(int number) {
        return number < 0 ? String.format(ERROR_NEGATIVE, number)
                : number > 20 ? String.format(ERROR_TOO_LARGE, number)
                : formatFactorialOutput(number);
    }

    private static String formatFactorialOutput(int n) {
        long factorialValue = computeFactorial(n);

        return n == 0 ? "0! = 1"
                : n == 1 ? "1! = 1"
                : n + "! = " + buildMultiplicationSequence(n) + " = " + factorialValue;
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

    private static long computeFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long factorialProduct = 1;
        for (int i = 2; i <= n; i++) {
            factorialProduct *= i;
        }
        return factorialProduct;
    }

    private static void displayOutputs(String[] outputs) {
        if (outputs == null) {
            System.out.println("Ошибка: выходные данные не могут быть null");
            return;
        }

        for (String output : outputs) {
            System.out.println("  " + output);
        }
        System.out.println();
    }
}