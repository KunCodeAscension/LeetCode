package day12;

import java.util.*;

public class id_103_1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean even = true;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> vals = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                vals.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (Boolean.FALSE.equals(even)) {
                Collections.reverse(vals);
            }
            ans.add(vals);
            even = !even;
        }
        return ans;
    }
}
