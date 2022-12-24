package leetcode.all;

/**
 * 两两交换链表中的节点
 */
public class code0024_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; //base case
        ListNode nextEle = head.next;  // 记录下一个元素
        head.next = swapPairs(nextEle.next); // 我当前head的下一个元素要指向我下个元素的下个元素
        nextEle.next = head; // 我下个元素要指向我的head
        return nextEle; // 返回下个元素 也就是修改后的头指针
    }


     public class ListNode {
     int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
