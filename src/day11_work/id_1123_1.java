package day11_work;

import java.util.Map;

/**
 * 有递有归
 * 向下传递一个 depth 深度
 * 然后向上返回当前节点的最大深度，如果左右节点的深度和最大深度相同，说明遍历到当前位置，当前节点就是最大深度的公共祖先
 * 然后记录当前节点返回最大深度
 */

public class id_1123_1 {
    private int max = 0;
    private TreeNode ans = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode root,int depth) {
        if (root == null){
            max = Math.max(max,depth);
            return depth;
        };
        int left = dfs(root.left,depth+1);
        int right = dfs(root.right,depth+1);
        if(left == right && left == max){
            ans = root;
        }
        return Math.max(left,right);
    }


}
