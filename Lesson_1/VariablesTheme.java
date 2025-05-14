import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public class VariablesTheme {
    public static void main(String[] args) {
        // Засекаем время начала в наносекундах
        final long startNano = System.nanoTime();

        System.out.println("\n1.ВЫВОД ASCII-ГРАФИКИ\n");

        System.out.println("          /\\               ");
        System.out.println("   J     /  \\   V     V   a");
        System.out.println("   J    /_( )\\   V   V   a a");
        System.out.println("J  J   /      \\   V V   aaaaa");
        System.out.println(" JJ   /        \\   V   a     a");

        System.out.println("\n2.РАСЧЕТ СТОИМОСТИ ТОВАРА\n");
        System.out.println("Первый способ:\n");

        // объявляю переменные
        float penPrice = 105.5F;
        float bookPrice = 235.23F;
        float discountSize = 11F;

        // стоимость товаров без скидки
        float totalAmount = penPrice + bookPrice;
        System.out.println("стоимость товаров без скидки = " + totalAmount);

        // нахожу сумму скидки
        float discount = totalAmount * discountSize / 100;
        System.out.println("сумма скидки = " + discount);

        // нахожу стоимость товаров со скидкой
        float discountAmount = totalAmount - discount;
        System.out.println("стоимость товаров со скидкой = " + discountAmount);

        System.out.println("\nВторой способ:\n");

        // объявляю переменные
        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var discountSizeBd = new BigDecimal("11.0");

        // стоимость товаров без скидки
        var totalAmountBd = penPriceBd.add(bookPriceBd);
        System.out.println("стоимость товаров без скидки = " + totalAmountBd);

        // нахожу сумму скидки
        var discountBd = totalAmountBd
                .multiply(discountSizeBd)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        System.out.println("сумма скидки = " + discountBd);

        // нахожу стоимость товаров со скидкой
        var discountAmountBd = totalAmountBd.subtract(discountBd);
        System.out.println("стоимость товаров со скидкой = " + discountAmountBd);

        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ\n");

        int a = 2;  // Первая "ячейка"
        int b = 5;  // Вторая "ячейка"
        System.out.println("Исходные значения переменных: a = " + a + ", b = " + b);
        System.out.println("\nМетод: третьей переменной");

        // Перестановка через третью переменную
        int c = a;
        a = b;
        b = c;

        System.out.println("Результат: a = " + a + ", b = " + b);

        System.out.println("\nМетод: арифметических операций");
        a = a + b; // a = 7
        b = a - b; // b = 2
        a = a - b; // a = 5

        System.out.println("Результат: a = " + a + ", b = " + b);

        System.out.println("\nМетод: победитовый");
        a = a ^ b; // a = 7 (2 ^ 5 = 7)
        b = a ^ b; // b = 2 (7 ^ 5 = 2)
        a = a ^ b; // a = 5 (7 ^ 2 = 5)
        System.out.println("Результат: a = " + a + ", b = " + b);

        System.out.println("\n4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ\n");
        
        // объявляю переменные и присваиваю значения
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;

        // Вывожу коды в первой строке
        System.out.printf("%-6d%-6d%-6d%-6d%-6d%-6d%n", 
                         code1, code2, code3, code4, code5, code6);

        // Вывожу символы во второй строке
        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n",
                         (char) code1, (char) code2, (char) code3,
                         (char) code4, (char) code5, (char) code6);

        System.out.println("\n5.АНАЛИЗ КОДА ТОВАРА\n");

        // объявляю переменную кода и присваиваю значение
        int code = 123;

        // Разделяю цифры кода
        int category = code / 100;
        int subcategory = (code % 100) / 10;
        int packagingType = code % 10;

        // Вычисляю контрольные значения
        int controlSum = category + subcategory + packagingType;
        int checkCode = category * subcategory * packagingType;

        // Вывожу результат с нужным форматированием
        System.out.println("Код товара: " + code);
        System.out.println("  категория товара - " + category);
        System.out.println("  подкатегория - " + subcategory);
        System.out.println("  тип упаковки - " + packagingType);
        System.out.println("Контрольная сумма = " + controlSum);
        System.out.println("Проверочный код = " + checkCode);

        System.out.println("\n6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ\n");

        // Byte - температура
        byte temperature = Byte.MAX_VALUE;
        System.out.println("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) temperature, (int) (temperature + 1), (int) (temperature)));

        // Short - давление
        short pressure = Short.MAX_VALUE;
        System.out.println("""
                [Давление, hPa]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) pressure, (int) (pressure + 1), (int) (pressure)));

        // Character - код состояния системы
        char systemCode = Character.MAX_VALUE;
        System.out.println("""
                [Код состояния системы, код]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) systemCode, (int) (systemCode + 1), (int) (systemCode)));

        // Integer - пройденное расстояние
        int distance = Integer.MAX_VALUE;
        System.out.println("""
                [Пройденное расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(distance, distance + 1, distance));

        // Long - время с момента старта
        long uptime = Long.MAX_VALUE;
        System.out.println("""
                [Время с момента старта, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(uptime, uptime + 1, uptime));

        System.out.println("\n7.ВЫВОД ПАРАМЕТРОВ JVM И ОС\n");

        // Получаем информацию о JVM
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        // Получаем информацию о системе
        String systemDrive = System.getProperty("user.home");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String pathSeparator = System.getProperty("path.separator");

        // Выводим информацию с помощью текстовых блоков
        System.out.println("""
            ======================
            Характеристики JVM:
            ======================
            Доступное число ядер: %d
            Выделенная память: %.1f МБ
            Свободная память: %.1f МБ
            Используемая память: %.1f МБ
            Максимально доступная память: %.1f МБ
                """.formatted(
                availableProcessors,
                (double) totalMemory,
                (double) freeMemory,
                (double) usedMemory,
                (double) maxMemory
            ));

        System.out.println("""
            ======================
            Параметры ОС:
            ======================
            Системный диск: %s
            Версия ОС: %s
            Версия Java: %s
            Символ разделения пути: '%s'
                """.formatted(
                systemDrive,
                osVersion,
                javaVersion,
                pathSeparator
            ));
        System.out.println("\n8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА\n");

        // Получаю текущее время и вывожу старт
        LocalTime startTime = LocalTime.now();
        System.out.printf("Старт проверки: %02d:%02d:%02d.%03d%n",
                startTime.getHour(),
                startTime.getMinute(),
                startTime.getSecond(),
                startTime.getNano() / 1_000_000);

        // Засекаю время окончания в наносекундах
        long endNano = System.nanoTime();

        // Получаю текущее время и выводим финиш
        LocalTime endTime = LocalTime.now();
        System.out.printf("Финиш проверки: %02d:%02d:%02d.%03d%n",
                endTime.getHour(),
                endTime.getMinute(),
                endTime.getSecond(),
                endTime.getNano() / 1_000_000);

        // Вычисляю время работы в секундах с тремя знаками после запятой
        double durationSeconds = (endNano - startNano) / 1_000_000_000.0;
        System.out.printf("Время работы:   %.3f сек%n", durationSeconds);
    }
}