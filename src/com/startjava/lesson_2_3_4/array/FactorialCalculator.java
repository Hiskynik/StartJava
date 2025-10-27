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
        FactorialData[] factorialData = calculateFactorials(emptyArray);
        displayFactorials(factorialData);
    }

    private static void testNullArray() {
        System.out.println("Тест 2: Null массив");
        FactorialData[] factorialData = calculateFactorials((int[]) null);
        displayFactorials(factorialData);
    }

    private static void testSingleNegativeNumber() {
        System.out.println("Тест 3: Отрицательное число");
        int[] singleNumber = {-5};
        FactorialData[] factorialData = calculateFactorials(singleNumber);
        displayFactorials(factorialData);
    }

    private static void testNumbers1() {
        System.out.println("Тест 4: Числа 21, 0, 7");
        int[] numbers = {21, 0, 7};
        FactorialData[] factorialData = calculateFactorials(numbers);
        displayFactorials(factorialData);
    }

    private static void testNumbers2() {
        System.out.println("Тест 5: Числа 1, 20, 5, -3");
        int[] numbers = {1, 20, 5, -3};
        FactorialData[] factorialData = calculateFactorials(numbers);
        displayFactorials(factorialData);
    }

    public static FactorialData[] calculateFactorials(int... numbers) {
        if (numbers == null) {
            System.out.println("  " + ERROR_NULL_ARRAY);
            return null;
        }

        if (numbers.length == 0) {
            System.out.println("  " + ERROR_EMPTY_ARRAY);
            return new FactorialData[0];
        }

        FactorialData[] factorialData = new FactorialData[numbers.length];
        boolean hasValidFactorial = false;

        for (int i = 0; i < numbers.length; i++) {
            factorialData[i] = calculateFactorial(numbers[i]);
            if (factorialData[i] != null && factorialData[i].valid()) {
                hasValidFactorial = true;
            }
        }
        return hasValidFactorial ? factorialData : null;
    }

    private static FactorialData calculateFactorial(int number) {
        if (number < 0) {
            System.out.println("  " + String.format(ERROR_NEGATIVE, number));
            return new FactorialData(number, -1, false);
        }

        if (number > 20) {
            System.out.println("  " + String.format(ERROR_TOO_LARGE, number));
            return new FactorialData(number, -1, false);
        }

        long factorialValue = computeFactorial(number);
        return new FactorialData(number, factorialValue, true);
    }

    // НЕ ИЗМЕНЯЛСЯ: Только вычисляет числовое значение факториала
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

    private static void displayFactorials(FactorialData[] factorialData) {
        if (factorialData == null) {
            return;
        }

        for (FactorialData data : factorialData) {
            if (data != null && data.valid()) {
                String expression = formatFactorial(data.number(), data.factorial());
                System.out.println("  " + expression);
            }
        }
        System.out.println();
    }

    private static String formatFactorial(int number, long factorial) {
        if (number == 0) return "0! = 1";
        if (number == 1) return "1! = 1";

        String multiplicationSequence = buildMultiplicationSequence(number);
        return number + "! = " + multiplicationSequence + " = " + factorial;
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

    record FactorialData(int number, long factorial, boolean valid) {
    }
}