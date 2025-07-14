package A_hot100;

public class id_148_1 {
    public ListNode sortList(ListNode head) {
        // 链表无节点或者只有一个节点 直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 将链表从中间分开 head原来为 1,2,3,4 分开后 head为 1,2 head2 为 3,4
        ListNode head2 = middleNode(head);
        // 分别对 head 和 head2 排序
        ListNode node1 = sortList(head2);
        ListNode node2 = sortList(head);
        // 将两个有序链表合并 leetcode-21
        return mergeTwoLists(node1, node2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode new_list = new ListNode(0,null);
        ListNode curr = new_list;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = new ListNode(list1.val,null);
                curr = curr.next;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                curr.next = new ListNode(list2.val,null);
                curr = curr.next;
                list2 = list2.next;
            } else {
                curr.next = new ListNode(list1.val,new ListNode(list2.val,null));
                curr = curr.next.next;
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        curr.next = list2 != null ? list2 : list1;
        return new_list.next;
    }
}
