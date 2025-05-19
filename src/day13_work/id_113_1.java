package day13_work;

import java.util.ArrayList;
import java.util.List;

public class id_113_1 {
    private List<List<Integer>> ans = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    private int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        f(root,targetSum);
        return ans;
    }

    public void f(TreeNode node,int targetSum) {
        if (node == null) return;
        path.add(node.val);
        sum += node.val;
        if (node.left == node.right && sum == targetSum) {
            ans.add(new ArrayList<>(path));
        }else {
            f(node.left, targetSum);
            f(node.right, targetSum);
        }
        path.remove(path.size()-1);
        sum -= node.val;
    }

}
