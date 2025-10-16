import java.util.*;

public class BinaryTree {

    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();

        Node root = obj.new Node(1);
        root.left = obj.new Node(2);
        root.right = obj.new Node(3);
        root.left.left = obj.new Node(4);
        root.left.right = obj.new Node(5);
        root.right.right = obj.new Node(6);

        System.out.println("Root: " + root.val);
        System.out.println("Root.left: " + root.left.val);
        System.out.println("Root.right: " + root.right.val);

        System.out.println("Root.left.left: " + root.left.left.val);
        System.out.println("Root.left.right: " + root.left.right.val);
        System.out.println("Root.right.right: " + root.right.right.val);

        if (root.right.left != null)
            System.out.println("Root.right.left: " + root.right.left.val);
        else
            System.out.println("Root.right.left: null");
    }
}

/*
 * Time Complexity: O(n)
 * ---------------------
 * - Each node creation (`new Node()`) takes O(1).
 * - There are n nodes created → O(n) total.
 * - Each print statement is O(1).
 * - Overall: O(n) for creating + printing n nodes.
 *
 * Space Complexity: O(n)
 * ----------------------
 * - Each Node stores an int value and two references (left, right).
 * - For n nodes, total space = O(n).
 * - No recursion or extra data structures → stack space O(1).
 */

