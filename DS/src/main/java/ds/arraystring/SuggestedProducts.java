package ds.arraystring;

import java.util.*;

public class SuggestedProducts {

    public static void main(String[] args) {
        suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse");
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        List<String> productList = Arrays.asList(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }
        System.out.println(map.floorEntry(products[products.length - 1]));
        System.out.println(map.floorKey(products[products.length - 1]));

        String key = "";
        for (char c: searchWord.toCharArray()) {
            key += c;
            String ceiling = map.ceilingKey(key);
            System.out.println("ceiling " + ceiling);

            String floor = map.floorKey(key + "~");
            System.out.println("Floor " + floor);
            if (ceiling == null || floor == null) break;
            res.add(productList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));

        }

        while (res.size() < searchWord.length()) res.add(new ArrayList<>());

        for(List<String> strList : res) {
            for (String str : strList) {
            }
        }
        return res;
    }
}
