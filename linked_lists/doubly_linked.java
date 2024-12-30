package linked_lists;

class DoublyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }

        T removedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return removedData;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }

        T removedData = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return removedData;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        Node<T> current = head;
        System.out.print("List (forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        Node<T> current = tail;
        System.out.print("List (backward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        list.displayForward();
        list.displayBackward();

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());

        list.displayForward();
        System.out.println("Size: " + list.getSize());
    }

}
