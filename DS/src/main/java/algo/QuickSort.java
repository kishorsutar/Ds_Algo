package algo;

public class QuickSort {

        public static void main(String[] args) {
            int[] arr = {4,6,1,9,0,4,25,83,3};
            int n = arr.length;
             quickSort(arr, 0, n-1);
//            Arrays.sort(arr);
            for(int r=0; r<arr.length; r++){
                System.out.println(arr[r]);
            }
        }

        static int[] quickSort(int[] arr, int begin, int end) {

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

        }

}
