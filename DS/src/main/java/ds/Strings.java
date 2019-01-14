package ds;

import java.math.BigInteger;
import java.util.*;

public class Strings {
    public static void main(String[] args) {
//System.out.println(isValid("(])"));
//        isValid("0");
//        System.out.println(multiply("9999999999", "2"));
//      removeDuplicates(new int[]{4,90,23,1,5,8});
/*System.out.println(commonPrefix(new ArrayList<String>() {
    {
        add("aaaaa");
        add("aaaa");
        add("aa");
    }
}));*/


        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        int[] arra_old = new int[10];
        System.arraycopy(arr, 0, arra_old, 0, arr.length-1);




        arr = new int[arra_old.length * 2];

        System.arraycopy(arra_old, 0, arr, 0, arra_old.length-1);
        System.out.println(arr[4]);
        System.out.println(arr.length);

    }

    static String commonPrefix(List<String> strList) {
        if (strList.size() == 0) return "";
        String prefix = strList.get(0);
        for (int i = 1; i < strList.size(); i++)
            while (strList.get(i).indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;


    }

    static boolean isPalindrome(String str) {
        str = str.replaceAll("[^\\w\\s]", "");
        str = str.replaceAll(" ", "");
        str = str.toLowerCase().trim();

        int i;
        int j = str.length() - 1;
        for (i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            j--;
        }
        return true;


    }

    static boolean canPalindrome(String s) {
      /*  HashMap< Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;*/


        Set< Character > set = new HashSet< >();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;


    }

    static boolean isOneEditDistance(String s, String t) {
        if(s.length() - t.length() > 1) return false;
        if(s.length() == 0 && t.length() == 0) return false;


        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(set.contains(c) ) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }


        return set.size() == 1;

    }

    static String multiply(String A, String B) {
        Long a = Long.valueOf(A);
        Long b = Long.valueOf(B);

        Long c = a * b;

        return String.valueOf(c);
    }


    static String addBoldTag(String s, String[] dict) {
        //  boolean[] bold = new boolean[s.length()];
        // for (String d: dict) {
        //     for (int i = 0; i <= s.length() - d.length(); i++) {
        //         if (s.substring(i, i + d.length()).equals(d)) {
        //             for (int j = i; j < i + d.length(); j++)
        //                 bold[j] = true;
        //         }
        //     }
        // }
        // StringBuilder res = new StringBuilder();
        // for (int i = 0; i < s.length();) {
        //     if (bold[i]) {
        //         res.append("<b>");
        //         while (i < s.length() && bold[i])
        //             res.append(s.charAt(i++));
        //         res.append("</b>");
        //     } else
        //         res.append(s.charAt(i++));
        // }
        // return res.toString();
        StringBuilder sb = new StringBuilder();
        int lastLog = 0;
        int end = -1;

        for (int start = 0; start < s.length(); start++) {
            for (String d : dict) {
                if (s.startsWith(d, start)) {
                    end = Math.max(end, start + d.length());
                }
            }
            if (start == end) {
                sb.append("<b>").append(s.substring(lastLog, start)).append("</b>");
            }
            if (start >= end) {
                sb.append(s.charAt(start));
                lastLog = start + 1;
            }
        }
        if (end >= s.length()) {
            sb.append("<b>").append(s.substring(lastLog)).append("</b>");
        }
        return sb.toString();


    }


    static void removeDuplicates (int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int s: nums
             ) {
            set.add(s);
        }
System.out.println(set);
//        set.isEmpty();
//        Arrays.sort(nums);
//        List<Integer> lit = Arrays.asList(nums);
//        Collections.sort(set);
    }

    static boolean isValid(String s) {
        // string into char array

        Stack<Character> stack = new Stack<Character>();
        if(s.length() == 1) return false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                stack.pop();
            } else return false;
        }

        return  stack.isEmpty();

    }


    static String addBinary(String a, String b) {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Travers both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }

}
