public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaegerOne = new Jaeger();
        jaegerOne.setModelName("Romeo Blue");
        jaegerOne.setMark("Mark-1");
        jaegerOne.setOrigin("USA");
        jaegerOne.setHeight(77.72f);
        jaegerOne.setWeight(7.775f);
        jaegerOne.setSpeed(2);
        jaegerOne.setStrength(7);
        jaegerOne.setArmor(6);

        System.out.println("\nДанные Егеря (создан через сеттеры):");
        System.out.println("Имя: " + jaegerOne.getModelName());
        System.out.println("Модель: " + jaegerOne.getMark());
        System.out.println("Страна: " + jaegerOne.getOrigin());
        System.out.println("Высота: " + jaegerOne.getHeight());
        System.out.println("Вес: " + jaegerOne.getWeight());
        System.out.println("Скорость: " + jaegerOne.getSpeed());
        System.out.println("Сила: " + jaegerOne.getStrength());
        System.out.println("Броня: " + jaegerOne.getArmor());

        jaegerOne.move();
        jaegerOne.useGatlingChest();
        jaegerOne.useTrachealBreak();

        Jaeger jaeger = new Jaeger("Gipsy Danger", "Mark-3", "USA",
                79.25f, 1.980f, 7, 8, 6);

        System.out.println("\nДанные Егеря (создан через конструктор):");
        System.out.println("Имя: " + jaeger.getModelName());
        System.out.println("Модель: " + jaeger.getMark());
        System.out.println("Страна: " + jaeger.getOrigin());
        System.out.println("Высота: " + jaeger.getHeight());
        System.out.println("Вес: " + jaeger.getWeight());
        System.out.println("Скорость: " + jaegerOne.getSpeed());
        System.out.println("Сила: " + jaegerOne.getStrength());
        System.out.println("Броня: " + jaegerOne.getArmor());

        jaeger.acceleration();
        jaeger.jump();
        jaeger.usePlasmacaster();
    }
}