package ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class ArrayOnHackerRank {

    void rotateLeft(int[] arr, int d) {

        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        for (int i : rotated) System.out.println(i);
    }


    void arrayList() {
        Integer[] arr = new Integer[]{7, 6, 2, 1, 5, 4, 3};
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(arr));

        ints.sort(Comparator.reverseOrder());

        for (int i:
             ints) {
            System.out.print(i);
        }
    }
}
