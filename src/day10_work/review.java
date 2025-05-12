package day10_work;

public class review {
    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
//        return dfs1(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return dfs2(root);
    }

    // 前序遍历 向下传递边界范围
    public boolean dfs1(TreeNode root,long left,long right) {
        if(root == null) return true;
        int x = root.val;
        return (x > left && x < right) && dfs1(root.left,left,x) && dfs1(root.right,x,right);
    }

    // 中序遍历 先递归左子树 在递归右子树，如果是二叉搜索树，那么遍历顺序应该是递增的
    public boolean dfs2(TreeNode root) {
        if(root == null) return true;
        if(!dfs2(root.left)) return false;
        if(root.val <= pre) return false;
        pre = root.val;
        return dfs2(root.right);
    }

    // 后续遍历 从下面向上传递范围 当前节点需要大于左边的最大值 小于右边的最小值
    public long[] dfs3(TreeNode root) {
        if(root == null) return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};
        long[] left = dfs3(root.left);
        long[] right = dfs3(root.right);
        if(root.val <= left[1] || root.val >= right[0]) return new long[]{Long.MIN_VALUE,Long.MAX_VALUE};
        else return new long[]{Math.min(left[0], root.val),Math.max(root.val,right[1])};
    }
}
