package day9_work;

import java.util.*;

public class id_987_1 {

    // https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/

    /**
     * 定义一个TreaMap key是col吧相同的col放在一起 value是List集合，集合中为数组
     * 先左右递归二叉树，把col相同的放到一起，int[]中放入 row 和 val
     * TreeMap很根据key从小到大排序，正好与题目排序规则相符，我们直接遍历获取到List<int[]> 排序，如果row不同暗中row的大小排序
     * 如果row的值相同，按照val的值排序，最后添加的结果中返回
     */

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<int[]>> map = new TreeMap<>();
        dfs(root,0,0,map);
        List<List<Integer>> ans = new ArrayList<>(map.size());
        for (List<int[]> value : map.values()) {
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

        group.computeIfAbsent(col,k->new ArrayList<>()).add(new int[]{row,root.val});
        dfs(root.left,row + 1,col - 1,group);
        dfs(root.right,row + 1,col + 1,group);
    }

}
