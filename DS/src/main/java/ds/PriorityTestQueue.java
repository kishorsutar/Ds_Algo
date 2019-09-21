package ds;


import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityTestQueue {

	public static void main(String[] args) {

		System.out.println(findKthSmallest(new int[]{3,2,1,5,6,4}, 6));
	}


	private static int findKthSmallest(int[] arr, int k) {

		if(arr.length < k) {
			throw new IllegalArgumentException("Invalid input");
		}

		PriorityQueue<Integer>  q = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int r: arr) {
			q.add(r);

			if(q.size() > k)
				q.poll();
		}

		return q.peek();

	}
}