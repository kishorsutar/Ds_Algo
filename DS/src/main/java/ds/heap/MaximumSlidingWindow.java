package ds.heap;

import java.util.ArrayList;

public class MaximumSlidingWindow {

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
       for (int i  : arr) {
           System.out.print(i + " ");
       }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) return new int[] {};

        int i = 0;
        int j = i+k-1;

        while (j < nums.length) {
            int max = Integer.MIN_VALUE;
            int temp = i;
            while (temp <= j) {
                max = Math.max(max, nums[temp]);
                temp++;
            }
            list.add(max);
            i++;
            j = i+k-1;
        }

        int[] intArray = new int[list.size()];
        for(int a = 0; a < list.size(); a++) {
            intArray[a] = list.get(a);
        }

        return intArray;
    }

}
