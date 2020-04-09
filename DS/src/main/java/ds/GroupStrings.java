package ds;

import java.util.*;

public class GroupStrings {

    static List<ArrayList<String>> groupStrings(String[] strings) {
        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String s: strings) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int diff = arr[i] - 97;
                if (arr[i] - diff < 97 ) {
                    arr[i] = (char) (arr[i] - diff + 26);
                } else {
                    arr[i] = (char) (arr[i] - diff);
                }
            }

            String ns = new String(arr);
            if (map.containsKey(ns)) {
                map.get(ns).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                // map.put(ns, new ArrayList<String>(s));
                map.put(ns, list);

            }

        }
        for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        result.addAll(map.values());
        return result;
    }
}
