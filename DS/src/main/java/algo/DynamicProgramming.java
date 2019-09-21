package algo;


import java.util.HashMap;

public class DynamicProgramming {

    public static void main (String[] args) {
        climbStairs(10);
    }
    static int climbStairsA(int n) {
        if(n<2)
            return n;
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2;i<=n;i++) {
            System.out.println("a-1" + a[i-1]);
            System.out.println("a-2" + a[i-2]);
            System.out.println("ai[]" + a[i]);

            a[i] = a[i - 1] + a[i - 2];
            System.out.println("a[]i" + a[i]);
        }


        for (int d: a
             ) {
            System.out.println(d);
        }

        return a[n];
    }

    static int climbStairs(int n) {
            if(n == 1 || n == 0){
                return 1;
            }
            if(n == 2){
                return 2;
            }

        HashMap<Integer, Integer> map = new HashMap<>();
            if(!map.containsKey(n)){
                map.put(n, climbStairs(n-1) + climbStairs(n-2));
            }
        System.out.println(map.get(n));
            return map.get(n);
        }

    public boolean predictTheWinner(int [] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] =  nums[i];
        }
//for(int i = )Pri
return true;

    }
}
