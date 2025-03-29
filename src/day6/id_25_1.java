package day6;

public class id_25_1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n ++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        while (n >= k) {
            n -= k;
            ListNode pre = null;
            cur = p0.next;
            for (int i = 1; i <= k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }
        return dummy.next;
    }
}
