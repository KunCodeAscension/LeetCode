package A_hot100;

public class id_19_1 {
    /**
     * 快慢指针
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left =  dummy;
        ListNode right = dummy;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right.next != null) {
            right = right.next;
            left =  left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }

    /**
     * 递归-回溯的时候对节点进行计数
     */
    private int cnt = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        head.next = removeNthFromEnd(head.next, n);
        return ++cnt == n ? head.next : head;
    }

}
