import java.util.*;

public class AllTraversals {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Recursive Inorder Traversal (Left → Root → Right)
     * -------------------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(h) [Recursion stack]
     */
    public void inorderRecursive(Node root) {
        if (root == null) return;
        inorderRecursive(root.left);
        System.out.print(root.val + " ");
        inorderRecursive(root.right);
    }

    /**
     * Iterative Inorder Traversal using Stack
     * ---------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    /**
     * Recursive Preorder Traversal (Root → Left → Right)
     * --------------------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void preorderRecursive(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    /**
     * Iterative Preorder Traversal using Stack
     * ----------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void preorderIterative(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");

            // Push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    /**
     * Recursive Postorder Traversal (Left → Right → Root)
     * ---------------------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public void postorderRecursive(Node root) {
        if (root == null) return;
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * Iterative Postorder Traversal using Two Stacks
     * ----------------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void postorderTwoStacks(Node root) {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    /**
     * Iterative Postorder Traversal using One Stack
     * ---------------------------------------------
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void postorderOneStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    System.out.print(peekNode.val + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        AllTraversals obj = new AllTraversals();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Inorder (Recursive):");
        obj.inorderRecursive(root);
        System.out.println("\nInorder (Iterative):");
        obj.inorderIterative(root);

        System.out.println("\n\nPreorder (Recursive):");
        obj.preorderRecursive(root);
        System.out.println("\nPreorder (Iterative):");
        obj.preorderIterative(root);

        System.out.println("\n\nPostorder (Recursive):");
        obj.postorderRecursive(root);
        System.out.println("\nPostorder (Two Stacks):");
        obj.postorderTwoStacks(root);
        System.out.println("\nPostorder (One Stack):");
        obj.postorderOneStack(root);
    }
}
