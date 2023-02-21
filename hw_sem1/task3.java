
//3. Реализовать простой калькулятор

import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        double result = calculator(num1, num2, operation);
        System.out.println("Результат вычислений: " + result);
    }

    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Ошибка при вводе числа. Попробуйте еще раз");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите операцию: ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка при вводе операции. Попробуйте еще раз");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calculator(double num1, int num2, char operation) {
        double result;
        switch (operation) {
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
                result = num1 / num2;
                if (num2 == 0) {
                    throw new IllegalArgumentException("На ноль делить нельзя!");
                }
                break;
            default:
                System.out.println("Операция не распознана. Попробуйте еще раз");
                result = calculator(num1, num2, getOperation());
        }
        return result;
    }
}
