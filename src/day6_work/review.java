package day6_work;

public class review {

    // 我们要做的是记录当前节点和当前节点的前一个节点，把当前节点的next改为上一个节点，记录原来的下一个节点
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode cur = p0.next;
        ListNode pre = null;
        for(int i = 0; i < right-left+1; i++){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy;
        ListNode curr = dummy.next;
        ListNode prev = null;
        while (n >= k) {
            n -= k;
            for (int i = 0; i < k; i++) {
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
