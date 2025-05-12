package day10_work;

import java.util.*;

public class id_501_1 {
    private int MAX = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root,map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == MAX) {
                list.add(integerIntegerEntry.getKey());
            }else {
                break;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public void dfs(TreeNode root,Map<Integer, Integer> map) {
        if (root == null) return;
        dfs(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        MAX = Math.max(MAX,map.get(root.val));
        dfs(root.right, map);
    }

}
