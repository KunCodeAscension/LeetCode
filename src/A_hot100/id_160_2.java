package A_hot100;

public class id_160_2 {

    /**
     * A   1-2-7 \
     *           5-2-1-3
     * B 3-2-3-4 /
     *
     * 假设传入的链表A B 如上 链表A前端部分长X 链表B前端部分长Y 公共部分为Z
     * 那么 (x + y) + z = (y +z) + x
     * 即让A，B一直走下去指导终点然后A从B开始走 B从A开始走即可走到交点位置，如果AB不相交那么同时会走到 null 的位置
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while(p != q){
            p = p != null ? p.next: headB;
            q = q != null ? q.next: headA;
        }
        return p;
    }
}
