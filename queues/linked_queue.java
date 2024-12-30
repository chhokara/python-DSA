package queues;

class LinkedQueue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        T dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return dequeuedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node<T> current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        System.out.println("Size: " + queue.getSize());
    }
}
