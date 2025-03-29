package day12;

import java.util.LinkedList;
import java.util.Queue;

public class id_513_2 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = null;
        queue.add(root);
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node.right != null) queue.add(node.right);
            if(node.left != null) queue.add(node.left);
        }
        return node.val;
    }
}
