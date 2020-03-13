package ds;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {

    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    /**
     * This will initialize our heap with default size.
     */
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);

    }

    /**
     * This will check if the heap is empty or not
     * Complexity: O(1)
     */
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * This will check if the heap is full or not
     * Complexity: O(1)
     */
    public boolean isFull() {
        return heapSize == heap.length;
    }


    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /**
     * This will insert new element in to heap
     * Complexity: O(log N)
     * As worst case scenario, we need to traverse till the root
     */
    public void insert(int x) {
        if (isFull())
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    /**
     * This will delete element at index x
     * Complexity: O(log N)
     */
    public int delete(int x) {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty, No element to delete");
        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(x);
        return key;
    }

    /**
     * This method used to maintain the heap property while inserting an element.
     */
    private void heapifyUp(int i) {
        int temp = heap[i];
        while (i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }

    /**
     * This method used to maintain the heap property while deleting an element.
     */
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp < heap[child]) {
                heap[i] = heap[child];
            } else break;
            i = child;
        }
        heap[i] = temp;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    /**
     * This method used to print all element of the heap
     */
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /**
     * This method returns the max element of the heap.
     * complexity: O(1)
     */
    public int findMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public static void main(String[] args) {
        MinHeap maxHeap = new MinHeap();
        maxHeap.add(10);
        maxHeap.add(4);
        maxHeap.add(9);
        maxHeap.add(1);
        maxHeap.add(7);
        maxHeap.add(5);
        maxHeap.add(3);

        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());

    }
}

// array based min heap
class MinHeap {

    private int capacity = 10;
    private int size = 0;

    private int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex -1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }


    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    private void ensureExtraCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }


    private void heapifyDown() {
        int value = items[size -1];
        int index = 0;
        while((value <= items[leftChild(index)]) && (value <= items[rightChild(index)])) {
            if(value >= items[leftChild(index)]) {
                swap(getLeftChildIndex(index), index);
                index = getLeftChildIndex(index);
            } else if (value >= items[rightChild(index)]) {
                swap(getRightChildIndex(index), index);
                index = getRightChildIndex(index);
            }
        }
    }
}