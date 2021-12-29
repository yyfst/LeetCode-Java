import common.ListNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-----------test---------------");
//        testThreeSum();

        testRemoveNthFromEnd();

    }

    public static void testThreeSum() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        LeetCode15 lc = new LeetCode15();
        List<List<Integer>> result = lc.threeSum(nums);
        System.out.println(result);
    }

    public static void testRemoveNthFromEnd() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LeetCode19 lc = new LeetCode19();

        ListNode res = lc.removeNthFromEnd(node1, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
