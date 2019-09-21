package algo;

public class CountOnesInNumber {

    public static void main(String[] args) {
        int[] res = countBits(110);
        for (int s : res
        ) {
            System.out.println(s);
        }
    }

    static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                res[i] = res[i >> 1];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }

        return res;
    }
}
