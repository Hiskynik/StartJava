package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[] emptyList = new int[0];
        int[] reversedEmpty = reverseTransactions(emptyList);
        displayResult(emptyList, reversedEmpty);
        System.out.println();

        int[] dataError = null;
        int[] reversedNull = null;
        displayResult(dataError, reversedNull);
        System.out.println();

        int[] singleElement = new int[]{5};
        int[] reversedSingle = reverseTransactions(singleElement);
        displayResult(singleElement, reversedSingle);
        System.out.println();

        int[] multipleElements = new int[]{6, 8, 9, 1};
        int[] reversedMultiple = reverseTransactions(multipleElements);
        displayResult(multipleElements, reversedMultiple);
        System.out.println();

        int[] manyElements = new int[]{13, 8, 5, 3, 2, 1, 1};
        int[] reversedMany = reverseTransactions(manyElements);
        displayResult(manyElements, reversedMany);
    }

    public static int[] reverseTransactions(int[] transactions) {
        if (transactions == null) {
            return null;
        }

        if (transactions.length == 0) {
            return new int[0];
        }

        int[] reversed = new int[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            reversed[i] = transactions[transactions.length - 1 - i];
        }
        return reversed;
    }

    public static void displayResult(int[] original, int[] reversed) {
        System.out.print("Исходные транзакции: ");

        if (original == null) {
            System.out.println("null");
        } else if (original.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(original));
        }

        System.out.print(" В обратном порядке: ");

        if (reversed == null) {
            System.out.println("null");
        } else if (reversed.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(reversed));
        }
    }
}