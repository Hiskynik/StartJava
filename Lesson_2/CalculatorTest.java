import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userResponce = "yes";

        while (userResponce.equals("yes")) {
            Calculator calculator = new Calculator();

            System.out.println("Введите первое число: ");
            int num1 = scanner.nextInt();
            calculator.setNum1(num1);

            System.out.println("Введите знак операции (+, -, *, /, ^, %): ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator);

            if (!calculator.isValidOperation()) {
                calculator.printResult();
                userResponce = askToContinue(scanner);
                continue;
            }

            System.out.println("Введите второе число: ");
            int num2 = scanner.nextInt();
            calculator.setNum2(num2);

            calculator.calculate();
            calculator.printResult();

            userResponce = askToContinue(scanner);
        }
        System.out.println("Программа завершена.");
        scanner.close();
    }

    private static String askToContinue(Scanner scanner) {
        while (true) {
            System.out.println("Хотите продолжить вычисления? [yes/no]: ");
            String input = scanner.next().toLowerCase();

            if (input.equals("no") || input.equals("yes")) {
                return input;
            }
            System.out.println("Ошибка: введите 'yes' или 'no'");
        }
    }
}