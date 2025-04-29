package day6_work;

// https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/2374872/tu-jie-die-dai-di-gui-yi-zhang-tu-miao-d-51ap/

public class id_24_2 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode node0 = dummy;
        ListNode node1 = node0.next;
        // example: dummy 1 2 3 4
        while (node1 != null && node1.next != null) {  // 当前节点有值并且当前节点的下一个节点有值
            ListNode node2 = node1.next; // 2
            ListNode node3 = node2.next; // 3
            node2.next = node1; // 2 -> 1
            node0.next = node2; // dummy -> 2
            node1.next = node3; // 1 -> 3
            node0 = node1; // 更换哨兵节点 为 1
            node1 = node3; // 更换第一个节点 为 3
        }
        return dummy.next;
    }

}
