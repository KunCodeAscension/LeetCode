package day12_work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 先层序遍历，然后再反转列表
 */

public class id_107_1 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<TreeNode> cur = List.of(root);
        while (!cur.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size()); // 预分配空间
            int size = cur.size();
            for (TreeNode node : cur) {
                vals.add(node.val);
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            res.add(vals);
            cur = nxt;
        }
        Collections.reverse(res);
        return res;
    }

}
