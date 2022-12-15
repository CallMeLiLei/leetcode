package leetcode.all;

/**
 * 合并两个有序链表
 */
public class code0021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // 链表题都来一个dummy节点吧
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        if (list1 != null) {
            cur.next = list1;
        }

        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
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
