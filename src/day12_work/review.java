package day12_work;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class review {

    /**
     * 优化方式：使用队列
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root);
        while(cur != null && !cur.isEmpty()) {
            int n = cur.size();
            List<TreeNode> next = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode node = cur.get(i);
                list.add(node.val);
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }
            ans.add(list);
            cur = next;
        }
        return ans;
    }

    /**
     * 找出左下角的值，也就是根据层序遍历，找到最后一层的第一个节点
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        q.add(root);
        while(!q.isEmpty()) {
            cur = q.poll();
            if(cur.right != null) q.add(cur.right);
            if(cur.left != null) q.add(cur.left);
        }
        return cur.val;
    }
}
