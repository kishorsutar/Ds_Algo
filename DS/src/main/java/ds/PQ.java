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
	for(int i = 0; i < words.length; i++) {

		if(map.containsKey(words[i])) {
			map.put(words[i], map.get(words[i]) + 1);
		} else {
			map.put(words[i], 1);
		}
	}

	PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
		(a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey())
		: a.getValue() - b.getValue()
		);

	for(Map.Entry<String, Integer> entry: map.entrySet()){
		pq.offer(entry);
		if(pq.size() > k) {
			pq.poll();
		}
	}

	  while(!pq.isEmpty()) {
		result.add(pq.poll().getKey());
	  }

	  //return result;
	 }
	
	
}