package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

class TransactionReverser {
    public static void main(String[] args) {
        processAndDisplay(new int[0]);
        System.out.println();

        processAndDisplay(null);
        System.out.println();

        processAndDisplay(new int[]{5});
        System.out.println();

        processAndDisplay(new int[]{6, 8, 9, 1});
        System.out.println();

        processAndDisplay(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void processAndDisplay(int[] original) {
        int[] reversed = reverse(original);
        displayTransactions(original, reversed);
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return transactions; // Просто возвращаем как есть
        }

        int[] reversed = new int[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            reversed[i] = transactions[transactions.length - 1 - i];
        }

        return reversed;
    }

    public static void displayTransactions(int[] original, int[] reversed) {
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
    }
}