import common.ListNode;

import java.util.List;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int step = n;
        ListNode fast = head;
        ListNode slow = head;
        while (step > 0) {
            fast = fast.next;
            step--;
        }

        ListNode pre = null;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return slow.next;
        } else {
            pre.next = slow.next;
        }
        return head;
    }
}
