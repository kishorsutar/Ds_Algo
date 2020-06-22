package dp;

public class RodCutting {
    static int cnt;
    public static void main(String[] args) {
        int res, rodLen = 8;
        int[] price = {0, 1, 5, 8, 9, 10, 14, 17, 20, 24, 30};
        cnt = 0;
        recMaxProfit(price, rodLen);
    }

    public static int recMaxProfit(int[] price, int rodLen) {
        if (rodLen == 0)
            return 0;
        Math.max(price[rodLen], price[rodLen - 1]);
        return 0;
    }
}
