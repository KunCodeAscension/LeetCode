package A_hot100;

public class id_21_1 {
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
