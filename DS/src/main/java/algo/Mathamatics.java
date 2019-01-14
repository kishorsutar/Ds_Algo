package algo;

import java.util.ArrayList;

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

}
