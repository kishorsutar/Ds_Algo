package ds;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTestQueue {

	public static void main(String[] args) {

//		System.out.println(findKthSmallest(new int[]{3,2,1,5,6,4}, 6));
		System.out.println(maxSum(new int[]{-2, 0, 5, -1, 2}, 4));
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


	private static boolean isMinHeap(int[] heap) {
		int root = heap[0];
		int n = heap.length;

		for(int i = 1; i < n; i++) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;

			if(left < n && heap[left] < root) {
				return false;
			} else if (right < n && heap[right] < root) {
				return false;
			}
			root = heap[i];
		}

		return true;
	}

	private static int maxSum(int[] array, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i:
			 array) {
			pq.add(i);
		}

		while (k > 0 && pq.size() > 0) {
			int temp = pq.poll();

			temp *= -1;

			pq.add(temp);
			k--;
		}

		int sum = 0;
		for (int s:
			 pq) {
			sum += s;
		}

		return sum;

	}
}