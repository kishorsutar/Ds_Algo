package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalUtilisation {

    public static void main(String[] args) {
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        list1.add(new int[]{1, 3});
        list1.add(new int[]{2, 5});
        list1.add(new int[]{3, 7});
        list1.add(new int[]{4, 10});

        list2.add(new int[]{1, 2});
        list2.add(new int[]{2, 3});
        list2.add(new int[]{3, 4});
        list2.add(new int[]{4, 5});
// a = [[1, 8], [2, 15], [3, 9]]
// b = [[1, 8], [2, 11], [3, 12]]
        // target = 20
//         a = [[1, 3], [2, 5], [3, 7], [4, 10]]
// b = [[1, 2], [2, 3], [3, 4], [4, 5]]
// target = 10






        List<int[]> res = optimalUtilisation(list1, list2, 10);
        for (int[] ar : res)
            System.out.println("Hello World! " + ar[0] + "," + ar[1]);
    }

    static List<int[]> optimalUtilisation(List<int[]> list1, List<int[]> list2, int target) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < list1.size(); i++) {
            int value1 = list1.get(i)[1];

            for (int j = 0; j < list2.size(); j++) {
                int value2 = list2.get(j)[1];

                int currentSum = value1 + value2;
                if (currentSum <= target && currentSum >= maxSum) {

                    List<int[]> temp = map.getOrDefault(currentSum, new ArrayList<int[]>());
                    int[] res = new int[] {list1.get(i)[0], list2.get(j)[0]};
                    temp.add(res);
                    map.put(currentSum, temp);
                    maxSum = currentSum;
                }

            }
        }

        return map.get(maxSum);
    }
}
