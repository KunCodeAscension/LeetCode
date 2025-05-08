package day9_work_2;

public class id_1080_1 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) return null;
        limit -= root.val;
        if(root.left == null && root.right == null){
            return limit <= 0 ? root : null;
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);
        return root.left == null && root.right == null ? null : root;
    }

}
