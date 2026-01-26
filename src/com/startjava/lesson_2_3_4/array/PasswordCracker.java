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

    private static final String CHECK_MARK = "✓";
    private static final String CROSS_MARK = "✗";

    private static final char[] SPINNER_CHARS = {'-', '\\', '|', '/'};

    public static void main(String[] args) {
        System.out.println("ГЕНЕРАТОР И ВЗЛОМЩИК ПАРОЛЕЙ\n");

        System.out.println("Пароль '123456':");
        testPassword("123456".toCharArray());

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nСгенерированный пароль " + i + ":");
            char[] password = generateRandomPassword();
            testPassword(password);
            clearPassword(password);
        }
    }

    public static void testPassword(char[] password) {
        boolean isWeak = analyzePassword(password);
        crackPassword(password, isWeak);
    }

    public static void showSpinner() {
        System.out.print("  Взлом пароля: ");

        int totalRotations = 3;
        int totalSpins = totalRotations * SPINNER_CHARS.length;

        try {
            for (int i = 0; i < totalSpins; i++) {
                System.out.print(SPINNER_CHARS[i % SPINNER_CHARS.length]);

                Thread.sleep(100);

                System.out.print("\b");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("  \r");
    }

    public static void crackPassword(char[] password, boolean isWeak) {
        if (password == null || password.length == 0) {
            System.out.println(RED + CROSS_MARK + " Password cracked: (пустой пароль)" + RESET);
            return;
        }

        showSpinner();

        String color;
        String message;

        if (isWeak) {
            color = GREEN;
            message = CHECK_MARK + " Password cracked: ";
        } else {
            color = RED;
            message = CROSS_MARK + " Strong password: ";
        }

        System.out.println(color + message + new String(password) + RESET);
    }

    public static boolean analyzePassword(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не может быть пустым" + RESET);
            return true;
        }

        boolean isWeak = false;

        if (isPasswordBlacklisted(password)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Не используйте пароли из списка популярных: https://nordpass.com/most-common-passwords-list" + RESET);
            isWeak = true;
        }

        if (password.length < 8) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль должен быть не менее 8 символов" + RESET);
            isWeak = true;
        }

        boolean hasLetters = false;
        boolean hasDigits = false;
        boolean hasSpecial = false;
        boolean hasLower = false;
        boolean hasUpper = false;

        for (char symbol : password) {
            if (Character.isLetter(symbol)) {
                hasLetters = true;
                if (Character.isLowerCase(symbol)) {
                    hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    hasUpper = true;
                }
            } else if (Character.isDigit(symbol)) {
                hasDigits = true;
            } else {
                hasSpecial = true;
            }
        }

        if (hasDigits && !hasLetters && !hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только цифры" + RESET);
            isWeak = true;
        }

        if (hasLetters && !hasDigits && !hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только буквы" + RESET);
            isWeak = true;
        }

        if (hasSpecial && !hasLetters && !hasDigits) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только спец. символы" + RESET);
            isWeak = true;
        }

        if (!hasSpecial && (hasLetters || hasDigits)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не содержит спец. символы" + RESET);
            isWeak = true;
        }

        if (hasLetters && (!hasLower || !hasUpper)) {
            System.out.println(YELLOW +
                    "  ПРЕДУПРЕЖДЕНИЕ: Пароль не содержит буквы нижнего и верхнего регистров" + RESET);
            isWeak = true;
        }

        return isWeak;
    }

    public static boolean isPasswordBlacklisted(char[] password) {
        if (password == null) return false;

        for (char[] blacklistedPassword : BLACKLIST) {
            if (Arrays.equals(password, blacklistedPassword)) {
                return true;
            }
        }

        return false;
    }

    public static char[] generateRandomPassword() {
        Random random = new Random();
        int passwordLength = random.nextInt(6, 13);

        char[] password = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            char symbol = (char) random.nextInt(33, 127);
            password[i] = symbol;
        }

        return password;
    }

    public static void clearPassword(char[] password) {
        if (password != null) {
            Arrays.fill(password, '\0');
        }
    }
}