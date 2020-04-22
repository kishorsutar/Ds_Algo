package algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeRooms {
    public static void main(String[] args) {
        int[][] input = new int[][]{{5, 10}, {15, 20}, {0,30}};
        for (int[] ints : input) {
            for (int anInt : ints) {
                System.out.println("before  " + anInt);
            }
        }

        Arrays.sort(input, (a, b) -> {
            return a[0] - b[0];
        });
        for (int[] ints : input) {
            for (int anInt : ints) {
                System.out.println("after  " + anInt);
            }
        }    }


        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);


}
