import java.util.Stack;

public class SumOfLeftLeaves {
    //Runtime: 1 ms
    //Memory usage: 37.5 MB
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null || (root.left == null && root.right == null)) return sum;

        TreeNode curr = root;
        Stack<Object[]> stack = new Stack<>(); //Who needs classes lol
        stack.push(new Object[]{ root, false });
        TreeNode temp;

        while (!stack.isEmpty()) {
            Object[] pair = stack.pop();
            TreeNode node = (TreeNode) pair[0];
            boolean isLeft = (boolean) pair[1];

            if (node.left != null) {
                stack.push(new Object[]{ node.left, true });
            }
            if (node.right != null) {
                stack.push(new Object[]{ node.right, false });
            }
            if (node.left == null && node.right == null && isLeft) {
                sum += node.val;
            }
        }
        return sum;
    }
}
