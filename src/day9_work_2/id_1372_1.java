package day9_work_2;

public class id_1372_1 {
    private int max = 0;

    public int longestZigZag(TreeNode root) {
        int left = longestZigZag2(root, true);
        int right = longestZigZag2(root, false);
        return Math.max(max, Math.max(left, right));
    }

    public int longestZigZag2(TreeNode root,boolean flag) {
        if (root == null) return 0;
        int left = longestZigZag2(root.left, false) + 1;
        int right = longestZigZag2(root.right, true) + 1;
        max = Math.max(max, Math.max(left, right));
        int count = flag ? left : right;
        return count;
    }

}
