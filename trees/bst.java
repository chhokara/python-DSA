package trees;

class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (data.compareTo(root.data) == 0) {
            return true;
        } else if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> root, T data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private T findMin(Node<T> root) {
        T min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // In-order traversal
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal(); // Output: 20 30 40 50 60 70 80

        // Search elements
        System.out.println("Search 40: " + bst.search(40)); // Output: true
        System.out.println("Search 90: " + bst.search(90)); // Output: false

        // Delete an element
        bst.delete(30);
        System.out.print("After deleting 30, In-order Traversal: ");
        bst.inOrderTraversal(); // Output: 20 40 50 60 70 80

        // Generic Example with Strings
        BinarySearchTree<String> stringBst = new BinarySearchTree<>();
        stringBst.insert("Banana");
        stringBst.insert("Apple");
        stringBst.insert("Cherry");
        System.out.print("String In-order Traversal: ");
        stringBst.inOrderTraversal(); // Output: Apple Banana Cherry
    }
}
