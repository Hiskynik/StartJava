package com.startjava.lesson_1.base;

import java.util.Random;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1.ВЫВОД ASCII-СИМВОЛОВ\n");

        System.out.printf("%-8s   %-10s   %s%n", "DECIMAL", "CHARACTER", "DESCRIPTION");
        
        for (int i = 33; i <= 47; i += 2) {
            char c = (char) i;
            System.out.printf("%3d          %-10c    %s%n", i, c, Character.getName(c));
        }
        for (int i = 98; i <= 122; i += 2) {
            char c = (char) i;
            System.out.printf("%3d          %-10c    %s%n", i, c, Character.getName(c));
        }

        System.out.println("\n2.ВЫВОД ГЕОМЕТРИЧЕСКИХ ФИГУР\n");

        int stars = 5;
        int dashes = 10;
        int carets = 1;

        String dashesLine = "-".repeat(dashes);
        for (int i = 0; i < 5; i++) {
            System.out.print(dashesLine + " ");

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            stars--;
            System.out.print(" ");

            for (int j = 0; j < carets; j++) {
                System.out.print("^");
            }
            carets += 2;
            System.out.println();
        }

        System.out.println("\n4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК\n");

        int count = 0;
        for (int i = 1; i < 24; i += 2) {
            System.out.printf("%2d ", i);
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        while (count % 5 != 0) {
            System.out.printf("%2d ", 0);
            count++;
        }

        System.out.println("\n\n5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX \n");

        int a = 3;
        int b = 5;
        int c = -1;
        
        int min = a;
        int max = a;
        
        if (b < min) min = b;
        if (c < min) min = c;
        
        if (b > max) max = b;
        if (c > max) max = c;
        
        System.out.print("Числа между " + min + " и " + max + " в порядке убывания: ");
        
        for (int i = max - 1; i > min; i--) {
            System.out.print(i);
            if (i != min + 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n\n6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ \n");

        int original = 2234321;
        int currNumber = original;
        int reversedNumber = 0;
        int countOfTwos = 0;

        while (original > 0) {
            int digit = original % 10;
            reversedNumber = reversedNumber * 10 + digit;
            if (digit == 2) {
                countOfTwos++;
            }
            original /= 10;
        }
        boolean isPalindrome = currNumber == reversedNumber;

        String evenOrOdd = (countOfTwos % 2 == 0) ? "четным" : "нечетным";
        
        System.out.println(reversedNumber + " - " + 
                (isPalindrome ? "" : "не ") + "палиндром с " + 
                evenOrOdd + " (" + countOfTwos + ") количеством двоек");

        System.out.println("\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА\n");

        int originalNumber = 101002;
        currNumber = originalNumber;
        int sumFirst = 0;
        int sumSecond = 0;

        for (int i = 0; i < 6; i++) {
            int digit = currNumber % 10;
            if (i < 3) {
                sumSecond += digit;
            } else {
                sumFirst += digit;
            }
            currNumber /= 10;
        }

        if (sumFirst == sumSecond) {
            System.out.printf("%d - счастливое число%n", originalNumber);
        } else {
            System.out.printf("%d - несчастливое число%n", originalNumber);
        }

        System.out.printf("Сумма первых трех цифр = %d%n", sumFirst);
        System.out.printf("Сумма последних трех цифр = %d%n", sumSecond);

        System.out.println("\n8.ГЕНЕРАТОР ПАРОЛЯ\n");
        String password = "";
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            char symbol = (char) random.nextInt(33, 127);
            password += symbol;
            
            if (Character.isLowerCase(symbol)) {
                hasLower = true;
            } else if (Character.isUpperCase(symbol)) {
                hasUpper = true;
            } else if (Character.isDigit(symbol)) {
                hasDigit = true;
            } else hasSpecial = true;
        }

        String strength;
        if (hasLower && hasUpper && hasDigit && hasSpecial) {
            strength = "Надежный";
        } else if ((hasLower || hasUpper) && hasDigit) {
            strength = "Средний";
        } else {
            strength = "Слабый";
        }

        System.out.println("Пароль: " + password);
        System.out.println("Надежность: " + strength);
    }
}