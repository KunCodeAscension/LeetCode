package day12;

import java.util.ArrayList;
import java.util.List;

public class id_102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> nex = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for (TreeNode treeNode : cur) {
                vals.add(treeNode.val);
                if (treeNode.left != null) nex.add(treeNode.left);
                if (treeNode.right != null) nex.add(treeNode.right);
            }
            cur = nex;
            ans.add(vals);
        }
        return ans;
    }
}
