package com.startjava.lesson_1.base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n1.ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA\n");

        boolean isMale = true;
        if (!isMale) {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        int age = 18;
        if (age > 18) {
            System.out.println("Контент доступен для пользователей, " +
                    "достигших возраста " + age + " лет");
        } else {
            System.out.println("Контент недоступен");
        }

        float height = 1.8f;
        if (height < 1.8) {
            System.out.println("Неподходящий рост для данного аттракциона");
        } else {
            System.out.println("Добро пожаловать на аттракцион");
        }

        System.out.println("\n2.ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ\n");

        int stepsYesterday = 7252;
        int stepsToday = 10200;

        System.out.printf("""
                Количество шагов за вчера и сегодня:
                Вчера: %d
                Сегодня: %d
                """, stepsYesterday, stepsToday);
        if (stepsYesterday > stepsToday) {
            System.out.println("Вчера было больше шагов");
        } else if (stepsYesterday < stepsToday) {
            System.out.println("Вчера было меньше шагов");
        } else {
            System.out.println("Равное количество шагов");
        }
        double averageSteps = (stepsYesterday + stepsToday) / 2;
        System.out.println("Среднее значение шагов: " + averageSteps);

        System.out.println("\n3.ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ\n");
        
        int guestCount = -10;
        if (guestCount < 0) {
            System.out.println("Количество гостей не может быть отрицательным!");
        } else if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount % 2 == 1) {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания. %n", guestCount);
        } else {
            System.out.printf("Записалось %d гостей. " +
                    "Можно формировать пары для конкурсов. %n", guestCount);
        }

        System.out.println("\n4.ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА\n");

        String nickname = "777Striker777";
        char firstChar = nickname.charAt(0);
        System.out.printf("Имя %s начинается с ", nickname);
        if (firstChar >= 'a' && firstChar <= 'z') {
            System.out.printf("маленькой буквы '%c'", firstChar);
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            System.out.printf("большой буквы '%c'", firstChar);
        } else if (firstChar >= '0' && firstChar <= '9') {
            System.out.printf("цифры '%c'%n", firstChar);
        } else {
            System.out.printf("символа '%c'", firstChar);
        }
        System.out.printf("Имя %s начинается с ", nickname);
        if (Character.isLowerCase(firstChar)) {
            System.out.printf("маленькой буквы '%c'", firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.printf("большой буквы '%c'", firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.printf("цифры '%c'%n", firstChar);
        } else {
            System.out.printf("символа '%c'", firstChar);
        }

        System.out.println("\n5.ИНВЕНТАРИЗАЦИЯ\n");
        int serialNumberDb = 223;
        int computerNumber = 121;

        if (serialNumberDb == computerNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2%n", serialNumberDb);
        } else {
            int dbDigit1 = serialNumberDb / 100;
            int dbDigit2 = (serialNumberDb / 10) % 10;
            int dbDigit3 = serialNumberDb % 10;
            
            int ocDigit1 = computerNumber / 100;
            int ocDigit2 = (computerNumber / 10) % 10;
            int ocDigit3 = computerNumber % 10;
            
            boolean hasAnyMatch = dbDigit1 == ocDigit1 ||
                    dbDigit2 == ocDigit2 || dbDigit3 == ocDigit3;
            
            if (!hasAnyMatch) {
                System.out.printf("[№%d]: оборудование не идентифицировано%n", serialNumberDb);
            } else {
                String match1 = (dbDigit1 == ocDigit1) ? String.valueOf(dbDigit1) : "_";
                String match2 = (dbDigit2 == ocDigit2) ? String.valueOf(dbDigit2) : "_";
                String match3 = (dbDigit3 == ocDigit3) ? String.valueOf(dbDigit3) : "_";
                System.out.printf("""
                        Нет полного совпадения:
                        База данных: [№%d]
                        Фактический: [№%s%s%s]
                        """, serialNumberDb, match1, match2, match3);
            }
        }
        System.out.println("\n6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %\n");
        System.out.println("Первый способ:\n");

        float bankDeposit = 321123.79f;
        int depositSum1 = 100_000;
        int depositSum2 = 300_000;
        int daysInYear = 365;
        float rate = 10.0f;
        if (bankDeposit < depositSum1) {
            rate = 5.0f;
        } else if (bankDeposit >= depositSum1 && bankDeposit <= depositSum2) {
            rate = 7.0f;
        }
        float interest = (bankDeposit * rate * daysInYear) / (daysInYear * 100);
        float totalAmount = bankDeposit + interest;
        System.out.printf("""
                Сумма вклада: %.2f
                Сумма начисленного процента: %.2f
                Итоговая сумма с процентами: %.2f
                """, bankDeposit, interest, totalAmount);

        System.out.println("\nВторой способ:\n");

        var bankDepositBd = new BigDecimal("321123.79");
        var depositSum1Bd = BigDecimal.valueOf(100000);
        var depositSum2Bd = BigDecimal.valueOf(300000);
        var daysInYearBd = BigDecimal.valueOf(365);
        BigDecimal rateBd = new BigDecimal("0.10");;
        if (bankDepositBd.compareTo(depositSum1Bd) < 0) {
            rateBd = new BigDecimal("0.05");
        } else if (bankDepositBd.compareTo(depositSum1Bd) >= 0 &&
                bankDepositBd.compareTo(depositSum2Bd) <= 0) {
            rateBd = new BigDecimal("0.07");
        }
        var interestBd = (bankDepositBd
                .multiply(rateBd)
                .multiply(daysInYearBd)
                .divide(daysInYearBd.multiply(BigDecimal.valueOf(100)
                .setScale(2, RoundingMode.HALF_UP))));
        var totalAmountBd = bankDepositBd
                .add(interestBd)
                .setScale(2, RoundingMode.HALF_UP);
        System.out.printf("""
                Сумма вклада: %.2f
                Сумма начисленного процента: %.2f
                Итоговая сумма с процентами: %.2f
                """, bankDeposit, interest, totalAmount);

        System.out.println("\n7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ\n");

        int historyPercent = 59;
        int historyGrade = 2;
        if (historyPercent > 91) {
            historyGrade = 5;
        } else if (historyPercent > 70) {
            historyGrade = 4;
        } else if (historyPercent > 60) {
            historyGrade = 3;
        }

        int programmingPercent = 92;
        int programmingGrade = 2;
        if (programmingPercent > 91) {
            programmingGrade = 5;
        } else if (programmingPercent > 73) {
            programmingGrade = 4;
        } else if (programmingPercent > 60) {
            programmingGrade = 3;
        }

        float averageScore = (historyGrade + programmingGrade) / 2.0f;
        float averagePercent = (historyPercent + programmingPercent) / 2.0f;

        System.out.printf("""
                История: %d (оценка: %d)
                Программирование: %d (оценка: %d)
                Средний балл оценок по предметам: %.2f
                Средний %% по предметам: %.2f
                """, historyPercent, historyGrade, 
                programmingPercent, programmingGrade, 
                averageScore, averagePercent);

        System.out.println("\n8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ\n");

        BigDecimal monthlyRevenue = new BigDecimal("13025.233");
        BigDecimal monthlyRent = new BigDecimal("5123.018");
        BigDecimal monthlyCost = new BigDecimal("9001.729");
        
        BigDecimal yearlyProfit = monthlyRevenue
                .subtract(monthlyRent)
                .subtract(monthlyCost)
                .multiply(BigDecimal.valueOf(12))
                .setScale(2, RoundingMode.HALF_UP);
        
        String sign = yearlyProfit.compareTo(BigDecimal.ZERO) > 0 ? "+" : "-";
        String formattedProfit = String.format("%.2f", yearlyProfit.abs());
        System.out.println("Прибыль за год: " + sign + formattedProfit + " руб.");
    }
}