public class Calculator {
    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 10;
        char operator = '^';
        int result = 0;
        boolean validOperation = true;

        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;
        } else if (operator == '*') {
            result = num1 * num2;
        } else if (operator == '/') {
            result = num1 / num2;
        } else if (operator == '^') {
            result = 1;
            for (int i = 0; i < num2; i++)
                result *= num1;
        } else if (operator == '%') {
            result = num1 % num2;
        } else {
            System.out.println("Ошибка: Неизвестная операция!");
            validOperation = false;
        }
        if (validOperation) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
    }
}