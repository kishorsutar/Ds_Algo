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


//        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
      /*  System.out.println(solve(new ArrayList<Integer>() {
            {
                add(7);
                add(3);
                add(16);
                add(10);
                add(10);
            }
        }));*/

//      moveZeroes(new int[]{1,0,3,0,12});
int[] t = new int[] {9, 1, 4, 7, 6, 5};
//        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
//        new ArrayOnHackerRank().rotateLeft(t, 3);
        new ArrayOnHackerRank().arrayList();

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


    static int solve(ArrayList<Integer> A) {
        Collections.sort(A);

        int size = A.size();

        for(int i = 0; i < size-1; i++) {
            if(A.get(i) == A.get(i+1)) {
                continue;
            }

            if(A.get(i) == (size - i - 1)) {
                return 1;
            }
        }

        if(A.get(size - 1) == 0) {
            return 1;
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


    static int maximumGap(final List<Integer> a) {
        if (a.size() == 0) return -1;
        if (a.size() == 1) return 0;
        int maxDiff;
        int i, j;
        int n = a.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(a.get(i), LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = a.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(a.get(j), RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = -1;
        while (j < n && i < n) {

            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }


        System.out.println(LMin[i-1] + " :" + RMax[j]);
        if(maxDiff == -1 && i != a.size() && LMin[i-1] == RMax[j]) return a.size()-1;

        return maxDiff;
    }

    static void moveZeroes(int[] nums) {
        // assuming non negative numbers and all elements are greater than 0.
        // if nums has 1 element then return or nums null then return

        int[] array = new int[nums.length+1];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                array[j] = nums[i];
                j++;
            }
        }

        nums = Arrays.copyOf(array, array.length);
        for (int w: nums
             ) {
            System.out.println(w);
        }

    }


    static int trap(int[] height) {
        if(height.length == 0) return 0;
        int n = height.length;
        int result = 0;
        int left_max = 0, right_max = 0;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if(height[lo] < height[hi]) {
                if(height[lo] > left_max){
                    left_max = height[lo];
                } else {
                    result += left_max - height[lo];
                    lo++;
                }
            } else {
                if(height[hi] > right_max) {
                    right_max = height[hi];
                } else {
                    result += right_max - height[hi];
                }
                hi--;
            }
        }

//        HashMap<Integer, Integer> testMap = new HashMap<>();
//        testMap.

        return result;

    }
}
