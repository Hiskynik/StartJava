import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VariablesTheme {
    public static void main(String[] args) {
        final LocalTime startTime = LocalTime.now();
        final long startNanoTime = System.nanoTime();

        System.out.println("\n1.ВЫВОД ASCII-ГРАФИКИ\n");

        System.out.println(
                "                             /\\\n" +
                "           J    a  v     v  /  \\\n" +
                "           J   a a  v   v  /_( )\\\n" +
                "        J  J  aaaaa  V V  /      \\\n" +
                "         JJ  a     a  V  /___/\\___\\"
        );
        System.out.printf("""
                                 /\\            
                           J    /  \\  v     v  a
                           J   /_( )\\  v   v  a a
                        J  J  /      \\  V V  aaaaa
                         JJ  /___/\\___\\  V  a     a
                """);

        System.out.println("\n2.РАСЧЕТ СТОИМОСТИ ТОВАРА\n");
        System.out.println("Первый способ:\n");

        float penPrice = 105.5F;
        float bookPrice = 235.23F;
        float discountSize = 11F;

        float totalPrice = penPrice + bookPrice;
        System.out.println("стоимость товаров без скидки = " + totalPrice);

        float discount = totalPrice * discountSize / 100;
        System.out.println("сумма скидки = " + discount);

        float discountPrice = totalPrice - discount;
        System.out.println("стоимость товаров со скидкой = " + discountPrice);

        System.out.println("\nВторой способ:\n");

        var penPriceBd = new BigDecimal("105.5");
        var bookPriceBd = new BigDecimal("235.23");
        var discountSizeBd = BigDecimal.valueOf(11);

        var totalPriceBd = penPriceBd.add(bookPriceBd);
        System.out.println("стоимость товаров без скидки = " + totalPriceBd);

        var discountBd = totalPriceBd
                .multiply(discountSizeBd)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        System.out.println("сумма скидки = " + discountBd);

        var discountPriceBd = totalPriceBd.subtract(discountBd);
        System.out.println("стоимость товаров со скидкой = " + discountPriceBd);

        System.out.println("\n3.ПЕРЕСТАНОВКА ЗНАЧЕНИЙ ЯЧЕЕК В ТАБЛИЦЕ\n");

        int cell1 = 2;
        int cell2 = 5;
        System.out.println("Исходные значения переменных: A1 = " + cell1 + ", A2 = " + cell2);
        System.out.println("\nМетод: использование третьей переменной");

        int tmp = cell1;
        cell1 = cell2;
        cell2 = tmp;

        System.out.println("Результат: A1 = " + cell1 + ", A2 = " + cell2);

        System.out.println("\nМетод: применение арифметических операций");
        cell1 += cell2;
        cell2 = cell1 - cell2;
        cell1 -= cell2;

        System.out.println("Результат: A1 = " + cell1 + ", A2 = " + cell2);

        System.out.println("\nМетод: побитовый");
        cell1 ^= cell2;
        cell2 ^= cell1;
        cell1 ^= cell2;
        System.out.println("Результат: A1 = " + cell1 + ", A2 = " + cell2);

        System.out.println("\n4.ДЕКОДИРОВАНИЕ СООБЩЕНИЯ\n");
        
        int code1 = 1055;
        int code2 = 1088;
        int code3 = 1080;
        int code4 = 1074;
        int code5 = 1077;
        int code6 = 1090;

        System.out.printf("%-6d%-6d%-6d%-6d%-6d%-6d%n", +
                code1, code2, code3, code4, code5, code6);

        System.out.printf("%-6c%-6c%-6c%-6c%-6c%-6c%n", +
                code1, code2, code3, code4, code5, code6);

        System.out.println("\n5.АНАЛИЗ КОДА ТОВАРА\n");

        int code = 123;

        int category = code / 100;
        int subcategory = (code % 100) / 10;
        int packagingType = code % 10;

        int checksum = category + subcategory + packagingType;
        int checkCode = category * subcategory * packagingType;

        System.out.println("Код товара: " + code);
        System.out.println("  категория товара - " + category);
        System.out.println("  подкатегория - " + subcategory);
        System.out.println("  тип упаковки - " + packagingType);
        System.out.println("Контрольная сумма = " + checksum);
        System.out.println("Проверочный код = " + checkCode);

        System.out.println("\n6.ТЕСТИРОВАНИЕ ДАТЧИКОВ ПЕРЕД ЗАПУСКОМ РАКЕТЫ\n");

        byte temperature = Byte.MAX_VALUE;
        System.out.println("""
                [Температура, °C]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(temperature, ++temperature, --temperature));

        short pressure = Short.MAX_VALUE;
        System.out.println("""
                [Давление, hPa]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(pressure, ++pressure, --pressure));

        char systemCode = Character.MAX_VALUE;
        System.out.println("""
                [Код состояния системы, код]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted((int) systemCode, (int) (++systemCode), (int) (--systemCode)));

        int distance = Integer.MAX_VALUE;
        System.out.println("""
                [Пройденное расстояние, м]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(distance, ++distance, --distance));

        long uptime = Long.MAX_VALUE;
        System.out.println("""
                [Время с момента старта, мс]:
                  Исходное: %d
                  +1: %d
                  -1: %d
                """.formatted(uptime, ++uptime, --uptime));

        System.out.println("\n7.ВЫВОД ПАРАМЕТРОВ JVM И ОС\n");

        final float toMb = 1024 * 1024;
        final Runtime runtime = Runtime.getRuntime();

        int availableProcessors = runtime.availableProcessors();
        float maxMemoryMb = runtime.maxMemory() / toMb;
        float totalMemoryMb = runtime.totalMemory() / toMb;
        float freeMemoryMb = runtime.freeMemory() / toMb;
        float usedMemoryMb = totalMemoryMb - freeMemoryMb;

        System.out.printf("""
            Доступное число ядер: %d
            Информация о памяти (МБ):
            Максимальная память: %.1f
            Всего памяти: %.1f
            Используемая память: %.1f
            Свободная память: %.1f
                """, availableProcessors, maxMemoryMb, totalMemoryMb, usedMemoryMb, freeMemoryMb);

        char osDrive = System.getProperty("user.home").charAt(0);
        char pathSeparator = System.getProperty("file.separator").charAt(0);
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");

        System.out.println("""
            Описание и значения характеристик:
            Системный диск: %c:\\
            Версия ОС: %s
            Версия Java: %s
            Символ разделения пути: %c
                """.formatted(osDrive, osVersion, javaVersion, pathSeparator));

        System.out.println("\n8.ЗАМЕР ВРЕМЕНИ РАБОТЫ КОДА\n");

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        System.out.println("Старт проверки: " + dtf.format(startTime));
        long endNanoTime = System.nanoTime();
        double elapsedSeconds = (endNanoTime - startNanoTime) / 1e9;
        LocalTime endTime = LocalTime.now();
        System.out.println("Финиш проверки: " + dtf.format(endTime));
        System.out.printf("Время работы:   %.3f сек%n", elapsedSeconds);
    }
}