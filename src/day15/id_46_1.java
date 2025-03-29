package day15;

import java.util.*;

public class id_46_1 {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    Boolean[] onPath;
    int[] NUMS;

    public List<List<Integer>> permute(int[] nums) {
        path = Arrays.asList(new Integer[nums.length]);
        onPath = new Boolean[nums.length];
        this.NUMS = nums;
        dfs(0,onPath);
        return ans;
    }

    public void dfs(int i,Boolean[] onPath) {
        if (i == NUMS.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < NUMS.length; j++) {
            if (!onPath[j] == false) {
                onPath[j] = true;
                path.set(i,NUMS[j]);
                onPath[j] = false;
            }
        }
    }
}
