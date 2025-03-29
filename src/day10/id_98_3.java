package day10;

public class id_98_3 {
    public boolean isValidBST(TreeNode root) {
        return f(root)[1] != Long.MAX_VALUE;
    }

    public long[] f(TreeNode node){
        if(node == null) return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};
        long[] left = f(node.left);
        long[] right = f(node.right);
        if (node.val <= left[1] || node.val >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], node.val), Math.max(node.val, right[1])};
    }
}
