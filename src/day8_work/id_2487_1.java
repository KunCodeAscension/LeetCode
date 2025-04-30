package day8_work;

public class id_2487_1 {
    public ListNode removeNodes(ListNode head) {
        ListNode reverHead = reverseKGroup(head);
        ListNode cur = reverHead;
        while (cur != null && cur.next != null) {
            if(cur.val > cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return reverseKGroup(reverHead);
    }

    public ListNode reverseKGroup(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
