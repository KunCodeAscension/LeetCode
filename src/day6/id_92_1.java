package day6;

public class id_92_1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        for(int i=0; i<left-1; i++){
            p0 = p0.next;
        }
        ListNode cur = p0.next;
        ListNode pre = null;
        for(int i=1; i<=left-right+1; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
