package day9;

public class id_110_1 {
    public boolean isBalanced(TreeNode root) {
        return get_height(root) != -1;
    }

    public int get_height(TreeNode root) {
        if(root == null) return 0;
        int left = get_height(root.left);
        if(left == -1) return -1;
        int right = get_height(root.right);
        if(right == -1 || Math.abs(right-left) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
