package algo;

public class Algo {

    public static void main(String[] args) {

        MaximumSubArray subArray = new MaximumSubArray();
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(subArray.findMaxSubArray(array));

    }
}
