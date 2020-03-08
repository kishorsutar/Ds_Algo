package ds;


import java.util.*;

public class HashProblems {

    public static void main(String[] args) {
        HashProblems hashProblems = new HashProblems();
//        HashSet<String> uniqueSet = hashProblems.creatingAllCombinations(new String[]{"aaa", "aaa", "aaa"});

//        List<String> list = new ArrayList<>(Arrays.asList("aaa", "aaa", "aaa"));
//                System.out.println(hashProblems.findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", list));
                List<String> list = new ArrayList<>(Arrays.asList("cat", "ate", "bat"));
                System.out.println(hashProblems.findSubstring("catbatatecatatebat", list));
    }

    private HashMap<Integer, String> getIndexOfString(String input, HashSet<String> stringSet) {
        HashMap<Integer, String> stringMap = new HashMap<>();
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(chars[i]);
            for(int j = i+1; j < chars.length; j++) {
                stringBuilder.append(chars[j]);
                if(stringSet.contains(stringBuilder.toString())) {
                    stringMap.put(i, stringBuilder.toString());
                }
            }
        }

        for (Map.Entry<Integer, String> index:
             stringMap.entrySet()) {
            System.out.println(" " + index.getKey() + "  "+index.getValue());
        }

        return stringMap;
    }

    private HashSet<String> creatingAllCombinations(String[] strings) {
        HashSet<String> numberSet = new HashSet<>();
        for(int i = 0; i < strings.length; i++) {
            String outerS = strings[i];
            StringBuilder val = new StringBuilder();
            numberSet.add(outerS);
            val.append(outerS);
            for(int j = i+1; j < strings.length; j++) {
                String innerString = strings[j];
                val.append(innerString);
                numberSet.add(val.toString());
                int r = j + 1;
                while (r < strings.length-1) {
                    String t = strings[r];
                    val.append(t);
                    numberSet.add(val.toString());
                    r++;
                }
            }
        }

        for (String ip:
             numberSet) {
            System.out.println(ip);
        }

        return numberSet;
    }


    public ArrayList<Integer> findSubstring(String A, final List<String> B) {

        ArrayList<Integer> indices = new ArrayList<Integer>();
        if (B.size() == 0)
            return indices;

        int total = B.size(), wordLen = B.get(0).length();

        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String s: B) {
            if (words.containsKey(s))
                words.put(s, words.get(s) + 1);
            else
                words.put(s, 1);
        }
        for (int i = 0; i <= A.length() - total * wordLen; i ++) {

            HashMap<String, Integer> targetMap = new HashMap<>(words);

            for (int j = i; j <= A.length() - wordLen && !targetMap.isEmpty(); j += wordLen) {
                String sub = A.substring(j, j + wordLen);

                if (!targetMap.containsKey(sub))
                    break;
                else if (targetMap.get(sub) > 1)
                    targetMap.put(sub, targetMap.get(sub) - 1);
                else
                    targetMap.remove(sub);

            }

            if (targetMap.isEmpty())
                indices.add(i);
        }

        return indices;
    }
}
