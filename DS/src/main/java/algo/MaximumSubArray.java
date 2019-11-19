package algo;

class MaximumSubArray {

    //
     int findMaxSubArray (int[] arr) {
         int maxSum = Integer.MIN_VALUE;
         int currentSum;
         int n = arr.length;

         for (int i = 0; i < n; i++) {
             currentSum = arr[i];
             for (int j = i+1; j < n; j++) {
                 currentSum += arr[j];
                 if(currentSum > maxSum) {
                     maxSum = currentSum;
                 }
             }
         }
         return maxSum;

     }

}
