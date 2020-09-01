import java.security.cert.CRLReason;

public class DeleteNodeInABST {

    //Basically tree re-balancing
    //V1: I'm sorry for writing this unreadable atrocity
    //Runtime: 0 ms
    //Memory usage: 40 MB
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        TreeNode ret = root;

        TreeNode parent = null;
        boolean isLeftChild = true;
        TreeNode toRemove = null;

        //Find the node to remove
        if (root.val == key) {
            //If the root is removed
            toRemove = root;
        } else {
            TreeNode curr = root;

            while (curr != null) {
                if (curr.val == key) {
                    toRemove = curr;
                    break;
                } else if (curr.val < key) {
                    //right side
                    parent = curr;
                    curr = curr.right;
                    isLeftChild = false;
                } else {
                    //left side
                    parent = curr;
                    curr = curr.left;
                    isLeftChild = true;
                }
            }
        }

        //The node is not found
        if (toRemove == null) {
            return root;
        }

        TreeNode r = null;
        TreeNode rParent = null;

        //Find the replacement node
        if (toRemove.left != null) {
            //Find the right-most child
            TreeNode curr = toRemove.left;

            while (curr != null) {
                if (curr.right != null) {
                    rParent = curr;
                    curr = curr.right;
                } else {
                    //Reached the end
                    r = curr;
                    break;
                }
            }

            //Replace the value
            toRemove.val = r.val;

            //Remove the replacement node + reconnect the children
            if (rParent != null) {
                rParent.right = r.left;
            } else {
                //Never iterated past the initial left child
                toRemove.left = r.left;
            }

            return root;
        } else if (toRemove.right != null) {
            //Find the left-most child
            TreeNode curr = toRemove.right;

            while (curr != null) {
                if (curr.left != null) {
                    rParent = curr;
                    curr = curr.left;
                } else {
                    //Reached the end
                    r = curr;
                    break;
                }
            }

            //Replace the value
            toRemove.val = r.val;

            //Remove the replacement node + reconnect the children
            if (rParent != null) {
                rParent.left = r.right;
            } else {
                //Never iterated past the initial right child
                toRemove.right = r.right;
            }

            return root;
        } else {
            //Node to remove has no children
            if (parent != null) {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return root;
            } else {
                //You're removing the root and the only node
                return null;
            }
        }
    }

}
