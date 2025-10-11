package A_hot100;

public class id_23_2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    // 左闭右开
    public ListNode mergeKLists(ListNode[] lists,int left,int right) {
        int m = right - left;
        if(m == 0) return null;
        if(m == 1) return lists[left];
        ListNode left_node = mergeKLists(lists, left, left + m / 2);
        ListNode right_node = mergeKLists(lists, left + m / 2, right);
        return mergeTwoLists(left_node, right_node);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2; // 拼接剩余链表
        return dummy.next;
    }
}
