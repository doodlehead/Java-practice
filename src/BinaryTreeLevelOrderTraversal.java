import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    //Each level is a list.
    //Runtime: 1 ms
    //Memory: 39.2 MB
    public List<List<Integer>> levelOrder(TreeNode root) {
       if (root == null) return new LinkedList<>();

       List<List<Integer>> res = new LinkedList<>();
       List<TreeNode> curr = new LinkedList<>();
       List<TreeNode> next = new LinkedList<>();

       curr.add(root);

       while (!curr.isEmpty()) {
           List<Integer> currLevel = new ArrayList<>();

           for (TreeNode node: curr) {
               currLevel.add(node.val);
               if (node.left != null) next.add(node.left);
               if (node.right != null) next.add(node.right);
           }

           res.add(currLevel);
           curr = next;
           next = new LinkedList<>();
       }
       return res;
    }
}
