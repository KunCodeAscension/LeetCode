package A_hot100;

public class id_114 {
    /**
     * 前序遍历 这里要记下 node.right 因为递归 node.left 的时候会修改 node.right 导致递归死循环
     */
    private TreeNode pre;

    public void flatten1(TreeNode node) {
        if (node == null) return;
        if (pre != null) {
            pre.left = null;
            pre.right = node;
        }
        pre = node;
        TreeNode right = node.right;
        flatten1(node.left);
        flatten1(right);
    }

    private TreeNode head;

    public void flatten2(TreeNode node) {
        if (node == null) return;
        flatten2(node.right);
        flatten2(node.left);
        node.right = head;
        node.left = null;
        head = node;
    }

    public void flatten3(TreeNode node) {
        TreeNode cur = node;
        while (cur != null) {
            TreeNode pre = cur.left;
            if(pre != null){
                while(pre.right != null) pre = pre.right;
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }


}
