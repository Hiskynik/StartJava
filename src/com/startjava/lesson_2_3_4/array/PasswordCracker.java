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
        System.out.println("""
                ГЕНЕРАТОР И ВЗЛОМЩИК ПАРОЛЕЙ
                """);

        String[] testPasswords = {
                "123456",
                "",
                "abc",
                "12345678",
                "Password",
                "!@#$%^&*",
                "Passw0rd",
                "password123",
                "MyP@ssw0rd!"
        };

        for (int i = 0; i < testPasswords.length; i++) {
            System.out.println("Тест " + (i + 1) + ": '" + testPasswords[i] + "'");
            crackPassword(testPasswords[i].toCharArray());
            System.out.println();
        }

        System.out.println("ГЕНЕРАЦИЯ И ВЗЛОМ СЛУЧАЙНЫХ ПАРОЛЕЙ");
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nСгенерированный пароль " + i);
            char[] generatedPassword = generateRandomPassword();
            crackPassword(generatedPassword);
            clearPassword(generatedPassword);
        }
    }

    public static void showSpinner() {
        System.out.print("  Взлом пароля: ");
        System.out.flush();

        int totalRotations = 3;
        int totalSpins = totalRotations * SPINNER_CHARS.length;

        try {
            for (int i = 0; i < totalSpins; i++) {
                System.out.print(SPINNER_CHARS[i % SPINNER_CHARS.length]);
                System.out.flush();

                Thread.sleep(100);

                System.out.print("\b");
                System.out.flush();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("  \r");
    }

    public static void crackPassword(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println(RED + CROSS_MARK + " Password cracked: (пустой пароль)" + RESET);
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не может быть пустым" + RESET);
            return;
        }

        showSpinner();

        boolean isWeak = isPasswordWeak(password);

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

        analyzePassword(password);
    }

    public static boolean isPasswordWeak(char[] password) {
        if (password == null || password.length == 0) {
            return true;
        }

        if (isPasswordBlacklisted(password)) {
            return true;
        }

        if (password.length < 8) {
            return true;
        }

        PasswordAnalysis analysis = analyzePasswordCharacteristics(password);

        if (analysis.hasDigits && !analysis.hasLetters && !analysis.hasSpecial) {
            return true;
        }

        if (analysis.hasLetters && !analysis.hasDigits && !analysis.hasSpecial) {
            return true;
        }

        if (analysis.hasSpecial && !analysis.hasLetters && !analysis.hasDigits) {
            return true;
        }

        if (!analysis.hasSpecial && (analysis.hasLetters || analysis.hasDigits)) {
            return true;
        }

        return analysis.hasLetters && (!analysis.hasLower || !analysis.hasUpper);
    }

    public static void analyzePassword(char[] password) {
        if (password == null || password.length == 0) {
            return;
        }

        checkPasswordWeakness(password);
    }

    public static void checkPasswordWeakness(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не может быть пустым" + RESET);
            return;
        }

        if (isPasswordBlacklisted(password)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Не используйте пароли из списка популярных: https://nordpass.com/most-common-passwords-list" + RESET);
        }

        if (password.length < 8) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль должен быть не менее 8 символов" + RESET);
        }

        PasswordAnalysis analysis = analyzePasswordCharacteristics(password);

        if (analysis.hasDigits && !analysis.hasLetters && !analysis.hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только цифры" + RESET);
        }

        if (analysis.hasLetters && !analysis.hasDigits && !analysis.hasSpecial) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только буквы" + RESET);
        }

        if (analysis.hasSpecial && !analysis.hasLetters && !analysis.hasDigits) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль содержит только спец. символы" + RESET);
        }

        if (!analysis.hasSpecial && (analysis.hasLetters || analysis.hasDigits)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не содержит спец. символы" + RESET);
        }

        if (analysis.hasLetters && (!analysis.hasLower || !analysis.hasUpper)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: " +
                    "Пароль не содержит буквы нижнего и верхнего регистров" + RESET);
        }
    }

    private static PasswordAnalysis analyzePasswordCharacteristics(char[] password) {
        PasswordAnalysis analysis = new PasswordAnalysis();

        for (char symbol : password) {
            if (Character.isLetter(symbol)) {
                analysis.hasLetters = true;
                if (Character.isLowerCase(symbol)) {
                    analysis.hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    analysis.hasUpper = true;
                }
            } else if (Character.isDigit(symbol)) {
                analysis.hasDigits = true;
            } else {
                analysis.hasSpecial = true;
            }
        }

        return analysis;
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
        int passwordLength = random.nextInt(5) + 8;

        char[] password = new char[passwordLength];

        PasswordAnalysis analysis;
        int attempts = 0;
        final int MaxAttempts = 100;

        do {
            analysis = new PasswordAnalysis();

            for (int i = 0; i < passwordLength; i++) {
                char symbol = (char) random.nextInt(33, 127);
                password[i] = symbol;

                if (Character.isLowerCase(symbol)) {
                    analysis.hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    analysis.hasUpper = true;
                } else if (Character.isDigit(symbol)) {
                    analysis.hasDigits = true;
                } else {
                    analysis.hasSpecial = true;
                }
            }
            attempts++;
        } while ((!analysis.hasLower || !analysis.hasUpper || !analysis.hasDigits || !analysis.hasSpecial ||
                isPasswordBlacklisted(password)) && attempts < MaxAttempts);

        return password;
    }

    public static void clearPassword(char[] password) {
        if (password != null) {
            Arrays.fill(password, '\0');
        }
    }

    private static class PasswordAnalysis {
        boolean hasLetters = false;
        boolean hasDigits = false;
        boolean hasSpecial = false;
        boolean hasLower = false;
        boolean hasUpper = false;
    }
}