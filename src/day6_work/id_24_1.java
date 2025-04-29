package day6_work;

// https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/2374872/tu-jie-die-dai-di-gui-yi-zhang-tu-miao-d-51ap/


public class id_24_1 {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            cur = cur.next;
            ++n;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        ListNode curr = p0.next;
        ListNode prev = null;
        while(n >= 2){
            n -= 2;
            for (int i = 0; i < 2; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode dummy1 = p0.next;
            p0.next.next = curr;
            p0.next = prev;
            p0 = dummy1;
        }
        return dummy.next;
    }
}
