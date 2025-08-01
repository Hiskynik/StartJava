import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine());

        do {
            GuessNumber game = new GuessNumber(player1, player2);
            game.start(scanner);
        } while (askToPlayAgain(scanner));

        System.out.println("Игра завершена!");
        scanner.close();
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Хотите продолжить? [yes/no]: ");
            String answer = scanner.next().toLowerCase();
            scanner.nextLine();

            if (answer.equals("yes")) {
                return true;
            } else if (answer.equals("no")) {
                return false;
            }
            
            System.out.println("Пожалуйста, введите только 'yes' или 'no'");
        }
    }
}