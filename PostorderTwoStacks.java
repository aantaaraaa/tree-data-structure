import java.util.*;

public class PostorderTwoStacks {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative Postorder Traversal using Two Stacks
     * ----------------------------------------------
     * Time Complexity: O(n)
     *  - Each node is pushed and popped exactly once.
     *
     * Space Complexity: O(n)
     *  - Two stacks are used, storing up to n nodes in total.
     *
     * Approach:
     *  1. Use two stacks: s1 (main stack), s2 (to store postorder result).
     *  2. Push root to s1.
     *  3. Pop from s1, push into s2.
     *     - Push left and right children of popped node into s1.
     *  4. After s1 is empty, pop from s2 and print (postorder sequence).
     */
    public void postorderTwoStacks(Node root) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node curr = s1.pop();
            s2.push(curr);

            if (curr.left != null)
                s1.push(curr.left);
            if (curr.right != null)
                s1.push(curr.right);
        }

        // s2 now contains nodes in reverse postorder
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        PostorderTwoStacks obj = new PostorderTwoStacks();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Postorder Traversal (Using Two Stacks):");
        obj.postorderTwoStacks(root);
    }
}
