package math;

import java.util.ArrayList;

public class StirngSOl {

    public static void main(String[] args) {
        System.out.println(returnCount("bbbbbbbbb"));
    }

    //abaaba
    public static int returnCount(String str) {
        int[] alpha = new int[2];
        String[] split = str.split("b+");
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 97) {
                alpha[0] += 1;
            } else {
                alpha[1] += 1;
            }
        }
        int val = 0;
        if (alpha[0] == 0) {
            return str.length()/3 * 2;
        }
        val = alpha[0]/3;

        ArrayList<String> set = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
                int j = i + 1;
                while (sb.length() < val || j < str.length()) {
                    sb.append(str.charAt(j++));
                }
                set.add(sb.toString());

            }

        return set.size();
    }
}
