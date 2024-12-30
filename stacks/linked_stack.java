package stacks;

class LinkedStack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        T poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node<T> current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println("Size: " + stack.getSize());
    }
}