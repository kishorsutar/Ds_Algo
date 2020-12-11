package ds;

import java.util.*;

class PQ {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("i", 3);
        map.put("love", 5);
        map.put("you", 3000);
        int k = 4;
        List<String> result = new ArrayList<>();

        String[] words = new String[]{"I", "love", "you", "Love", "Love"};
        for (int i = 0; i < words.length; i++) {

            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }


        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        //return result;
    }


    static void BSTIterator() {

        Deque<Integer> test = new ArrayDeque<>();

    }

    void checkPriorityComparator() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1, i2)
        );

        PriorityQueue<Map.Entry<String, Integer>> priority = new PriorityQueue<>(
                (m1, m2) -> m1.getValue().equals(m2.getValue()) ? m2.getValue().compareTo(m1.getValue())
                        : m1.getValue().compareTo(m2.getValue())
        );


    }

}