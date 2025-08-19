package com.startjava.lesson_1.base;

import java.time.LocalDate;
import java.time.Month;

public class VariableNamesTheme {
    public static void main(String[] args) {
        // блок №1
        System.out.println("\n1.РАЗНЫЕ ПЕРЕМЕННЫЕ\n");

        // Цифра
        int number = 5;
        System.out.println("Цифра " + number);

        // Сумма чисел Количество десятков tenCount
        int numberSum = 15 + 50;
        System.out.println("Сумма чисел = " + numberSum);

        // Произведение цифр
        int numberProduct = 5 * 9;
        System.out.println("Произведение цифр = " + numberProduct);

        // Максимальное число
        long maxNumber = 50L;
        System.out.println("Максимальное число = " + maxNumber);

        // Количество десятков
        int tenCount = 6;
        System.out.println("Количество десятков = " + tenCount);

        // Вес собаки
        int dogWeight = 15;
        System.out.println("вес собаки = " + dogWeight);

        // Исходное число
        int originalNumber = 1;
        System.out.println("Исходное число = " + originalNumber);

        // Процент по вкладу
        int depositRate = 12;
        System.out.println("Процент по вкладу = " + depositRate);

        // Символ &
        char simbol = '&';
        System.out.println("Символ " + simbol);

        // Код ошибки
        int errorCode = 400;
        System.out.println("Код ошибки: " + errorCode);

        // Тип сообщения
        String messageType = "ERROR_MESSAGE";
        System.out.println("Тип сообщения: " + messageType);

        // Число нулей
        byte zeroCount = 5;
        System.out.println("Число нулей = " + zeroCount);

        // Уникальное число
        int uniqueNumber = 55;
        System.out.println("Уникальное число = " + uniqueNumber);

        // Случайное число 
        String randomNumber = "число, выбранное случайным образом";
        System.out.println("Случайное число - " + randomNumber);

        // Математическое выражение
        String mathExpression = "это совокупность чисел, " +
                "букв и математических знаков, которые описывают отношение между различными величинами";
        System.out.println("Математическое выражение - " + mathExpression);
        
        // Счет в игре
        String gameScore = "это числа, которые показывают текущую позицию команд " + 
                "или игроков в игре и её выигрышность";
        System.out.println("Случайное число - " + gameScore);
        
        // Максимальная длина
        int maxLength = 77;
        System.out.println("Максимальная длина = " + maxLength);
        
        // Пункт меню
        String menuItem = "это отдельная команда или параметр в меню или подменю";
        System.out.println("Пункт меню - " + menuItem);

        // Стоимость кофе
        int coffeePrice = 300;
        System.out.println("Стоимость кофе - " + coffeePrice);

        // Начальная дата
        LocalDate startDate = LocalDate.of(2023, Month.OCTOBER, 1);
        System.out.println("Начальная дата - " + startDate);

        // Окончание диапазона
        LocalDate rangeEnd = LocalDate.of(2024, Month.OCTOBER, 1);
        System.out.println("Окончание диапазона - " + rangeEnd);

        // Имя работника месяца
        String bestEmployeeName = "John";
        System.out.println("Имя работника месяца - " + bestEmployeeName);

        // Название электронной книги
        String ebookTitle = "Crime and Punishment";
        System.out.println("Название электронной книги - " + ebookTitle);

        // Размер
        byte size = 2;
        System.out.println("Размер = " + size);

        // Вместимость
        int capacity = 100;
        System.out.println("Вместимость = " + capacity);

        // Счетчик
        int counter = 0;
        System.out.println("Счетчик = " + counter);

        // Путь до файла
        String path = "W:\\JAVA\\StartJava\\src\\VariableNamesTheme.java";
        System.out.println("Путь до файла - " + path);

        // Количество чисел в строке
        int numberCount = 0;
        System.out.println("Количество чисел в строке = " + numberCount);

        // блок №2
        System.out.println("\n2.BOOLEAN-ПЕРЕМЕННЫЕ\n");

        // сотни равны?
        boolean isEqualHundreds = true;
        System.out.println("сотни равны? - " + isEqualHundreds);

        // компьютер включен?
        boolean isComputerOn = true;
        System.out.println("компьютер включен? - " + isComputerOn);

        // есть равные цифры?
        boolean hasEqualDigits = false;
        System.out.println("есть равные цифры? - " + hasEqualDigits);

        // служба создана?
        boolean isCreatedService = false;
        System.out.println("служба создана? - " + isCreatedService);

        // файл пустой?
        boolean isEmptyFile = true;
        System.out.println("файл пустой? - " + isEmptyFile);

        // соединение активное?
        boolean isActiveConnection = false;
        System.out.println("соединение активное? - " + isActiveConnection);

        // новый?
        boolean isNew = false;
        System.out.println("новый? - " + isNew);

        // электронная почта действительная?
        boolean isValidEmail = true;
        System.out.println("электронная почта действительная? - " + isValidEmail);

        // имеются уникальные строки?
        boolean hasUniqueStrings = false;
        System.out.println("имеются уникальные строки? - " + hasUniqueStrings);

        // блок №3
        System.out.println("\n3.АББРЕВИАТУРЫ\n");

        // старый universally unique identifier
        String oldUuid = "c1c1b1b0-20f3-11f0-9cd2-0242ac120002";
        System.out.println("старый universally unique identifier - " + oldUuid);

        // производитель оперативной памяти
        String ramManufacturer = "Kingston Technology";
        System.out.println("производитель оперативной памяти - " + ramManufacturer);

        // емкость жесткого диска
        int hddCapacity = 512;
        System.out.println("емкость жесткого диска - " + hddCapacity);

        // протокол передачи гипертекст
        String http = "это набор правил, по которым данные " +
                "в интернете передаются между разными источниками";
        System.out.println("протокол передачи гипертекста - " + http);

        // сокращенный uniform resource locator
        String shortUrl = "https:\\vk.cc\\5Jk553";
        System.out.println("сокращенный uniform resource locator - " + shortUrl);

        // новый идентификатор клиента
        int newClientId = 356;
        System.out.println("новый идентификатор клиента - " + newClientId);

        // american standard code for information interchange
        String ascii = "стандарт кодирования букв латинского алфавита, " +
                "цифр, некоторых специальных знаков и управляющих символов";
        System.out.println("american standard code for information interchange - " + ascii);
    }
}