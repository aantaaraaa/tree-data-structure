import java.util.*;

public class PostOrder {

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Postorder Traversal (Left → Right → Root)
     * -----------------------------------------
     * Time Complexity: O(n)
     *  - Each node is visited exactly once.
     *  - For n nodes, total work is linear → O(n).
     *
     * Space Complexity: O(h)
     *  - 'h' is the height of the tree.
     *  - In the worst case (skewed tree), recursion stack = O(n).
     *  - In the best case (balanced tree), stack height = O(log n).
     */
    public void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);    
        postorder(root.right);    
        System.out.print(root.val + " "); 
    }

    public static void main(String[] args) {
        PostOrder obj = new PostOrder();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.left = obj.new Node(6);
        root.right.right = obj.new Node(7);

        System.out.println("Postorder Traversal (Left → Right → Root):");
        obj.postorder(root);
    }
}
