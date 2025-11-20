package com.startjava.lesson_2_3_4.array;

public class FactorialCalculator {
    private static final int MAX_FACTORIAL = 20;

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
        long[] factorials = calculateFactorials(emptyArray);
        displayFactorials(emptyArray, factorials);
    }

    private static void testNullArray() {
        System.out.println("Тест 2: Null массив");
        long[] factorials = calculateFactorials((int[]) null);
        displayFactorials(null, factorials);
    }

    private static void testSingleNegativeNumber() {
        System.out.println("Тест 3: Отрицательное число");
        int[] singleNumber = {-5};
        long[] factorials = calculateFactorials(singleNumber);
        displayFactorials(singleNumber, factorials);
    }

    private static void testNumbers1() {
        System.out.println("Тест 4: Числа 21, 0, 7");
        int[] numbers = {21, 0, 7};
        long[] factorials = calculateFactorials(numbers);
        displayFactorials(numbers, factorials);
    }

    private static void testNumbers2() {
        System.out.println("Тест 5: Числа 1, 20, 5, -3");
        int[] numbers = {1, 20, 5, -3};
        long[] factorials = calculateFactorials(numbers);
        displayFactorials(numbers, factorials);
    }

    public static long[] calculateFactorials(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            return new long[0];
        }

        long[] factorials = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > MAX_FACTORIAL) {
                factorials[i] = -1;
                continue;
            }

            long result = 1;
            for (int j = 2; j <= numbers[i]; j++) {
                result *= j;
            }
            factorials[i] = result;
        }
        return factorials;
    }

    private static void displayFactorials(int[] numbers, long[] factorials) {
        if (numbers == null || factorials == null) {
            System.out.println("  Нет данных для отображения\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (factorials[i] == -1) {
                System.out.println("  " + numbers[i] + "! = не вычисляется (недопустимое значение)");
            } else {
                StringBuilder expression = new StringBuilder();
                expression.append(numbers[i]).append("! = ");

                if (numbers[i] == 0 || numbers[i] == 1) {
                    expression.append("1");
                } else {
                    for (int j = 1; j <= numbers[i]; j++) {
                        if (j > 1) {
                            expression.append(" * ");
                        }
                        expression.append(j);
                    }
                    expression.append(" = ").append(factorials[i]);
                }
                System.out.println("  " + expression);
            }
        }
        System.out.println();
    }
}