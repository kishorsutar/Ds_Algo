package ds.arraystring;

public class MaxSpan {

    public static void main(String[] args) {
        int result = maxSpan(new int[] {1, 2, 1, 1, 3});
        System.out.println("result " + result);
    }

    static int maxSpan(int[] nums) {
        int maxSpan = 1;
        if (nums.length == 0) return 0;
        for (int i= 0; i < nums.length; i++) {
            int temp = 0;
            int j = i + 1;

            while ( j < nums.length && nums[i] <= nums[j]) {
                j++;
                temp++;
            }

            maxSpan = Math.max(temp, maxSpan);
        }


        return maxSpan;
    }
}
