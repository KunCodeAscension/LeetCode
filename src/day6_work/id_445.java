package day6_work;

public class id_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return reverseList(answerBeforeReverse(l1, l2,0));
    }

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

    public ListNode answerBeforeReverse(ListNode l1, ListNode l2,int target) {
        ListNode newListNode = new ListNode();
        if (l1 == null && l2 == null) {
            return target > 0 ? new ListNode(target) : null;
        }
        int count = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + target;
        int k = 0;
        newListNode.val = count > 9 ? count % 10 : count;
        if(count > 9) k = 1;
        newListNode.next = answerBeforeReverse(l1==null ? null:l1.next, l2==null ? null:l2.next,k);
        return newListNode;
    }
}
