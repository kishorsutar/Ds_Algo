package algo;

import java.util.Arrays;

public class VersionNumber {
    public static void main(String[] args) {
        System.out.println("Hello World!" + compareVersion("1.0", "0.1"));
    }

    static int compareVersion(String version1, String version2) {

        String[] v1Arr = new String[]{"0", "0", "0", "0"};

        String[] temp1 = version1.split("\\.");

        String[] v2Arr = version2.split("\\.");

        v1Arr = Arrays.copyOf(temp1, v1Arr.length);
        for (int i = 0; i < v1Arr.length; i++)
        System.out.println(v1Arr[i]);

        return 0;
    }
}
