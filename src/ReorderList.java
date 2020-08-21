import java.util.ArrayList;

public class ReorderList {
    //Not allowed to modify node values, only change references
    //Runtime: 2 ms
    //Memory usage: 41.8 MB
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode curr = head;
        ArrayList<ListNode> nodes = new ArrayList<>();

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        ListNode prev = nodes.get(0); //First element never moves
        int len = nodes.size();
        for (int i = 1; i < len; i++) {
            int x = i/2;

            if (i % 2 == 1) {
                //odd: n, n-1, n-2, ...
                prev.next = nodes.get(len-1-x);
                prev = nodes.get(len-1-x);
            } else {
                //even: 0, 1, 2, ...
                prev.next = nodes.get(x);
                prev = nodes.get(x);
            }
        }
        prev.next = null; //eliminate cycle
    }
}
