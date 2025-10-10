package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

class TransactionReverser {
    public static void main(String[] args) {
        run(new int[0]);

        run(null);

        run(new int[]{5});

        run(new int[]{6, 8, 9, 1});

        run(new int[]{13, 8, 5, 3, 2, 1, 1});
    }

    private static void run(int[] original) {
        int[] reversed = reverse(original);
        displayTransactions(original, reversed);
        System.out.println();
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return transactions;
        }

        int[] reversed = new int[transactions.length];
        int i = 0;
        for (int transaction : transactions) {
            reversed[transactions.length - 1 - i] = transaction;
            i++;
        }

        return reversed;
    }

    private static void displayTransactions(int[] original, int[] reversed) {
        System.out.println("Исходные транзакции: " + Arrays.toString(original));
        System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
    }
}