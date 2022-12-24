package leetcode.all;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 * 优先队列
 */
public class code0023_mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        if (lists == null) return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> {  // 最小值
            return o1.val - o2.val;
        });
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }
        return dummy.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
