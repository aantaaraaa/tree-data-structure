import java.util.*;

public class PreOrder {

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Preorder Traversal (Root → Left → Right)
     * ----------------------------------------
     * Time Complexity: O(n)
     *  - Each node is visited exactly once.
     *  - For n nodes, total work is linear → O(n).
     *
     * Space Complexity: O(h)
     *  - 'h' is the height of the tree.
     *  - In the worst case (skewed tree), recursion stack = O(n).
     *  - In the best case (balanced tree), stack height = O(log n).
     */
    public void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.val + " "); 
        preorder(root.left);             
        preorder(root.right);            
    }

    public static void main(String[] args) {
        PreOrder obj = new PreOrder();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Preorder Traversal (Root → Left → Right):");
        obj.preorder(root);
    }
}
