package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.setNickname("Bobik");
        wolfOne.setGender("male");
        wolfOne.setColor("grey");
        wolfOne.setAge(5);

        System.out.println("nickname = " + wolfOne.getNickname());
        System.out.println("gender = " + wolfOne.getGender());
        System.out.println("color = " + wolfOne.getColor());
        System.out.println("age = " + wolfOne.getAge());

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}