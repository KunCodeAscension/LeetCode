package day7_work;

public class id_2130_1 {
    public int pairSum(ListNode head) {
        ListNode mid = midKGroup(head);
        ListNode head2 = reverseKGroup(mid);
        int count = 0;
        while (head2 != null) {
            count = Math.max(count, head2.val+head.val);
            head2 = head2.next;
            head = head.next;
        }
        return count;
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

    public ListNode midKGroup(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
