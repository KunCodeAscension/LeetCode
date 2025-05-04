package day9_work;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/

public class id_111_1 {
    /**
     * 二叉树从下往上递归
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null){
            return 1+minDepth(root.right);
        }
        if(root.right == null){
            return 1+minDepth(root.left);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
