public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.nickname = "Bobik";
        wolfOne.gender = "male";
        wolfOne.color = "grey";
        wolfOne.age = 7;

        System.out.println("nickname = " + wolfOne.nickname);
        System.out.println("gender = " + wolfOne.gender);
        System.out.println("color = " + wolfOne.color);
        System.out.println("age = " + wolfOne.age);

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}