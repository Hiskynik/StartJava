package com.startjava.lesson_2_3_4.array;

public class TrianglePrinter {
    public static void main(String[] args) {
        printTriangleSet1();
        printTriangleSet2();
        printTriangleSet3();
    }

    private static void printTriangleSet1() {
        System.out.println("Треугольник 1 (0, 9, true):");
        char[] sequence = generateSequence('0', '9', true);
        printTriangle(sequence);
    }

    private static void printTriangleSet2() {
        System.out.println("\nТреугольник 2 (/, !, false):");
        char[] sequence = generateSequence('/', '!', false);
        printTriangle(sequence);
    }

    private static void printTriangleSet3() {
        System.out.println("\nТреугольник 3 (A, J, false):");
        char[] sequence = generateSequence('A', 'J', false);
        printTriangle(sequence);
    }

    public static char[] generateSequence(char start, char end, boolean ascending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + (int) start + ") > правой (" + (int) end + ")");
            return new char[0];
        }

        int count = end - start + 1;
        char[] chars = new char[count];

        for (int i = 0; i < count; i++) {
            chars[i] = ascending ?
                    (char) (start + i) :
                    (char) (end - i);
        }

        return chars;
    }

    public static void printTriangle(char[] chars) {
        if (chars.length == 0) {
            return;
        }

        int count = chars.length;
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int symbolCount = 2 * i + 1;
            int spaces = count - i - 1;

            line.setLength(0);
            line.append(" ".repeat(spaces));
            line.append(String.valueOf(chars[i]).repeat(Math.max(0, symbolCount)));

            System.out.println(line);
        }
    }
}