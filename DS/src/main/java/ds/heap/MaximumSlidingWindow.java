package ds.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumSlidingWindow {

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[]{};
        int[] list = new int[nums.length - k + 1];

        int i = 0;
        int j = i + k - 1;

        while (j < nums.length) {
            int max = Integer.MIN_VALUE;
            int temp = i;
            while (temp <= j) {
                max = Math.max(max, nums[temp]);
                temp++;
            }
            list[i] = (max);
            i++;
            j = i + k - 1;
        }

        Arrays.sort(new Integer[]{4, 6, 7, 8}, Comparator.comparingInt(o -> o));

        return list;
    }

}
