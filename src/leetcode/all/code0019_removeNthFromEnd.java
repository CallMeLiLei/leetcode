package leetcode.all;

/**
 * 删除链表的倒数第N个节点
 * 1、遍历
 * 2、快慢指针
 */
public class code0019_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {   // 只有当删除倒数第一个节点是 fast才会为null
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public class ListNode {
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
}
