// 2. Вывести все простые числа от 1 до 1000

import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        {
            System.out.print("Введите N:");
            int n = new Scanner(System.in).nextInt();
            System.out.printf("Простые числа от 1 до %s: ", n);
            System.out.println(simpleNumber(n));
        }
    }
        static boolean testNumber ( int x){
            int d = 2;
            while (x % d != 0 && d < x)
                d++;
            return (d == x);
        }
        public static StringBuilder simpleNumber(int n) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (testNumber(i)) {
                    result.append(String.valueOf(i));
                    result.append(',');
                }
            }
            result.deleteCharAt(result.length() - 1);
            return result;
        }
}
