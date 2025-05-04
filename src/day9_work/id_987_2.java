package day9_work;

import java.util.*;

public class id_987_2 {

    /**
     * 不使用TreeMap对key进行排序，而是每次记录col的最小值
     */

    private int minCode = Integer.MAX_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        dfs(root,0,0,map);
        List<List<Integer>> ans = new ArrayList<>(map.size());
        for (int i = minCode;i < map.size() + minCode;i++) {
            List<int[]> value = map.get(i);
            value.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> res = new ArrayList<>(value.size());
            for (int[] ints : value) {
                res.add(ints[1]);
            }
            ans.add(res);
        }
        return ans;
    }

    public void dfs(TreeNode root,int row,int col,Map<Integer,List<int[]>> group) {
        if(root == null) return;
        minCode = Math.min(minCode,col);
        group.computeIfAbsent(col,k->new ArrayList<>()).add(new int[]{row,root.val});
        dfs(root.left,row + 1,col - 1,group);
        dfs(root.right,row + 1,col + 1,group);
    }

}
