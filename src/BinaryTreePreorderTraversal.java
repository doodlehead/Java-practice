import java.util.*;

//parent -> left -> right
public class BinaryTreePreorderTraversal {
    //Runtime: 1 ms
    //Memory usage: 37.8 MB
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();

        ArrayList<Integer> traversal = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        stack.push(root);

        //Preorder is easy, it only ever goes down
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            traversal.add(curr.val);
            visited.add(curr);

            if (curr.right != null && !visited.contains(curr.right)) {
                stack.push(curr.right);
            }
            if (curr.left != null && !visited.contains(curr.left)) {
                stack.push(curr.left);
            }
        }
        return traversal;
    }
}
