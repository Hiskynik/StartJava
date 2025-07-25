public class Calculator {
    private int num1;
    private int num2;
    private char operator;
    private double result;
    private boolean validOperation = true;

    void setNum1(int num1) {
        this.num1 = num1;
    }

    void setNum2(int num2) {
        this.num2 = num2;
    }

    void setOperator(char operator) {
        if (!isValidOperator(operator)) {
            validOperation = false;
            System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
            return;
        }
        this.operator = operator;
    }

    private boolean isValidOperator(char op) {
        return "+-*/^%".indexOf(op) != -1;
    }

    void calculate() {
        if (!validOperation) return;

        switch (operator) {
            case '+': 
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    validOperation = false;
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                }
                result = (double) num1 / num2;
                break;
            case '^':
                result = 1;
                int absNum2 = (num2 >= 0) ? num2 : -num2;
                for (int i = 0; i < absNum2; i++) {
                    result *= num1;
                }
                if (num2 < 0) {
                    result = 1 / result;
                }
                break;
            case '%':
                if (num2 == 0) {
                    validOperation = false;
                    System.out.println("Ошибка: деление на ноль запрещено");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                validOperation = false;
                System.out.printf("Ошибка: операция '%c' не поддерживается%n", operator);
        }
    }

    void printResult() {
        if (validOperation) {
            if (result == (int) result) {
                System.out.println(num1 + " " + operator + " " + num2 + " = " + (int) result);
            } else {
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            }
        }
    }

    boolean isValidOperation() {
        return validOperation;
    }
}