
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.
//
//        Example 1:
//        Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//        Output: 3
//        Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
//
//        Example 2:
//        Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//        Output: 5
//        Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].
public class task_hw6 {
    public static void main(String[] args) {
        // пример 1
        int [] nums1 = {1,2,3,2,1};
        int [] nums2 = {3,2,1,4,7};
        printResults(nums1, nums2);
        // пример 2
        int [] nums3 = {0,0,0,0,0};
        int [] nums4 = {0,0,0,0,0};
        printResults(nums3, nums4);
    }
    private static void printResults(int[] n1, int[] n2) {
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        maxSubArray(n1, n2);
        System.out.println();
    }

    private static HashSet<ArrayList<Integer>> getSets(int[] array) {
        HashSet<ArrayList<Integer>> tempSets = new HashSet<>();
        for (int n = 1; n <= array.length; n++) {
            for (int i = 0; i < array.length; i++) {
                ArrayList<Integer> tempArray = new ArrayList<>();
                for (int j = i; j < i + n; j++) {
                    if (j >= array.length) break;
                    tempArray.add(array[j]);
                }
                tempSets.add(tempArray);
            }
        }
        return tempSets;
    }

    private static void maxSubArray(int[] nums1, int[] nums2) {

        HashSet<ArrayList<Integer>> tempSet1 = getSets(nums1);
        HashSet<ArrayList<Integer>> tempSet2 = getSets(nums2);
        tempSet2.retainAll(tempSet1);
        int max = 0;
        ArrayList<ArrayList<Integer>> maxSubArrays = new ArrayList<>();
        for (ArrayList<Integer> item : tempSet2) {
            if (max < item.size()) {
                max = item.size();
                maxSubArrays = new ArrayList<>();
                maxSubArrays.add(item);
            }
            else if(max == item.size()){
                maxSubArrays.add(item);
            }
        }

        if (max == 0) {
            System.out.println("Повторяющихся подмассивов нет");
            return;
        }
        System.out.printf("Максимальная длина общего подмассива: %d\n", max);
        if (maxSubArrays.size() > 1) {
            System.out.print("Подмассивы с максимальной длиной: ");
        } else {
            System.out.print("Повторяющийся подмассив с максимальной длиной равен: ");
        }
        for (ArrayList<Integer> i : maxSubArrays) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}


