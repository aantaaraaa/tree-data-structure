import java.util.*;

public class PostorderOneStack {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative Postorder Traversal using One Stack
     * ---------------------------------------------
     * Time Complexity: O(n)
     *  - Each node is visited once.
     *
     * Space Complexity: O(n)
     *  - One stack used; worst case (skewed tree) → O(n).
     *
     * Approach:
     *  1. Push nodes while going left, keep track of right child.
     *  2. When reaching null, peek top of stack:
     *     - If it has an unvisited right child, move to right.
     *     - Else, pop and print it.
     */
    public void postorderOneStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            // Go as far left as possible
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node peekNode = stack.peek();

                // If right child exists and not visited yet, move right
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
        PostorderOneStack obj = new PostorderOneStack();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Postorder Traversal (Using One Stack):");
        obj.postorderOneStack(root);
    }
}
