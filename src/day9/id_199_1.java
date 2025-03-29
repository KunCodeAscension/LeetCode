package day9;

import java.util.ArrayList;
import java.util.List;

public class id_199_1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        f(root,0,res);
        return res;
    }

    public void f(TreeNode node,Integer depth,List<Integer> res) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.val);
        f(node.right,depth+1,res);
        f(node.left,depth+1,res);
    }
}
