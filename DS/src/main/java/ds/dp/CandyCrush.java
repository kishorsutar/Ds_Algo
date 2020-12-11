package ds;

import java.util.*;

class CandyCrush {

    public static void main() {


    }

    // aaabbbacd
    private static String candyCrash(String input) {
        Stack<int[]> stack = new Stack<>();
        int[] first = new int[]{input.charAt(0), 1};

        stack.push(first);

        for (int i = 1; i < input.length(); i++) {
            if (!stack.isEmpty()) {

                int[] item = stack.peek();
                if (input.charAt(i) == item[0] && item[1] < 2) {
                    item[1]++;

                } else if (item[1] >= 2) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{input.charAt(i), 1});
            }

        }
        StringBuilder builder = new StringBuilder();
        for (int[] v : stack) {
            builder.append((char) (v[0]));
        }

        return builder.toString();
    }
}