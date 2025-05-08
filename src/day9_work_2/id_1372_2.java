package day9_work_2;

public class id_1372_2 {
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left,0,true), dfs(root.right,0,false));
    }

    // true 为左 false 为右
    public int dfs(TreeNode root,int len,boolean flag) {
        if(root==null) return len;
        if(!flag){
            // 上一次转换方向为右，这一次只有向左len才能+1 向右重新计数
            return Math.max(dfs(root.left,len + 1,true),dfs(root.right,0,false));
        }else {
            // 上一次转换方向为左，这一次只有向右len才能+1 向左重新计数
            return Math.max(dfs(root.left, 0 ,true),dfs(root.right,len + 1,false));
        }
    }
}
