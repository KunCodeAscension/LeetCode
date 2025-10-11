package A_hot100;

public class id_538_1 {
    private int num;

    public TreeNode convertBST(TreeNode root) {
        num = 0;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        node.val = node.val + num;
        num = node.val;
        dfs(node.left);
    }
}
