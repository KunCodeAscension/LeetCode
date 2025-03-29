package day8;

public class id_19_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumny = new ListNode(0,head);
        ListNode right = dumny;
        for (int i = 1;i <= n;i++){
            right = right.next;
        }
        ListNode left = dumny;
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dumny.next;
    }
}
