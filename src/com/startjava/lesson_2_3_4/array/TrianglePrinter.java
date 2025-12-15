package com.startjava.lesson_2_3_4.array;

public class TrianglePrinter {
    public static void main(String[] args) {
        System.out.println("Треугольник 1 (0, 9, true):");
        printTriangle('0', '9', true);

        System.out.println("\nТреугольник 2 (/, !, false):");
        printTriangle('/', '!', false);

        System.out.println("\nТреугольник 3 (A, J, false):");
        printTriangle('A', 'J', false);
    }

    public static void printTriangle(char start, char end, boolean ascending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + (int) start + ") > правой (" + (int) end + ")");
            return;
        }

        int count = end - start + 1;

        char[] chars = new char[count];
        if (ascending) {
            for (int i = 0; i < count; i++) {
                chars[i] = (char) (start + i);
            }
        } else {
            for (int i = 0; i < count; i++) {
                chars[i] = (char) (end - i);
            }
        }

        for (int i = 0; i < count; i++) {
            int symbolCount = 2 * i + 1;
            int spaces = count - i - 1;

            StringBuilder line = new StringBuilder();
            line.append(" ".repeat(spaces));
            line.append(String.valueOf(chars[i]).repeat(symbolCount));

            System.out.println(line);
        }
    }
}