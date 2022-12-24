package leetcode.all;

/**
 * K个一组反转链表
 */
public class code0025_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nex = tail.next; // 拿到反转链表 下面的一个节点
            ListNode[] reverse = myReverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
        return new ListNode[]{tail,head};
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
