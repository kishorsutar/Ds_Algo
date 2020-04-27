package algo;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] str) {
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            result.add(pq.poll());
        Collections.reverse(result);
        return result;
    }
}
