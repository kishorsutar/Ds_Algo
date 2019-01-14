package math;

import java.util.ArrayList;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,8));
        System.out.println(uniqueWithRecurssion(2,8));
    }
    static int uniquePaths(int A, int B) {
        int[] dp = new int[B];
        dp[0] = 1;

        for(int i = 0; i < A; i++) {
            for(int j = 1; j < B; j++) {
                dp[j] += dp[j-1];
            }
        }

        return dp[B-1];
    }

    static int uniqueWithRecurssion(int a, int b) {
          /* If either 1 row or 1 column are there then the only way to end
	         is to traverse through that row or column respectively.*/
        if(a==1 || b==1)
            return 1;
	      /*If there are more than one row and column then u need to move
	        either right or down reducing one row or one column respectively
	        and adding that way in answer*/
        else{
            int ans = 0;
            ans = uniquePaths(a-1,b)+uniquePaths(a,b-1);
            return ans;
        }
    }


    // prime sum

    public static ArrayList<Integer> primesum(int n) {

        ArrayList<Integer> primeList = new ArrayList<Integer>();
        // Generating primes using Sieve
        boolean isPrime[]=new boolean[n + 1];
        SieveOfEratosthenes(n, isPrime);

        // Traversing all numbers to find first
        // pair
        for (int i = 0; i < n; i++)
        {
            if (isPrime[i] && isPrime[n - i])
            {
                primeList.add(i);
                primeList.add(n-i);
                break;
            }
        }
        return primeList;
    }


    // Generate all prime numbers less than n.
   static boolean SieveOfEratosthenes(int n, boolean isPrime[])
    {
        // Initialize all entries of boolean
        // array as true. A value in isPrime[i]
        // will finally be false if i is Not a
        // prime, else true bool isPrime[n+1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            // If isPrime[p] is not changed,
            // then it is a prime
            if (isPrime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }



}
