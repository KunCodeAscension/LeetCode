package day9_work_2;

public class id_951_1 {
    // 反转或者不翻转
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isSameTree(root1, root2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        if(p.val != q.val) return false;
        return (isSameTree(p.left, q.right) && isSameTree(p.right, q.left)) || (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
