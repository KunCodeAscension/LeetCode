package day9_work_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class review {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSameTree2(root.left, root.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return isSameTree2(p.left, q.right) && isSameTree2(p.right, q.left) && p.val == q.val;
    }

    public boolean isBalanced(TreeNode root) {
        return Balanced(root) != -1;
    }

    public int Balanced(TreeNode root) {
        if (root == null) return 0;
        int left = Balanced(root.left);
        int right = Balanced(root.right);
        if(left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans,int deep) {
        if (root == null) return;
        if(deep == ans.size()) ans.add(root.val);
        dfs(root.right, ans, deep + 1);
        dfs(root.left, ans, deep + 1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == size - 1) ans.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return ans;
    }

}
