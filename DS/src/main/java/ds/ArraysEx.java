package ds;

import java.util.*;

public class ArraysEx {

    public static void main(String[] args) {
       /* System.out.println(maxset(new ArrayList<Integer>() {
            {
                add(0); //, , ,
                add(0);
                add(-7);
                add(0);
//                add(5);
            }
        }));*/
//        printArray(6);
/*System.out.println(repeatedNumber(new ArrayList<Integer>() {
    {
        add(1);
        add(2);
        add(3);
        add(1);
        add(1);

    }
}));*/

/*System.out.println(plusOne(new ArrayList<Integer>(){
    {
        add(9);
        add(9);
        add(9);
        add(9);
        add(9);
    }
}));*/


        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    static ArrayList<Integer> wave(ArrayList<Integer> A) {
        if (A == null || A.isEmpty())
            return A;


        int n = A.size();
        Collections.sort(A);
        ArrayList<Integer> newA = new ArrayList<Integer>();
        for (int i = 0; i < n; i += 2) {
            int j = i + 1;
            if (j < n)
                swap(newA, A, i, i + 1);
            else newA.add(A.get(n - 1));
        }

        return newA;
    }

    static void swap(ArrayList<Integer> newA, ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        newA.add(i, A.get(j));
        newA.add(j, temp);
    }

    static void printArray(int n) {
        for (int i = 0; i < n / 2; i++) {
            System.out.println("I" + i + "Rever" + (n - i - 1));
        }
    }

    static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> currentRange = new ArrayList<Integer>();
        ArrayList<Integer> maxRange = new ArrayList<Integer>();
        float currentSum = 0;
        float maxSum = 0;
        int n = A.size();

        for (int i = 0; i < n; i++) {
            float elem = A.get(i);

            if (elem < 0) {
                if (currentSum >= maxSum) {

                    currentRange.clear();
                }
                currentSum = 0;
            } else {

                currentSum += elem;
                if (currentSum >= maxSum) {
                    maxSum = currentSum;
                }

                currentRange.add(A.get(i));

            }
            if (currentSum > maxSum) {
                maxRange.clear();
                maxRange.addAll(currentRange);
            }
        }
        if (maxRange.size() > currentRange.size())
            return maxRange;
        else return currentRange;
    }


    static int kInputSlot() {
        TreeSet<Integer> active = new TreeSet();
        int i = 0;
        search:
        while (i < 10) {
            i++;
            break;
        }

        return -1;
    }

    static int repeatedNumber(final List<Integer> array) {
        int n = array.size();
        HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (counterMap.containsKey(array.get(i))) {
                counterMap.put(array.get(i), counterMap.get(array.get(i)) + 1);
            } else {
                counterMap.put(array.get(i), 1);
            }
        }

        for (Integer listValue : counterMap.keySet()) {
            if (counterMap.get(listValue) > n / 3) {
                return listValue;
            }
        }

        return -1;

    }

    /*    static int[] plusOne(int[] digits) {
     *//*   int j = digits.length;
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < digits.length; i++) {
            double ele = digits[i] * Math.pow(10, j);
            sum += ele;
            j--;
        }

        sum++;
        int k = 0;
        int[] sumArru = new int[digits.length+1];
        while(k<=digits.length) {

            sumArru[k] = sum%10;
            sum = sum / 10;
            k++;
        }*//*
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }*/

    // {1,1,1,1, 4,6, 8, 3,3,3,3}
    private static List<Integer> getMejorityElements(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();

        for (int i : nums) {
            if (counterMap.containsKey(i)) {
                counterMap.put(i, counterMap.get(i) + 1);
            } else {
                counterMap.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        int s = a.size();
        if (s == 0) {
            throw new IllegalArgumentException("Invlid input array");
        }
        int[] digits = new int[s];
        for (int i = 0; i < s; i++) {
            digits[i] = a.get(i);
        }
        int n = digits.length;
        ArrayList<Integer> newA = new ArrayList<>();
        boolean isAllNine = true;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                isAllNine = false;
                break;
            }

            digits[i] = 0;
        }

        for (int in : digits) {
            newA.add(in);
        }
        if (isAllNine)
            newA.add(0, 1);
        return newA;


    }

    public static int findKthLargest(int[] nums, int k) {

        return kthSmallest(nums, 0, nums.length - 1, k);

    }

    private static int kthSmallest(int[] arr, int low,
                                   int high, int k) {
        if (k > 0) {
            if (low < high) {
                int pivot = partition(arr, low, high);
                System.out.println("Piovot:  " + pivot);

                if (pivot == k) {
                    return arr[pivot];
                } else {


                    kthSmallest(arr, low, pivot - 1, k);
                    kthSmallest(arr, pivot + 1, high, k);
                }

            }

        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
            int temp = arr[high];
            arr[i + 1] = arr[high];
            arr[high] = temp;

        }

        return i + 1;
    }


}
