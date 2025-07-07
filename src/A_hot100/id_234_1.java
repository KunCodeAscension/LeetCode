package A_hot100;

public class id_234_1 {

    /**
     * 先快慢指针找到链表的中间节点，然后反转链表开始比对
     */
    public boolean isPalindrome(ListNode head) {
        ListNode midListNode = getMidListNode(head);
        ListNode head2 = reverse(midListNode);
        while(head2 != null) {
            if(head2.val != head.next.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode getMidListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
