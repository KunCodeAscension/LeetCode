package day9_work_2;

import java.util.*;

public class id_508_1 {
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findFrequentTreeSum2(root, map);
        List<Integer> list = new ArrayList<>();
        map.forEach((k, v) -> {
             if (v == max) list.add(k);
        });
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int findFrequentTreeSum2(TreeNode root,Map<Integer,Integer> map) {
        if (root == null) return 0;
        int count = findFrequentTreeSum2(root.left,map) + findFrequentTreeSum2(root.right,map) + root.val;
        map.put(count,map.getOrDefault(count,0) + 1);
        max = Math.max(max,map.get(count));
        return count;
    }
}
