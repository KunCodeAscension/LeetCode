package day10;

public class id_98_1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root,long left,long right) {
        if(root == null) return true;
        if(root.val <= left || root.val >= right) return false;
        return isValidBST2(root.left,left,root.val) && isValidBST2(root.right,root.val,right);
    }
}
