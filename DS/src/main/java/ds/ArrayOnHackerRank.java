package ds;

class ArrayOnHackerRank {

    void rotateLeft(int[] arr, int d) {

        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        for (int i : rotated) System.out.println(i);
    }
}
