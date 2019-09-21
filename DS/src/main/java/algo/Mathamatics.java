package algo;

import java.util.ArrayList;
import java.util.HashMap;

public class Mathamatics {

    public static void main(String[] args) {
//        System.out.println(sieve(10));
        uniquePath(3,3);
    }

    static ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> primeArray = new ArrayList<Integer>(A+1);

        for (int i = 0; i <= A; i++) {
            primeArray.add(i,1);
        }
        primeArray.add(0, 0);
        primeArray.add(1, 0);

        for (int i = 2; i <= Math.sqrt(A); i++) {
            if (primeArray.get(i) == 1) {
                System.out.println("index:"+i);
                for (int j = 2; j * i <= A; j++) {
                    System.out.println(i*j);
                    primeArray.add(i * j, 0);
                }
            }
        }

        ArrayList<Integer> resultPrime = new ArrayList<Integer>(A+1);
        for (int r = 2; r <= A; r++) {

            if (primeArray.get(r) == 1) {

                resultPrime.add(r);
            }
        }
        return resultPrime;
    }


    static void uniquePath(int a, int b) {

        int[] dp = new int[b];
        dp[0] = 1;

        for(int i = 0; i < a; i++) {
            for(int j = 1; j < b; j++) {
                dp[j] += dp[j-1];
                System.out.println(dp[j]);
            }
        }

//        System.out.println(dp[b - 1]);

    }

    static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }



}
