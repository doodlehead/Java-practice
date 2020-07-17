public class SymmetricTree {
    //Recursive solution
    //Runtime: 0 ms
    //Memory usage: 38 MB
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;

        return isMirrored(root.left, root.right);
    }

    public boolean isMirrored(TreeNode a, TreeNode b) {
        if ((a == null && b != null) || (b == null && a != null)) {
            return false;
        } else if (a == null && b == null) {
            return true;
        } else {
            if (a.val != b.val) {
                return false;
            }
            return isMirrored(a.left, b.right) && isMirrored(a.right, b.left);
        }
    }
}
