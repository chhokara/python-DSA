package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class PriorityQueue<T extends Comparable<T>> {
    private final ArrayList<T> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T data) {
        heap.add(data);
        heapifyUp(heap.size() - 1);
    }

    public T removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue is empty!");
        }

        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heapifyDown(0);
        }

        return min;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority Queue is empty!");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);

            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void display() {
        System.out.println("Heap: " + heap);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert elements
        pq.insert(10);
        pq.insert(5);
        pq.insert(20);
        pq.insert(2);
        pq.insert(15);

        // Display the heap
        pq.display(); // Heap: [2, 5, 20, 10, 15]

        // Peek the minimum element
        System.out.println("Peek: " + pq.peek()); // Peek: 2

        // Remove minimum elements
        System.out.println("Remove Min: " + pq.removeMin()); // Remove Min: 2
        pq.display(); // Heap: [5, 10, 20, 15]

        System.out.println("Remove Min: " + pq.removeMin()); // Remove Min: 5
        pq.display(); // Heap: [10, 15, 20]

        // Size of the priority queue
        System.out.println("Size: " + pq.size()); // Size: 3
    }
}