import java.util.*;

public class IterativeInorder {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative Inorder Traversal (Left → Root → Right)
     * -------------------------------------------------
     * Time Complexity: O(n)
     *  - Each node is visited exactly once.
     *
     * Space Complexity: O(n)
     *  - Stack stores up to n nodes in the worst case (for skewed tree).
     *
     * Approach:
     *  1. Use a stack to simulate recursion.
     *  2. Start from the root node.
     *  3. Push all left children to the stack until null.
     *  4. Pop from stack, print node value, then go to its right child.
     */
    public void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Step 1: Traverse all left nodes
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: Pop from stack and print value
            current = stack.pop();
            System.out.print(current.val + " ");

            // Step 3: Visit right subtree
            current = current.right;
        }
    }

    public static void main(String[] args) {
        IterativeInorder obj = new IterativeInorder();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Iterative Inorder Traversal (Left → Root → Right):");
        obj.inorderIterative(root);
    }
}
