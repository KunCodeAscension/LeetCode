package A_hot100;

// 环形链表-2
public class id_142_1 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                // 有环
                ListNode temp = head;
                while(slow != temp){
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        // 无环
        return null;
    }
}
