package day7_work;

public class id_234_1 {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = midKGroup(head);
        ListNode head2 = reverseKGroup(mid);
        while (head2 != head || head2 != null) {
            if(head2.val != head.val) return false;
            head2 = head2.next;
            head = head.next;
        }
        return true;
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
