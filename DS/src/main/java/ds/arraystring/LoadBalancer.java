package ds.arraystring;

public class LoadBalancer {

    boolean loadBalancer(int[] arr) {
        // all sum minus
        // left index and right index = drop sum
        // total sum - drop sum = remaining sum
        // remaining sum % 3 = 0 return true;
        // when loop ends return false;
        if (arr.length < 5) return false;

        int totalSum = 0;
        for (int i: arr) {
            totalSum += i;
        }

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (leftIndex < rightIndex) {
            int dropSum = arr[leftIndex] + arr[rightIndex];
            int remainingSum = totalSum - dropSum;
            if (remainingSum % 3 == 0) {
                return true;
            }
            leftIndex++;
            rightIndex--;
        }

        return false;

    }
}
