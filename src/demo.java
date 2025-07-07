public class demo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(LeafCount_BiTree(root));
    }

    public static void Delete(ListNode head,int min,int max) {
        if(head.next == null) return;
        ListNode prev = head;
        ListNode cur = head.next;
        // 找到满足要求的头结点
        while(cur != null && cur.val <= min) {
            prev = cur;
            cur = cur.next;
        }
        // 删除满足要求的节点
        while(cur != null && cur.val < max) {
            prev.next = cur.next;
            cur = prev.next;
        }
        System.out.println(head);
    }

    public static int LeafCount_BiTree(TreeNode node){
        if(node == null) return 0;
        int left = LeafCount_BiTree(node.left);
        int right = LeafCount_BiTree(node.right);
        if(left == 0 && right == 0) return 1;
        return left + right;
    }

}
