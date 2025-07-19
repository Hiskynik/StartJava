public class GuessNumber {
    public static void main(String[] args) {
        int secretNumber = 55;
        int low = 1;
        int high = 100;
        int guess;

        do { 
            guess = (low + high) / 2;
            System.out.println("Предположим, что это число: " + guess);
            if (guess < secretNumber) {
                System.out.println(guess + " меньше того, что загадал компьютер");
                low = guess + 1;
            } else if (guess > secretNumber) {
                System.out.println(guess + " больше того, что загадал компьютер");
                high = guess - 1;
            }
        } while (guess != secretNumber);

        System.out.println("Вы победили! Загаданное число: " + guess);
    }
}