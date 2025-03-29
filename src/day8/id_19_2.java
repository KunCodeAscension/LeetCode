package day8;

// 递归
public class id_19_2 {
    int cur = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return head;
        }
        head.next = removeNthFromEnd(head.next,n);
        return ++cur == n ? head.next : head;
    }
}
