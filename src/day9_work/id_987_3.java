package day9_work;

import java.util.ArrayList;
import java.util.List;

public class id_987_3 {

    /**
     * 简化，先添加到数组中，然后出来做排序，添加到结果数组的过程中，如果当前添加的数组col和前面的相等，直接添加下表为数组长度-1
     * 如果不相等，更新letcode的值，添加一个空数组，再把值添加进去
     */

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> data = new ArrayList<>();
        // 比较col的值，如果不相等按照col从小到大排序，如果相等按照row排序，row如果不相等，按照row从小到大排序，row如果相等按照值从小到大排序
        dfs(root,0,0,data);
        List<List<Integer>> ans = new ArrayList<>();
        data.sort((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] != o1[1] ? o1[1] - o2[1] : o1[2] - o2[2]);
        int letCode = Integer.MAX_VALUE;
        for (int[] an : data) {
            if(an[0] != letCode){
                letCode = an[0];
                ans.add(new ArrayList<>());
            }
            ans.get(ans.size() - 1).add(an[2]);
        }
        return ans;
    }

    public void dfs(TreeNode root,int row,int col,List<int[]> ans) {
        if(root==null) return;
        ans.add(new int[]{col,row,root.val});
        dfs(root.left,row + 1,col - 1,ans);
        dfs(root.right,row + 1,col + 1,ans);
    }

}
