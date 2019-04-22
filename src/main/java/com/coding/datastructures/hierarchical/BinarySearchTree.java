package com.coding.datastructures.hierarchical;

public class BinarySearchTree {
    static Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }

        return head;
    }

    public static Node<Integer> lookup(Node<Integer> head, int data) {
        if (head == null) {
            return null;
        }
        if (head.getData() == data) {
            return head;
        }

        if (data <= head.getData()) {
            return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }

    public static int minimumValue(Node<Integer> head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        if (head.getLeftChild() == null) {
            return head.getData();
        }

        return minimumValue(head.getLeftChild());
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }

        int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
        int rightMaxDepth = 1 + maxDepth(root.getRightChild());

        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static void mirror(Node<Integer> root) {
        if (root == null) {
            return;
        }

        mirror(root.getLeftChild());
        mirror(root.getRightChild());

        // Swap the left and the right child of each node.
        Node<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    public static void printRange(Node<Integer> root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low <= root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }

        if (low <= root.getData() && root.getData() <= high) {
            System.out.println(root.getData());
        }

        if (high > root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }

    public static boolean isBinarySearchTree(Node<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.getData() <= min || root.getData() > max) {
            return false;
        }

        return isBinarySearchTree(root.getLeftChild(), min, root.getData())
                && isBinarySearchTree(root.getRightChild(), root.getData(), max);
    }

    public static int countTrees(int numNodes) {
        if (numNodes <= 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= numNodes; i++) {
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - i);

            sum = sum + (countLeftTrees * countRightTrees);
        }

        return sum;
    }

    public static Node LCA(Node<Integer> root, int n1, int n2)
    {
        if (root == null)
            return null;
        if (root.getData() == n1 || root.getData() == n2)
            return root;

        Node left = LCA(root.getLeftChild(), n1, n2);
        Node right = LCA(root.getRightChild(), n1, n2);

        if (left != null && right != null)
            return root;
        if (left != null)
            return LCA(root.getLeftChild(), n1, n2);
        else
            return LCA(root.getRightChild(), n1, n2);
    }

    // Returns level of key k if it is present in
    // tree, otherwise returns -1
    public static int findLevel(Node root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.getData() == Integer.valueOf(a))
            return level;
        int left = findLevel(root.getLeftChild(), a, level + 1);
        if (left == -1)
            return findLevel(root.getRightChild(), a, level + 1);
        return left;
    }

    public static int findDistance(Node root, int a, int b)
    {
        Node lca = LCA(root, a, b);

        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }

    public static void print(Node node) {
        if (node == null) {
            System.out.print("Not found!");
            return;
        }
        System.out.println(node.getData() + " found!");
    }

    public static void main(String[] args) {
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insert(null, five);

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        BinaryTreeOrderTraversals.inOrder(head);
        print(lookup(head, 7));
        print(lookup(head, 12));

        System.out.println("Minimum value: " + minimumValue(head));
        System.out.println("Max Depth: " + maxDepth(one));

        System.out.println("Original");
        BinaryTreeBreadthFirstTraversal.breadthFirst(three);
        mirror(three);
        System.out.println();
        System.out.println("Mirror");
        BinaryTreeBreadthFirstTraversal.breadthFirst(three);

        printRange(head, 2, 9);

        System.out.println("Is BST: " + isBinarySearchTree(head, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("Tree count for 6 nodes: " + countTrees(6));
    }
}
