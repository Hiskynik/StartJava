import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculations = true;

        while (continueCalculations) {
            Calculator calculator = new Calculator();

            System.out.println("Введите первое число: ");
            int num1 = scanner.nextInt();
            calculator.setNum1(num1);

            System.out.println("Введите знак операции (+, -, *, /, ^, %): ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator);

            // Если оператор некорректный, пропускаем ввод второго числа
            if (!calculator.isValidOperation()) {
                calculator.printResult();
                continueCalculations = askToContinue(scanner);
                continue;
            }

            System.out.println("Введите второе число: ");
            int num2 = scanner.nextInt();
            calculator.setNum2(num2);

            calculator.calculate();
            calculator.printResult();

            continueCalculations = askToContinue(scanner);
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.println("Хотите продолжить вычисления? [yes/no]: ");
            String input = scanner.next().toLowerCase();

            if (input.equals("no")) {
                return false;
            } else if (input.equals("yes")) {
                return true;
            } else {
                System.out.println("Ошибка: введите 'yes' или 'no'");
            }
        }
    }
}