package quiz_bkp.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTree {

    static final int COUNT = 10;

    private static Node toBinaryTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            Node node = queue.poll();

            if (i < nums.length && nums[i] != null) {
                node.left = new Node(nums[i++]);
                queue.add(node.left);
            }

            if (i < nums.length && nums[i] != null) {
                node.right = new Node(nums[i++]);
                queue.add(node.right);
            }
        }

        return root;
    }

    private static Node arrayToTree(Integer[] nums) {

        Node root = new Node(nums[0]);

        for (int i = 1; i < nums.length; i++) {

        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, 18, 5, null, 15};
        Node root = toBinaryTree(nums);
        System.out.println("root = " + root);
        print2D(root);
    }

    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    static class Node {

        public int value;
        public Node left = null;
        public Node right = null;

        Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
