
import java.util.*;

// 2. Пусть дан произвольный список целых чисел, удалить из него четные числа
public class task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Scanner rand;
            list.add(random.nextInt(0, 100));
        }

        System.out.println("Сгенерированный список: " + list);

        Iterator <Integer> iter = list.iterator();

        while (iter.hasNext()) {
            int i = iter.next() ;
            if (i % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println("Список без четных чисел: ");
        System.out.println(list);
    }
}
