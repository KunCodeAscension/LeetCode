package day8_work;

import java.util.Arrays;

public class id_3217_1 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur.next != null) {
            if(Arrays.binarySearch(nums, cur.next.val) >= 0) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
