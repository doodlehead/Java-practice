import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    //TIL: PriorityQueues DO NOT ITERATE IN SORTED ORDER! AAAAAAAAAAAAAAAAAAAAAAAAAAa
    //Found that out the hard way trying to debug for an hour
    //Runtime: 3 ms
    //Memory usage: 39.6 MB
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //<xIndex, <depth, List of node values>>
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> om = new TreeMap<>();

        //[TreeNode, index]
        LinkedList<Object[]> curr = new LinkedList<>();
        curr.add(new Object[]{ root, 0 });
        LinkedList<Object[]> next = new LinkedList<>();
        int depth = 0;

        while (!curr.isEmpty()) {
            //Process all the values in curr
            while (!curr.isEmpty()) {
                Object[] pair = curr.poll();
                TreeNode node = (TreeNode)pair[0];
                int index = (int) pair[1];

                //Process current node
                //Check for xIndex
                if (om.containsKey(index)) {
                    //Add the node to the list
                    TreeMap<Integer, PriorityQueue<Integer>> innerMap = om.get(index);
                    //Check for depth
                    if (innerMap.containsKey(depth)) {
                        //Same xIndex and depth
                        PriorityQueue<Integer> innerQ = innerMap.get(depth);
                        //There will never be more than 2 items in this list
                        //Add the new value to it's sorted position
                        innerQ.add(node.val);
                    } else {
                        //New depth
                        PriorityQueue<Integer> queue = new PriorityQueue<>();
                        queue.add(node.val);
                        innerMap.put(depth, queue);
                    }
                } else {
                    //new xIndex
                    //<depth, node values>
                    TreeMap<Integer, PriorityQueue<Integer>> tm = new TreeMap<>();
                    //Automatically new depth
                    PriorityQueue<Integer> queue = new PriorityQueue<>();
                    queue.add(node.val);

                    tm.put(depth, queue);
                    om.put(index, tm);
                }

                //Add child nodes
                if (node.left != null) {
                    next.add(new Object[]{ node.left, index - 1 });
                }
                if (node.right != null) {
                    next.add(new Object[]{ node.right, index + 1 });
                }
            }

            curr = next;
            next = new LinkedList<>();
            depth++;
        }

        //Process the results into the desired format
        List<List<Integer>> res = new LinkedList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry: om.entrySet()) {
            //Each iteration we are dealing with all the same xIndex
            //<depth, node values>
            TreeMap<Integer, PriorityQueue<Integer>> tm = entry.getValue();
            LinkedList<Integer> sublist = new LinkedList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> e: tm.entrySet()) {
                PriorityQueue<Integer> q = e.getValue();

                while(!q.isEmpty()) {
                    sublist.add(q.poll());
                }
            }
            res.add(sublist);
        }

        return res;
    }
}
