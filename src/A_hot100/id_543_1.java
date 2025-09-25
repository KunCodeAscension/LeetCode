package A_hot100;

import day12.id_513_2;

public class id_543_1 {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        f(root);
        return ans;
    }

    public int f(TreeNode node){
        if(node == null) return 0;
        int left = f(node.left);
        int right = f(node.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}

