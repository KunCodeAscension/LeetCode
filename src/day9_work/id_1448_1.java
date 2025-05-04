package day9_work;

// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/submissions/627061574/

public class id_1448_1 {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        int max = root.val;
        dfs(root, max);
        return count;
    }

    public void dfs(TreeNode root,int max) {
        if(root == null) return;
        if(root.val >= max) {
            max = root.val;
            count++;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
