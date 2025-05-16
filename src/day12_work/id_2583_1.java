package day12_work;

import java.util.*;

public class id_2583_1 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(sum);
        }
        int n = result.size();
        result.sort((Comparator.comparingLong(o -> o)));
        return n < k ? -1 : result.get(k-1);
    }

}
