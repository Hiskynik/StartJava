package com.startjava.lesson_1.base;

import java.util.Scanner;

public class MyFirstApp {
    public static void main(String[] args) {
        System.out.println("У какого языка программирования следующий слоган:");
        System.out.print("Написано однажды, ");
        System.out.println("работает везде!");

        String answer = new Scanner(System.in).next();
        if (answer.equalsIgnoreCase("Java")) {
            System.out.println("Вы угадали");
        } else {
            System.out.println("Увы, но - это Java");
        }
    }
}