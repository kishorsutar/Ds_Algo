package algo;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 9, 0, 4, 25, 83, 3};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
//            Arrays.sort(arr);
        for (int r = 0; r < arr.length; r++) {
            System.out.println(arr[r]);
        }
    }

       /* static int[] quickSort(int[] arr, int begin, int end) {

            if(begin < end) {
                int partitionIndex = partition(arr, begin, end);

                quickSort(arr, begin, partitionIndex-1);
                quickSort(arr, partitionIndex+1, end);


            }
            return arr;
        }

        static int partition(int[] arr, int begin, int end) {
            int pivot = arr[end];
            int i = begin - 1;

            for(int j=begin; j<end; j++) {
                if(arr[j] <= pivot) {
                    i++;

                    int swapTemp = arr[i];
                    arr[i]= arr[j];
                    arr[j] = swapTemp;
                }


            }

            int swapTemp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = swapTemp;

            return i+1;

        }*/

  /*  private static void quickSort(int[] arr, int start, int end) {
        int partition = partition(arr, start, end);

        if(partition-1 > start) {
            quickSort(arr, start, partition-1);
        }
        if(partition+1 < end) {
            quickSort(arr, partition+1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for(int i = start; i < end; i++) {
            if(arr[i] < pivot ) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;
    }*/

    // middle piovot
    private static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) return;

        if (low == high) return;

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);

    }


}
