package ds.dp;

public class MaxSumInSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 10, 7, 20, 30, 50, 11, 3};
        System.out.println(maxSumInSeq(arr));
    }

    static int maxSumInSeq(int[] array) {
        int[] sums = array.clone();
        int maxSum = sums[0];
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            for (int j = 0; j < i; j++) {
                int prevNum = array[j];
                if (prevNum < currentNumber && sums[j] + currentNumber <= sums[i]) {
                    sums[i] = sums[j] + currentNumber;
                }
            }
            maxSum = Math.max(maxSum, sums[i]);
        }
        return maxSum;
    }
}
