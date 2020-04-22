package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        visit(candidates, 0, target, new ArrayList<>(), ret);
        return ret;
    }

    private void visit(int[] nums, int index, int sum, List<Integer> temp, List<List<Integer>> ret) {
        if(sum == 0) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < nums.length && nums[i] <= sum; i++) {
            temp.add(nums[i]);
            visit(nums, i, sum - nums[i], temp, ret);
            temp.remove(temp.size() - 1);
        }
    }
}
