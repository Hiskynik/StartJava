public class Calculator {
    private int num1;
    private int num2;
    private char operator;
    private double result;

    void setNum1(int num1) {
        this.num1 = num1;
    }

    void setNum2(int num2) {
        this.num2 = num2;
    }

    boolean setOperation(char operator) {
        if (!isValidOperation(operator)) {
            System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
            return false;
        }
        this.operator = operator;
        return true;
    }

    private boolean isValidOperation(char operator) {
        return "+-*/^%".indexOf(operator) != -1;
    }

    boolean calculate() {
        switch (operator) {
            case '+': 
                result = num1 + num2;
                return true;
            case '-':
                result = num1 - num2;
                return true;
            case '*':
                result = num1 * num2;
                return true;
            case '/':
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return false;
                }
                result = (double) num1 / num2;
                return true;
            case '^':
                result = 1;
                int absNum2 = Math.abs(num2);
                for (int i = 0; i < absNum2; i++) {
                    result *= num1;
                }
                result = num2 < 0 ? 1 / result : result;
                return true;
            case '%':
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return false;
                }
                result = num1 / num2;
                return true;
            default:
                return false;
        }
    }

    void printResult() {
        if (result == (int) result) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + (int) result);
        } else {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        }
    }
}