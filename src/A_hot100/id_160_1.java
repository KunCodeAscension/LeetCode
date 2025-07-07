package A_hot100;

public class id_160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListNodeLength(headA);
        int lenB = getListNodeLength(headB);
        if (lenA > lenB){
            int num = lenA - lenB;
            while (num > 0){
                headA = headA.next;
                num--;
            }
        }
        if (lenA < lenB){
            int num = lenB - lenA;
            while (num > 0){
                headB = headB.next;
                num--;
            }
        }
        return getSameListNode(headA, headB);
    }

    public ListNode getSameListNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        return getSameListNode(headA.next, headB.next);
    }

    public int getListNodeLength(ListNode node) {
        if(node == null) return 0;
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
