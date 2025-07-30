import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(scanner.nextLine());

        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine());

        GuessNumber game = new GuessNumber(player1, player2);

        boolean playAgain;
        do {
            while (!game.isGameOver()) {
                game.startRound(scanner);
            }
            playAgain = askToPlayAgain(scanner);
            if (playAgain) {
                game.resetGame();
            }
        } while (playAgain);

        System.out.println("Игра завершена!");
        scanner.close();
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Хотите продолжить игру? [yes/no]: ");
            String answer = scanner.next().toLowerCase();

            if (answer.equals("yes")) return true;
            if (answer.equals("no")) return false;

            System.out.println("Пожалуйста, введите 'yes' или 'no'");
        }
    }
}
