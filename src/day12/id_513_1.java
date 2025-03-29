package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class id_513_1 {
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> vals = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(vals);
        }
        return ans.get(ans.size() - 1).get(0);
    }
}
