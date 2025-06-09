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
        boolean isAdult = true == age > 18;
        if (age > 18) {
            System.out.println("Контент доступен для пользователей, достигших возраста " + age + " лет");
        } else {
            System.out.println("Контент недоступен");
        }

        float height = 1.8f;
        boolean isTall = false == height < 1.8;
        if (height < 1.8) {
            System.out.println("Неподходящий рост для данного аттракциона");
        } else {
            System.out.println("Добро пожаловать на аттракцион");
        }

        System.out.println("\n2.ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ\n");

        int stepsYesterday = 7252;
        int stepsToday = 10200;
        int stepsSum = stepsYesterday + stepsToday;
        double averageStepsCount = stepsSum / 2;

        System.out.println("Количество шагов за вчера и сегодня: " + stepsSum);
        if (stepsYesterday > stepsToday) {
            System.out.println("Вчера было больше шагов");
        } else if (stepsYesterday < stepsToday) {
            System.out.println("Вчера было меньше шагов");
        } else {
            System.out.println("Равное количество шагов");
        }
        System.out.println("Среднее значение шагов: " + averageStepsCount);

        System.out.println("\n3.ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ\n");
        
        int guestCount = 11;
        if (guestCount > 0) {
            if (guestCount % 2 == 1) {
                System.out.printf("Записалось %d гостей. Нужны индивидуальные задания. %n", guestCount);
            }
        } 
        if (guestCount > 0) {
            if (guestCount % 2 == 0) {
                System.out.printf("Записалось %d гостей." + 
                        "Можно формировать пары для конкурсов. %n", guestCount);
            }
        } else if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount < 0) {
            System.out.println("ошибка");
        }

        System.out.println("\n4.ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА\n");

        String nickname = "777Striker777";
        char firstChar = nickname.charAt(0);
        
        if (firstChar >= 'a' && firstChar <= 'z') {
            System.out.printf("Имя %s начинается с маленькой буквы '%c'%n", nickname, firstChar);
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            System.out.printf("Имя %s начинается с большой буквы '%c'%n", nickname, firstChar);
        } else if (firstChar >= '0' && firstChar <= '9') {
            System.out.printf("Имя %s начинается с цифры '%c'%n", nickname, firstChar);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'%n", nickname, firstChar);
        }

        if (Character.isLowerCase(firstChar)) {
            System.out.printf("Имя %s начинается с маленькой буквы '%c'%n", nickname, firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.printf("Имя %s начинается с большой буквы '%c'%n", nickname, firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.printf("Имя %s начинается с цифры '%c'%n", nickname, firstChar);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'%n", nickname, firstChar);
        }

        System.out.println("\n5.ИНВЕНТАРИЗАЦИЯ\n");

        int serialNumberDb = 233;
        int computerNumber = 133;
        String message = (serialNumberDb == computerNumber) ?
                String.format("[№%d]: компьютер на 3-м этаже в кабинете 2", serialNumberDb)
                : (serialNumberDb % 100 == computerNumber % 100) ?
                String.format("""
                    Нет полного совпадения:
                    База данных: [№%d]
                    Фактический: [№_%d]
                    """, serialNumberDb, computerNumber % 100)
                : String.format("[№%d]: оборудование не идентифицировано", serialNumberDb);
        System.out.printf(message);

        System.out.println("\n6.ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %\n");
        System.out.println("Первый способ:\n");

        float bankDeposit = 321123.79f;
        int depositSum1 = 100_000;
        int depositSum2 = 300_000;
        int daysInYear = 365;
        float rate;
        if (bankDeposit < depositSum1) {
            rate = 5.0f;
        } else if (bankDeposit >= depositSum1 && bankDeposit <= depositSum2) {
            rate = 7.0f;
        } else if (bankDeposit > depositSum2) {
            rate = 10.0f;
        } else {
            rate = 0.0f;
        }
        float interest = (bankDeposit * rate * daysInYear) / (daysInYear * 100);
        float totalAmount = bankDeposit + interest;
        String result = String.format("""
                     Сумма вклада: %.2f
                     Сумма начисленного процента: %.2f
                     Итоговая сумма с процентами: %.2f
                     """, bankDeposit, interest, totalAmount);
        System.out.printf(result);

        System.out.println("\nВторой способ:\n");

        var bankDepositBd = new BigDecimal("321123.79");
        var depositSum1Bd = new BigDecimal("100000");
        var depositSum2Bd = new BigDecimal("300000");
        var daysInYearBd = new BigDecimal("365");
        BigDecimal rateBd;
        if (bankDepositBd.compareTo(depositSum1Bd) < 0) {
            rateBd = new BigDecimal("0.05");
        } else if (bankDepositBd.compareTo(depositSum1Bd) >= 0 && +
                bankDepositBd.compareTo(depositSum2Bd) <= 0) {
            rateBd = new BigDecimal("0.07");
        } else if (bankDepositBd.compareTo(depositSum2Bd) > 0) {
            rateBd = new BigDecimal("0.10");
        } else {
            rateBd = BigDecimal.ZERO;
        }
        var interestBd = (bankDepositBd
                .multiply(rateBd)
                .multiply(daysInYearBd)
                .divide(daysInYearBd.multiply(new BigDecimal(100)
                .setScale(2, RoundingMode.HALF_UP))));
        var totalAmountBd = bankDepositBd
                .add(interestBd)
                .setScale(2, RoundingMode.HALF_UP);
        String resultBd = String.format("""
                     Сумма вклада: %.2f
                     Сумма начисленного процента: %.2f
                     Итоговая сумма с процентами: %.2f
                     """, bankDeposit, interest, totalAmount);
        System.out.printf(resultBd);

        System.out.println("\n7.ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ\n");

        int history = 59;
        int historyGrade;
        if (history > 91) {
            historyGrade = 5;
        } else if (history > 70) {
            historyGrade = 4;
        } else if (history > 60) {
            historyGrade = 3;
        } else {
            historyGrade = 2;
        }

        int programming = 92;
        int programmingGrade;
        if (programming > 91) {
            programmingGrade = 5;
        } else if (programming > 73) {
            programmingGrade = 4;
        } else if (programming > 60) {
            programmingGrade = 3;
        } else {
            programmingGrade = 2;
        }

        float averageScore = (historyGrade + programmingGrade) / 2.0f;
        float averagePercent = (history + programming) / 2.0f;

        String result1 = String.format("""
                История: %d (оценка: %d)
                Программирование: %d (оценка: %d)
                Средний балл оценок по предметам: %.2f
                Средний %% по предметам: %.2f
                """, history, historyGrade, programming, programmingGrade, averageScore, 
                averagePercent);

        System.out.print(result1);

        System.out.println("\n8.РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ\n");

        BigDecimal monthlyRevenue = new BigDecimal("13025.233");
        BigDecimal monthlyRent = new BigDecimal("5123.018");
        BigDecimal monthlyCost = new BigDecimal("9001.729");
        
        BigDecimal monthlyProfit = monthlyRevenue
                .subtract(monthlyRent)
                .subtract(monthlyCost);
        
        BigDecimal yearlyProfit = monthlyProfit.multiply(new BigDecimal("12"));
        
        yearlyProfit = yearlyProfit.setScale(2, RoundingMode.HALF_UP);
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        String formattedProfit = df.format(yearlyProfit);
        
        String sign = "";
        if (yearlyProfit.compareTo(BigDecimal.ZERO) > 0) {
            sign = "+";
        } else if (yearlyProfit.compareTo(BigDecimal.ZERO) < 0) {
            sign = "-";
            formattedProfit = formattedProfit.substring(1);
        }
        
        System.out.println("Прибыль за год: " + sign + formattedProfit.replace(".", ",") + " руб.");
    }
}