public class MinHeap {
    int capacity;
    int heapSize;
    int[] heap;

    MinHeap(int c) {
        capacity = c;
        heapSize = 0;
        heap = new int[capacity];
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(5);
        h.insertKey(10);
        h.insertKey(12);
        h.insertKey(45);
        h.insertKey(0);
        h.insertKey(27);
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        h.deleteKey(2);
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    // method to remove min element from heap
    int extractMin() {
        if (heapSize <= 0)
            return -1;
        if (heapSize == 1) {
            heapSize--;
            return heap[0];
        }
        int root = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;
        minHeapify(0);
        return root;
    }

    void insertKey(int k) {
        if (heapSize == capacity) {
            System.out.println("Heap full");
            return;
        }
        int i = heapSize;
        heapSize++;
        heap[i] = k;
        while (i != 0 && heap[i] < heap[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void decreaseKey(int i, int newVal) {
        heap[i] = newVal;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && heap[l] < heap[i])
            smallest = l;
        if (r < heapSize && heap[r] < heap[i])
            smallest = r;
        if (smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }
}