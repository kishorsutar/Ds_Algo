package ds.arraystring;

public class MaxSubArrayCount {

    public static void main(String[] args) {
        subArraysum(new int[]{1, 1, 1});
    }

    public static int subArraysum(int[] array) {
        int i = 0;
        int j = 1;
        int count = 0;

        while (i < array.length && j < array.length) {
            System.out.println("I " + i + " " + array[i++] + " J " + j + " " + array[j++]);
        }

        return count;

    }
}
