package A_hot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class id_102_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(root == null) return res;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size -= 1;
            }
            res.add(list);
        }
        return res;
    }
}
