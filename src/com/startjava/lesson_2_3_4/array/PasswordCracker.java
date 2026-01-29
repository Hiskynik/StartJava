package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;
import java.util.Random;

public class PasswordCracker {
    private static final char[][] BLACKLIST = {
            {'a', 'd', 'm', 'i', 'n'},
            {'q', 'w', 'e', 'r', 't', 'y'},
            {'1', '2', '3', '4', '5', '6'}
    };

    private static final String RESET = "\033[0m";
    private static final String RED = "\033[31m";
    private static final String GREEN = "\033[32m";
    private static final String YELLOW = "\033[33m";
    private static final String URL = "https://nordpass.com/most-common-passwords-list";

    private static final String CHECK_MARK = "✓ Password cracked: ";
    private static final String CROSS_MARK = "✗ Strong password: ";

    private static final char[] SPINS = {'-', '\\', '|', '/'};

    public static void main(String[] args) {
        char[][] passwords = new char[4][];
        passwords[0] = "123456".toCharArray();

        for (int i = 1; i < passwords.length; i++) {
            passwords[i] = generateRandomPassword();
        }

        for (char[] password : passwords) {
            crackPassword(password, analyzePassword(password));
            System.out.println();
        }
    }

    private static char[] generateRandomPassword() {
        Random random = new Random();
        int passwordLength = random.nextInt(6, 13);
        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            char symbol = (char) random.nextInt(33, 127);
            password[i] = symbol;
        }

        return password;
    }

    private static boolean analyzePassword(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не может быть пустым" + RESET);
            return true;
        }

        if (isPasswordBlacklisted(password)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Не используйте пароли из списка:" + URL + RESET);
            return true;
        }

        if (password.length < 8) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль должен быть не менее 8 символов" + RESET);
            return true;
        }

        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean hasLower = false;
        boolean hasUpper = false;

        for (char symbol : password) {
            if (Character.isLetter(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    hasUpper = true;
                }
            } else if (Character.isDigit(symbol)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        boolean hasLetter = hasLower || hasUpper;

        if (hasDigit && !hasLetter && !hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только цифры" + RESET);
            return true;
        }

        if (hasLetter && !hasDigit && !hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только буквы" + RESET);
            return true;
        }

        if (hasSpecial && !hasLetter && !hasDigit) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только спец. символы" + RESET);
            return true;
        }

        if (!hasSpecial && (hasLetter || hasDigit)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не содержит спец. символы" + RESET);
            return true;
        }

        if (hasLetter && (!hasLower || !hasUpper)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: " +
                    "Пароль не содержит буквы нижнего и верхнего регистров" + RESET);
            return true;
        }

        return false;
    }

    private static boolean isPasswordBlacklisted(char[] password) {
        if (password == null) return false;

        for (char[] blacklistedPassword : BLACKLIST) {
            if (Arrays.equals(password, blacklistedPassword)) {
                return true;
            }
        }

        return false;
    }

    private static void showSpinner() {
        System.out.print("  Взлом пароля: ");

        int totalRotations = 3;
        int totalSpins = totalRotations * SPINS.length;

        try {
            for (int i = 0; i < totalSpins; i++) {
                System.out.print(SPINS[i % SPINS.length]);

                Thread.sleep(100);

                System.out.print("\b");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("  \r");
    }

    private static void crackPassword(char[] password, boolean weak) {
        if (password == null || password.length == 0) {
            System.out.println(RED + CROSS_MARK + "(пустой пароль)" + RESET);
            return;
        }

        showSpinner();
        System.out.println((weak ? GREEN + CHECK_MARK : RED + CROSS_MARK) + new String(password) + RESET);
    }
}