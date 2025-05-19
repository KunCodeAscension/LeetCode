package day13;

import java.util.ArrayList;
import java.util.List;

public class id_78_2 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        path = new ArrayList<>();
        f(0);
        return ans;
    }

    public void f(int i) {
        ans.add(new ArrayList<>(path));
        if(i == nums.length){
            return;
        }
        for(int j = i;j < nums.length;j++){
            path.add(nums[j]);
            f(j + 1);
            path.remove(path.size() - 1);
        }
    }
}
