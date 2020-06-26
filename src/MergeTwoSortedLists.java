
//Runtime: 0ms
//Memory Usage: 39 MB
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res;

        //Create the base case
        if (l1.val < l2.val) {
            res = new ListNode(l1.val);
            p1 = p1.next;
        } else {
            res = new ListNode(l2.val);
            p2 = p2.next;
        }
        ListNode r1 = res;

        while (p1 != null || p2 != null) {
            if (p1 == null) {
                //add p2, advance the pointer
                r1.next = new ListNode(p2.val);
                p2 = p2.next;
            } else if (p2 == null) {
                //add p1, advance the pointer
                r1.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                if (p1.val < p2.val) {
                    r1.next = new ListNode(p1.val);
                    p1 = p1.next;
                } else {
                    r1.next = new ListNode(p2.val);
                    p2 = p2.next;
                }
            }
            r1 = r1.next;
        }
        return res;
    }
}
