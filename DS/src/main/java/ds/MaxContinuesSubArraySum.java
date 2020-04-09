package ds;

import java.util.HashMap;
import java.util.Map;

public class MaxContinuesSubArraySum {

    public int subarraySumNaive(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end <= n; end++) {
                if (sum[end] - sum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>(); // use hashtable to store # of a prefix sum occurs so far
        map.put(0, 1); // initialize
        int sum = 0;
        int count = 0;

        // Let sum = nums[0] + ... + nums[i]
        // Check how many prefix sum(j's) equal to sum - k -> know # of how many nums[j + 1] + ... + nums[i] = k

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
