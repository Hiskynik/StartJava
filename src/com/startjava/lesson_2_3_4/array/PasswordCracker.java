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
    private static final String BLUE = "\033[34m";
    private static final String CYAN = "\033[36m";

    private static final String CHECK_MARK = "✓";
    private static final String CROSS_MARK = "✗";

    private static final char[] SPINNER_CHARS = {'-', '\\', '|', '/'};

    public static void main(String[] args) {
        System.out.println("\n" + BLUE + "8.ГЕНЕРАТОР И ВЗЛОМЩИК ПАРОЛЕЙ" + RESET + "\n");

        System.out.println(CYAN + "БЛЕКЛИСТ ЗАПРЕЩЕННЫХ ПАРОЛЕЙ" + RESET);
        for (int i = 0; i < BLACKLIST.length; i++) {
            System.out.println((i + 1) + ". " + new String(BLACKLIST[i]));
        }
        System.out.println(CYAN + "\n" + RESET);

        System.out.println(YELLOW + "ТЕСТОВЫЕ ПАРОЛИ ДЛЯ ПРОВЕРОК" + RESET);

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
            System.out.println("\n" + BLUE + "--- Тест " + (i + 1) + ": '" +
                    testPasswords[i] + "' ---" + RESET);
            crackPassword(testPasswords[i].toCharArray());
        }

        System.out.println("\n" + YELLOW + "ГЕНЕРАЦИЯ И ВЗЛОМ СЛУЧАЙНЫХ ПАРОЛЕЙ" + RESET);
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n" + BLUE + "Сгенерированный пароль " + i + " " + RESET);
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

                Thread.sleep(1000);

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
            System.out.println(RED + "  Причина: Пароль не может быть пустым" + RESET);
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
            return true;
        }

        if (hasLetters && !hasDigits && !hasSpecial) {
            return true;
        }

        if (hasSpecial && !hasLetters && !hasDigits) {
            return true;
        }

        if (!hasSpecial && (hasLetters || hasDigits)) {
            return true;
        }

        return hasLetters && (!hasLower || !hasUpper);
    }

    public static void checkPasswordWeakness(char[] password) {
        if (password == null || password.length == 0) {
            System.out.println(RED + "  ОШИБКА: Пароль не может быть пустым" + RESET);
            return;
        }

        if (isPasswordBlacklisted(password)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Не используйте пароли из списка популярных: https://nordpass.com/most-common-passwords-list" + RESET);
        }

        if (password.length < 8) {
            System.out.println(RED + "  ОШИБКА: Пароль должен быть не менее 8 символов" + RESET);
        }

        boolean hasLetters = false;
        boolean hasDigits = false;
        boolean hasSpecial = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasLettersOnly = true;
        boolean hasSpecialOnly = true;

        for (char symbol : password) {
            if (Character.isLetter(symbol)) {
                hasLetters = true;
                hasSpecialOnly = false;

                if (Character.isLowerCase(symbol)) {
                    hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    hasUpper = true;
                }
            } else if (Character.isDigit(symbol)) {
                hasDigits = true;
                hasLettersOnly = false;
                hasSpecialOnly = false;
            } else {
                hasSpecial = true;
                hasLettersOnly = false;
            }
        }

        if (hasDigits && !hasLetters && !hasSpecial) {
            System.out.println(RED + "  ОШИБКА: Пароль содержит только цифры" + RESET);
        }

        if (hasLettersOnly && !hasDigits && !hasSpecial) {
            System.out.println(RED + "  ОШИБКА: Пароль содержит только буквы" + RESET);
        }

        if (hasSpecialOnly && !hasLetters && !hasDigits) {
            System.out.println(RED + "  ОШИБКА: Пароль содержит только спец. символы" + RESET);
        }

        if (!hasSpecial && (hasLetters || hasDigits)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: Пароль не содержит спец. символы" + RESET);
        }

        if (hasLetters && (!hasLower || !hasUpper)) {
            System.out.println(YELLOW + "  ПРЕДУПРЕЖДЕНИЕ: " +
                    "Пароль не содержит буквы нижнего и верхнего регистров" + RESET);
        }
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

        boolean hasLower;
        boolean hasUpper;
        boolean hasDigit;
        boolean hasSpecial;

        int attempts = 0;
        final int MaxAttempts = 100;

        do {
            hasLower = false;
            hasUpper = false;
            hasDigit = false;
            hasSpecial = false;

            for (int i = 0; i < passwordLength; i++) {
                char symbol = (char) random.nextInt(33, 127);
                password[i] = symbol;

                if (Character.isLowerCase(symbol)) {
                    hasLower = true;
                } else if (Character.isUpperCase(symbol)) {
                    hasUpper = true;
                } else if (Character.isDigit(symbol)) {
                    hasDigit = true;
                } else {
                    hasSpecial = true;
                }
            }
            attempts++;
        } while ((!hasLower || !hasUpper || !hasDigit || !hasSpecial ||
                isPasswordBlacklisted(password)) && attempts < MaxAttempts);

        return password;
    }

    public static void analyzePassword(char[] password) {
        if (password == null || password.length == 0) {
            return;
        }

        checkPasswordWeakness(password);

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char symbol : password) {
            if (Character.isLowerCase(symbol)) {
                hasLower = true;
            } else if (Character.isUpperCase(symbol)) {
                hasUpper = true;
            } else if (Character.isDigit(symbol)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        String strength;
        if (password.length >= 8 && hasLower && hasUpper && hasDigit && hasSpecial) {
            strength = "Надежный";
        } else if (password.length >= 8 && (hasLower || hasUpper) && hasDigit) {
            strength = "Средний";
        } else {
            strength = "Слабый";
        }

        System.out.println("  Длина пароля: " + password.length + " символов");
        System.out.println("  Содержит строчные буквы: " + (hasLower ? CHECK_MARK : CROSS_MARK));
        System.out.println("  Содержит заглавные буквы: " + (hasUpper ? CHECK_MARK : CROSS_MARK));
        System.out.println("  Содержит цифры: " + (hasDigit ? CHECK_MARK : CROSS_MARK));
        System.out.println("  Содержит спецсимволы: " + (hasSpecial ? CHECK_MARK : CROSS_MARK));
        System.out.println("  Надежность: " + strength);
    }

    public static void clearPassword(char[] password) {
        if (password != null) {
            Arrays.fill(password, '\0');
        }
    }
}