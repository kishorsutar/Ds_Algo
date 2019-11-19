package ds;

public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int len = 0;  // length user think array is
    private int capacity = 0; // actual array size.

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);

        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    // O(1)
    public int size() {
        return len;
    }

    // O(1)
    public T get(int index) {
        return array[index];
    }

    //O(1)
    public boolean isEmpty() {
        return size() == 0;
    }

    // O(n)
    public void removeAll() {
        for (int i = 0; i < len; i++) {
            array[i] = null;
        }
        len = 0;
    }

    // O(1)
    public void set(int index, T elem) {
        array[index] = elem;
    }


    // O(n)
    public void add(T elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2; // double the size
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[len++] = elem;

    }

    // O(n)
    public T removeAt(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        T data = array[index];
        T[] newArray = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (index == i) {
                j--;
            } else {
                newArray[j] = array[i];
            }
        }
        array = newArray;
        capacity = --len;
        return data;

    }

    // O(n)
    public boolean remove(T b) {
        int index = indexOf(b);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    // O(n)
    public int indexOf(T obj) {
        for (int i = 0; i < len; i++) {
            if (obj.equals(array[i])) return i;
        }
        return -1;
    }

    // O(n)
    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            return sb.append(array[len - 1]).append("]").toString();
        }

    }
}

