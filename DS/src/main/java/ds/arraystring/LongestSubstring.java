package ds.arraystring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        // iterate through each character in the string  lakfijleofjnleodnleo
        // create stringBuilderclass and start appending the characters
        // before appending the character, check wheather its already there...
        // if its there get the count. start from next position O(n^2)
        // at the end check the size of string builder and return

        int n = s.length();

         Set<Character> set = new HashSet<Character>();
         int ans = 0, i = 0, j = 0;

         while (i < n && j < n) {
             if(!set.contains(s.charAt(j))) {
                 set.add(s.charAt(j++));
                 ans = Math.max(ans, j-i);
             } else {
                 set.remove(s.charAt(i++));
             }
         }

         return ans;

//        int n = s.length();
//        int max = 0;
//        if (n == 0) return max;
//
//        Set<Character> set = new HashSet<Character>();
//
//        for (int i = 0; i < n; i++) {
//            if(set.contains(s.charAt(i))) {
//                max = Math.max(max, set.size());
//                set.clear();
//                set.add(s.charAt(i));
//            } else {
//                set.add(s.charAt(i));
//
//            }
//        }
//        return Math.max(max, set.size());


    }
}
