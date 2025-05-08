package day9_work_2;

public class id_1026_1 {
    private int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiff2(root, root.val, root.val);
        return max;
    }

    public void maxAncestorDiff2(TreeNode root,int root_max,int root_min) {
        if (root == null) return;
        max = Math.max(max,Math.max(Math.abs(root_min - root.val), Math.abs(root_max - root.val)));
        root_max = Math.max(root_max,root.val);
        root_min = Math.min(root_min,root.val);
        maxAncestorDiff2(root.left,root_max,root_min);
        maxAncestorDiff2(root.right,root_max,root_min);
    }

}
