import java.util.Scanner;

class GuessNumber {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private int targetNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.currentPlayer = player1;
    }

    public void start(Scanner scanner) {
        while (targetNumber != 0) {
            startRound(scanner);
        }
    }

    public void startRound(Scanner scanner) {
        System.out.println(currentPlayer.getName() + ", ваша очередь угадывать!");
        System.out.print("Введите число от 1 до 100): ");

        int guess = inputGuess(scanner);
        currentPlayer.setNumber(guess);

        if (isGuessCorrect(guess)) {
            handleCorrectGuess();
        } else {
            handleIncorrectGuess(guess);
            switchPlayer();
        }
    }

    private int inputGuess(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Это не число! Введите целое число: ");
                scanner.next();
                continue;
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input < 1 || input > 100) {
                System.out.print("Число должно быть от 1 до 100! Попробуйте снова: ");
                continue;
            }
            return input;
        }
    }

    private boolean isGuessCorrect(int guess) {
        return guess == targetNumber;
    }

    private void handleCorrectGuess() {
        System.out.println("Поздравляем, " + currentPlayer.getName() +
                "! Вы угадали число " + targetNumber + "!");
        targetNumber = 0;
    }

    private void handleIncorrectGuess(int guess) {
        System.out.println("Неверно! Загаданное число " +
                (guess < targetNumber ? "больше" : "меньше") + ".");
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}