import java.util.*;

public class IterativePreorder {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative Preorder Traversal (Root → Left → Right)
     * --------------------------------------------------
     * Time Complexity: O(n)
     *  - Every node is pushed and popped once.
     * 
     * Space Complexity: O(n)
     *  - Stack stores up to n nodes in the worst case.
     *
     * Approach:
     *  1. Use a stack to simulate recursion.
     *  2. Push the root node first.
     *  3. While stack is not empty:
     *     - Pop top node and print its value.
     *     - Push right child first, then left child (so left is processed first).
     */
    
    public void preorderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.val + " ");

            // Push right first so left is processed first
            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public static void main(String[] args) {
        IterativePreorder obj = new IterativePreorder();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Iterative Preorder Traversal (Root → Left → Right):");
        obj.preorderIterative(root);
    }
}
