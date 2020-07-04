import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    //V1. Can I improve it?
    //Runtime: 1 ms
    //Memory usage: 39.9 MB
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        //Do a breadth-first traversal. Stack based
        int maxDepth = 0;
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> alt = new LinkedList<>();
        current.push(root);

        while (!current.isEmpty()) {
            for (TreeNode node: current) {
                if (node.left != null) alt.push(node.left);
                if (node.right != null) alt.push(node.right);
            }
            current = alt;
            alt = new LinkedList<TreeNode>();
            maxDepth++;
        }
        return maxDepth;
    }
}

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}