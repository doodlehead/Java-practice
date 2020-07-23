public class SortList {
    //V1: quick sort
    //Runtime: 594 ms
    //Memory usage: 49.2 MB
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;

        return quickSort(head);
    }

    public ListNode quickSort(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;
        else if (head.next.next == null) {
            //Length of 2
            if (head.val < head.next.val) {
                return head;
            } else {
                ListNode newHead = head.next;
                newHead.next = head;
                head.next = null;
                return newHead;
            }
        } else {
            ListNode pivot = head;
            ListNode curr = head.next;

            ListNode lHead, lTail, rHead, rTail;
            lHead = lTail = rHead = rTail = null;

            while (curr != null) {
                if (curr.val < pivot.val) {
                    if (lHead == null) {
                        lHead = curr;
                        lTail = curr;
                    } else {
                        lTail.next = curr;
                        lTail = lTail.next;
                    }
                } else {
                    if (rHead == null) {
                        rHead = curr;
                        rTail = curr;
                    } else {
                        rTail.next = curr;
                        rTail = rTail.next;
                    }
                }
                curr = curr.next;
            }
            if (rTail != null) rTail.next = null;
            if (lTail != null) lTail.next = null;
            return join(quickSort(lHead), quickSort(rHead), pivot);
        }
    }

    //Merge the list back together
    public ListNode join(ListNode lHead, ListNode rHead, ListNode pivot) {
        ListNode lTail = null;

        if (lHead != null) {
            ListNode curr = lHead;
            while (curr.next != null) {
                curr = curr.next;
            }
            lTail = curr;
        }

        //Left list is empty
        if (lHead == null) {
            pivot.next = rHead;
            return pivot;
        } else if (rHead == null) {
            //right list is empty
            lTail.next = pivot;
            pivot.next = null;
            return lHead;
        } else {
            lTail.next = pivot;
            pivot.next = rHead;

            return lHead;
        }
    }
}
