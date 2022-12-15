package leetcode.all;

/**
 * 链表两数之和
 */
public class code0002_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode root = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int data1 = l1 != null ? l1.val : 0;
            int data2 = l2 != null ? l2.val : 0;
            int data = data1 + data2 + carry;
            int val = data % 10;
            carry = data / 10;
            root.next = new ListNode(val);
            root = root.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return ans.next;
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
