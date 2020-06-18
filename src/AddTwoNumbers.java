public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode();
        ListNode r1 = result;

        int val1, val2;
        int carry = 0;

        do {
            val1 = (p1 == null) ? 0 : p1.val;
            val2 = (p2 == null) ? 0 : p2.val;

            int res = val1 + val2 + carry;
            if (res >= 10) {
                carry = res / 10;
                r1.val = res % 10;
            } else {
                carry = 0;
                r1.val = res;
            }

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            if (p1 != null || p2 != null || carry > 0) {
                r1.next = new ListNode();
                r1 = r1.next;
            }
        } while(p1 != null || p2 != null || carry > 0);

        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}