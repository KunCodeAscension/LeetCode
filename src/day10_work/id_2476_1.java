package day10_work;

import java.util.ArrayList;
import java.util.List;

// 先中序遍历转换为递增的数组 然后二分查找

public class id_2476_1 {
    private List<Integer> list = new ArrayList<>();

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        midSearch(root);
        int n = list.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = list.get(i); // 转成数组，效率更高
        }
        for (Integer query : queries) {
            int maxIndex = search(a, query);
            int max = maxIndex == n ? -1 : a[maxIndex];
            if(maxIndex == n || a[maxIndex] != query){
                maxIndex --;
            }
            int min = maxIndex < 0 ? -1 : a[maxIndex];
            ans.add(List.of(min, max));
        }
        return ans;
    }

    public void midSearch(TreeNode root){
        if(root == null) return;
        midSearch(root.left);
        list.add(root.val);
        midSearch(root.right);
    }

    public int search(int[] a, int target){
        int left = 0, right = a.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1; // 比 /2 快
            if(a[mid] >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
