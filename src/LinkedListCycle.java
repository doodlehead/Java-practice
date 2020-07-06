import java.util.HashSet;

public class LinkedListCycle {
    //V1: Using O(n) memory
    //Runtime: 8 ms
    //Memory usage: 43.4 MB
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        HashSet<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {
            if (visited.contains(curr)) return true;
            else visited.add(curr);

            curr = curr.next;
        }
        return false;
    }
}
