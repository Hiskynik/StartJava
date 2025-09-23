package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionHistory {
    public static void displayTransactionHistory(int[] transactions) {
        System.out.print("Исходные транзакции: ");

        if (transactions == null) {
            System.out.println("null");
            System.out.println(" В обратном порядке: null");
            return;
        }

        if (transactions.length == 0) {
            System.out.println("[]");
            System.out.println(" В обратном порядке: []");
            return;
        }

        System.out.println(Arrays.toString(transactions));

        int[] reversed = new int[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            reversed[i] = transactions[transactions.length - 1 - i];
        }

        System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
    }

    public static void main(String[] args) {
        System.out.println("1. Массив нулевой длины:");
        displayTransactionHistory(new int[0]);
        System.out.println();

        System.out.println("2. null:");
        displayTransactionHistory(null);
        System.out.println();

        System.out.println("3. Один элемент [5]:");
        displayTransactionHistory(new int[]{5});
        System.out.println();

        System.out.println("4. Несколько элементов [6, 8, 9, 1]:");
        displayTransactionHistory(new int[]{6, 8, 9, 1});
        System.out.println();

        System.out.println("5. Много элементов [13, 8, 5, 3, 2, 1, 1]:");
        displayTransactionHistory(new int[]{13, 8, 5, 3, 2, 1, 1});
    }
}