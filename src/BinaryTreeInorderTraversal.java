import java.util.*;

//left -> parent -> right
public class BinaryTreeInorderTraversal {
    //Iterative solution
    //Runtime: 2ms
    //Memory usage: 37.6 MB
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        stack.push(root);

        LinkedList<Integer> traversal = new LinkedList<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left != null && !visited.contains(curr.left)) {
                //visit left subtree
                stack.push(curr.left);
            } else if (!visited.contains(curr)) {
                //Visit current
                visited.add(curr);
                traversal.add(curr.val);

                //Visit right subtree right after
                if (curr.right != null && !visited.contains(curr.right)) {
                    stack.push(curr.right);
                }
            } else if ((curr.left == null || visited.contains(curr.left))
                && (curr.right == null || visited.contains(curr.right))) {
                //Reached a leaf node, or done with the current subtree
                visited.add(curr);
                stack.pop();
            }
        }
        return traversal;
    }
}
