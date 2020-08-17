package ds.arraystring;

import java.util.Arrays;

public class SwapTheElement {

    public static void main(String[] args) {
        int[] A = new int[]{9, 7, 4, 5, 6, 9, 2, 5};
        int m = 10;
        int[] countArray = counting(A, m);
        int[] B = new int[]{2, 1, 10, 7, 2, 8, 3, 9};
        System.out.println(Arrays.toString(countArray));
        System.out.println(swapTheElement(A, B, m));
    }

    private static boolean swapTheElement(int[] A, int[] B, int m) {
        int sumA = 0;
        int sumB = 0;

        for (int i : A) {
            sumA += i;
        }
        for (int j : B) {
            sumB += j;
        }
        int diff = sumB - sumA;
        int[] count = counting(A, m);
        for (int i = 0; i < A.length; i++) {
            int c = B[i] - diff;
            if (0 <= c && c <= m && count[c] > 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * this function is used for counting number of occurrences of each number present in array A
     *
     * @param A
     * @param m
     * @return
     */
    private static int[] counting(int[] A, int m) {
        // m = range of the numbers from where to where number would be in the array.
        int[] count = new int[m + 1];
        for (int value : A) {
            count[value] += 1;
        }
        return count;
    }
}
