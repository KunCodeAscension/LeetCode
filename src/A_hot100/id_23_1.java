package A_hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class id_23_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                // 将链表的头节点添加到最小堆当中
                pq.offer(list);
            }
        }
        // 哨兵节点
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        return dummyHead.next;
    }
}
