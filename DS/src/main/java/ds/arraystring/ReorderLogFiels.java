package ds.arraystring;

import java.util.Arrays;

public class ReorderLogFiels {

    public static void main(String[] args) {
        reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
    }

    static String[] reorderLogFiles(String[] logs) {

        String[] result = new String[logs.length];
        int k = 0;
        for (String s : logs) {

            String[] spaceSepratedArray = s.split(" ");
            String[] subList = new String[spaceSepratedArray.length - 1];
            String key = spaceSepratedArray[0];

            for (int i = 1; i < spaceSepratedArray.length -  1; i++) {
                subList[i] = spaceSepratedArray[i];
            }
            if (spaceSepratedArray[1].matches("[a-z]+")) {
                Arrays.sort(subList);
            }
            StringBuilder builder = new StringBuilder();
            builder.append(key);
            for (int j = 0; j < subList.length - 1; j++) {
                builder.append(subList[j]);
            }
            result[k++] = builder.toString();
        }

        return result;
    }
}
