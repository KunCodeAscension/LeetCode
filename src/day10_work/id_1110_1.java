package day10_work;

import java.util.ArrayList;
import java.util.List;

public class id_1110_1 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        TreeNode dfs = dfs(root, res, to_delete);
        if(dfs != null) res.add(dfs);
        return res;
    }

    public TreeNode dfs(TreeNode root,List<TreeNode> res,int[] to_delete) {
        if(root == null) return null;
        if(isIn(root.val,to_delete)){
            TreeNode left = dfs(root.left, res, to_delete);
            TreeNode right = dfs(root.right, res, to_delete);
            if(left != null) res.add(left);
            if(right != null) res.add(right);
            return null;
        }
        return new TreeNode(root.val,dfs(root.left,res,to_delete),dfs(root.right,res,to_delete));
    }

    public boolean isIn(int num,int[] to_delete) {
        for (int i : to_delete) {
            if(i == num) return true;
        }
        return false;
    }

}
