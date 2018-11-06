package algo;

public class BinarySearch {

    public int binarySearch(int[] inputArray, int value) {
        int left = 0;
        int right = inputArray.length -1;
        int mid = (left + right) / 2;

        while(left<=right) {

            if(inputArray[mid]==value)
                return mid;

            if(value > inputArray[mid]) {
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
