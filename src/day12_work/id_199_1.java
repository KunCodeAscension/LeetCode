package day12_work;

import java.util.ArrayList;
import java.util.List;

/**
 * 右视图，先递归右子树，再递归左子树，如何判断这个节点是否要加入答案当中呢？
 * 如果它的递归深度等于答案的长度，那么说明他是在右视图当中的
 */

public class id_199_1 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, 0, list);
        return list;
    }

    public void dfs(TreeNode root,int depth,List<Integer> list) {
        if(root == null) return;
        if(depth == list.size()) list.add(root.val);
        dfs(root.right,depth+1,list);
        dfs(root.left,depth+1,list);
    }

}
