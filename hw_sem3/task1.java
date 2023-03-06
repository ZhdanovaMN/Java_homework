import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//1. Задан целочисленный список ArrayList.
// Найти минимальное, максимальное и среднее арифметическое из этого списка.
public class task1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Scanner rand;
            list.add(random.nextInt(0, 100));

        }
        System.out.println("Сгенерированный список: " + list);
        System.out.println("Минимальное значение: " + minValue(list));
        System.out.println("Максимальное значение: " + maxValue(list));
        System.out.println("Среднее арифметическое: " + meanValue(list));

    }
    public static int minValue(List<Integer> list) {
        int min = list.get(0);
        for (int element : list) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    public static int maxValue(List<Integer> list) {
        int max = list.get(0);
        for (int element : list) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static Double meanValue(List<Integer> list) {
        int sum = 0;
        int count = 0;
        for (int element : list) {
            sum += element;
            count++;
        }
        double average = Math.round((double)sum / (double)count * 100);
        return average / 100;
    }

}
