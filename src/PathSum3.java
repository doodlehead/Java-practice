import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum3 {
    //Basically do any tree traversal and keep track of the sums along the way
    //The order of traversal doesn't matter
    //Runtime: 30 ms
    //Memory usage: 39.7 MB
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int count = 0;
        LinkedList<Object[]> curr = new LinkedList<>();

        //(node, runningSums[])
        List<Integer> sums = new ArrayList<>();
        sums.add(root.val);
        curr.add(new Object[]{ root, sums });

        while (!curr.isEmpty()) {
            Object[] pair = curr.poll();
            TreeNode node = (TreeNode) pair[0];
            ArrayList<Integer> runningSums = (ArrayList) pair[1];
            //int rSum = (int) pair[1];

            for (int i = 0; i < runningSums.size(); i++) {
                if (runningSums.get(i) == sum) count++;
            }

            //if (rSum == sum) count++;

            if (node.right != null) {
                ArrayList<Integer> rSums = new ArrayList<>();
                for (int i: runningSums) {
                    rSums.add(i + node.right.val);
                }
                rSums.add(node.right.val);

                curr.add(new Object[]{ node.right, rSums });
            }
            if (node.left != null) {
                ArrayList<Integer> lSums = new ArrayList<>();
                for (int i: runningSums) {
                    lSums.add(i + node.left.val);
                }
                lSums.add(node.left.val);

                curr.add(new Object[]{ node.left, lSums });
            }
        }

        return count;
    }
}
