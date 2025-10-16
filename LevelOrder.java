import java.util.*;

public class LevelOrder {

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    
    /**
     * Level Order Traversal (Breadth-First Search)
     * --------------------------------------------
     * Time Complexity: O(n)
     *  - Every node is visited exactly once.
     *
     * Space Complexity: O(n)
     *  - Uses a queue that stores nodes level by level.
     */
    public void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    /**
     * Level Order Traversal in Spiral (Zigzag) Form
     * ---------------------------------------------
     * Time Complexity: O(n)
     *  - Each node is processed once.
     *
     * Space Complexity: O(n)
     *  - Uses two stacks to alternate directions.
     */
    public void spiralLevelOrder(Node root) {
        if (root == null)
            return;

        Stack<Node> stack1 = new Stack<>(); // For left to right
        Stack<Node> stack2 = new Stack<>(); // For right to left

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // Print current level left-to-right
            while (!stack1.isEmpty()) {
                Node temp = stack1.pop();
                System.out.print(temp.val + " ");

                if (temp.left != null)
                    stack2.push(temp.left);
                if (temp.right != null)
                    stack2.push(temp.right);
            }

            // Print next level right-to-left
            while (!stack2.isEmpty()) {
                Node temp = stack2.pop();
                System.out.print(temp.val + " ");

                if (temp.right != null)
                    stack1.push(temp.right);
                if (temp.left != null)
                    stack1.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrder obj = new LevelOrder();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Level Order Traversal (BFS):");
        obj.levelOrder(root);

        System.out.println("\n\nLevel Order Traversal in Spiral (Zigzag) Form:");
        obj.spiralLevelOrder(root);
    }
}
