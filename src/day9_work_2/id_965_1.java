package day9_work_2;

// https://leetcode.cn/problems/univalued-binary-tree/description/

public class id_965_1 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree2(root,root.val);
    }

    public boolean isUnivalTree2(TreeNode root,int target) {
        if(root == null) return true;
        if(root.val != target) return false;
        return isUnivalTree2(root.left, target) && isUnivalTree2(root.right, target);
    }
}
