package day9_work;

public class id_129_1 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root,int k) {
        if(root == null) return 0;
        k = k * 10 + root.val;
        if(root.left == root.right) {
            return k;
        }
        return dfs(root.left, k) + dfs(root.right, k);
    }
}
