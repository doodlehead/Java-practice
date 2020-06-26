import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList {
    //V1 - Only one iteration, uses an ArrayList of pointers
    //Runtime: 1ms
    //Memory Usage: 37.9 MB
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;

        ListNode curr = head.next;
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(head);

        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        if (list.size() - n == 0) {
            //remove the head
            return list.get(1);
        } else {
            list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
            return head;
        }
    }
}
