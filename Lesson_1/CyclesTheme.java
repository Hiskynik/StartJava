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
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < dashes; j++) {
                System.out.print("-");
            }
            System.out.print(" ");

            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            
            System.out.print(" ");
            
            for (int j = 0; j < carets; j++) {
                System.out.print("^");
            }
            System.out.println();
            
            stars--;
            carets += 2;
        }

        System.out.println("\n3.ВЫВОД ТАБЛИЦЫ УМНОЖЕНИЯ\n");

        System.out.println("  |  2  3  4  5  6  7  8  9");
        System.out.println("--+------------------------");
        
        for (int i = 2; i <= 9; i++) {
            System.out.print(i + " |");
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }

        System.out.println("\n4.ВЫВОД ЧИСЕЛ В НЕСКОЛЬКО СТРОК\n");

        int start = 1;
        int end = 24;
        int numbersPerLine = 5;
        int oddCount = 0;
        for (int i = start; i < end; i++) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }

        int numbersInCurrentLine = 0;
        for (int i = start; i < end; i++) {
            if (i % 2 != 0) {
                System.out.printf("%2d ", i);
                numbersInCurrentLine++;
                
                if (numbersInCurrentLine == numbersPerLine) {
                    System.out.println();
                    numbersInCurrentLine = 0;
                }
            }
        }

        if (numbersInCurrentLine > 0) {
            for (int i = numbersInCurrentLine; i < numbersPerLine; i++) {
                System.out.printf("%2d ", 0);
            }
            System.out.println();
        }
        System.out.println("\n5.ВЫВОД ЧИСЕЛ МЕЖДУ MIN И MAX\n");

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
        System.out.println("\n6.РАЗНЫЕ ОПЕРАЦИИ НАД ЧИСЛОМ\n");

        int number = 2234321;
        int originalNumber = number;
        
        int reversedNumber = 0;
        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }
        
        boolean isPalindrome = originalNumber == reversedNumber;
        
        number = originalNumber;
        int countOfTwos = 0;
        while (number != 0) {
            int digit = number % 10;
            if (digit == 2) {
                countOfTwos++;
            }
            number = number / 10;
        }
        
        String evenOrOdd = (countOfTwos % 2 == 0) ? "четным" : "нечетным";
        
        System.out.println(reversedNumber + " - " + 
                (isPalindrome ? "" : "не ") + "палиндром с " + 
                evenOrOdd + " (" + countOfTwos + ") количеством двоек");

        System.out.println("\n7.ПРОВЕРКА СЧАСТЛИВОГО ЧИСЛА\n");

        int number1 = 101002;
        String numStr = String.format("%06d", number1);

        int sumFirst = 0;
        int sumSecond = 0;

        for (int i = 0; i < 3; i++) {
            sumFirst += Character.getNumericValue(numStr.charAt(i));
        }

        for (int i = 3; i < 6; i++) {
            sumSecond += Character.getNumericValue(numStr.charAt(i));
        }

        if (sumFirst == sumSecond) {
            System.out.printf("%d - счастливое число%n", number1);
        } else {
            System.out.printf("%d - несчастливое число%n", number1);
        }

        System.out.printf("Сумма цифр %03d = %d%n", 
                Integer.parseInt(numStr.substring(3)), sumSecond);
        System.out.printf("Сумма цифр %03d = %d%n",
                Integer.parseInt(numStr.substring(0, 3)), sumFirst);

        System.out.println("\n8.ГЕНЕРАТОР ПАРОЛЯ\n");

        String password = generatePassword();
        String strength = checkPasswordStrength(password);
        
        System.out.println("Пароль: " + password);
        System.out.println("Надежность: " + strength);
    }

    public static String generatePassword() {
        Random random = new Random();
        String password = "";

        for (int i = 0; i < 8; i++) {
            int choice = random.nextInt(4);

            if (choice == 0) {
                char digit = (char) random.nextInt(48, 58);
                password += digit;
            } else if (choice == 1) {
                char upper = (char) random.nextInt(65, 91);
                password += upper;
            } else if (choice == 2) {
                char lower = (char) random.nextInt(97, 123);
                password += lower;
            } else {
                int rangeChoice = random.nextInt(4);
                int start;
                int end;
                switch (rangeChoice) {
                    case 0:
                        start = 33;
                        end = 48;
                        break;
                    case 1:
                        start = 58;
                        end = 65;
                        break;
                    case 2:
                        start = 91;
                        end = 97;
                        break;
                    default:
                        start = 123;
                        end = 127;
                        break;
                }
                
                char special = (char) random.nextInt(start, end);
                password += special;
            }
        }

        return password;
    }

    public static String checkPasswordStrength(String password) {
        if (password == null || password.isEmpty()) {
            return "Слабый";
        }
    
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
        
            if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else { 
                hasSpecial = true;
            }
        }

        if (password.length() >= 8 && hasLower && hasUpper && hasDigit && hasSpecial) {
            return "Надежный";
        } else if (password.length() >= 8 && (hasLower || hasUpper) && hasDigit) {
            return "Средний";
        } else {
            return "Слабый";
        }
    }
}