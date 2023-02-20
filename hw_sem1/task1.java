
//1.1 Вычислить n-ое треугольное число(сумма чисел от 1 до n)

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите n: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Треугольное число(n) = " + triangularNumber(n));
    }
    public static int triangularNumber(int n) {
        int number = 1;
        for (int i = 2; i < n; i++)
            number += i;
        return number;
    }
}
