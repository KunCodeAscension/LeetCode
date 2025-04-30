package day8_work;

public class review {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        while (head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        // 利用头结点一个个删除重复的元素
        while (curr.next != null && curr.next.next != null) {
            if(curr.next.val == curr.next.next.val) {
                int val = curr.next.val;
                while(curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

}
