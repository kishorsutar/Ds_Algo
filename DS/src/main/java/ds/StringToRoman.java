package ds;


import java.util.HashMap;
import java.util.Map;

public class StringToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(36));
    }

    private static String intToRoman(int num) {
        Map<Integer, String> map = createMap();
        StringBuilder sb = new StringBuilder();
        int level = 1000;
        while (num > 0) {
            int val = num / level;
            if (val > 0) {
                if (val == 4 || val == 5 || val == 9) {
                    sb.append(map.get(val * level));
                } else {
                    if (val > 5) {
                        sb.append(map.get(5 * level));
                        val -= 5;
                    }
                    while (val > 0) {
                        sb.append(map.get(level));
                        val--;
                    }
                }
            }
            num %= level;
            level /= 10;
        }
        return sb.toString();
    }

    private static Map<Integer, String> createMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }
}
